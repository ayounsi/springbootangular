import {DataSource} from '@angular/cdk/collections';
import {MatPaginator, MatSort} from '@angular/material';
import {finalize, map} from 'rxjs/operators';
import {BehaviorSubject, merge, Observable} from 'rxjs';
import {Product} from '../shared/product';
import {ProductsService} from '../shared/products.service';
import {catchError} from 'rxjs/internal/operators/catchError';
import {of} from 'rxjs/internal/observable/of';


// TODO: replace this with real data from your application
const EXAMPLE_DATA: Product[] = [
  {id: 1, businessKey: 1, name: 'Hydrogen'},
  {id: 2, businessKey: 2, name: 'Helium'},
  {id: 3, businessKey: 3, name: 'Lithium'},
  {id: 4, businessKey: 4, name: 'Beryllium'},
  {id: 5, businessKey: 5, name: 'Boron'},
  {id: 6, businessKey: 6, name: 'Carbon'},
  {id: 7, businessKey: 7, name: 'Nitrogen'},
  {id: 8, businessKey: 8, name: 'Oxygen'},
  {id: 9, businessKey: 9, name: 'Fluorine'},
  {id: 10, businessKey: 10, name: 'Neon'},
  {id: 11, businessKey: 11, name: 'Sodium'},
  {id: 12, businessKey: 12, name: 'Magnesium'},
  {id: 13, businessKey: 13, name: 'Aluminum'},
  {id: 14, businessKey: 14, name: 'Silicon'},
  {id: 15, businessKey: 15, name: 'Phosphorus'},
  {id: 16, businessKey: 16, name: 'Sulfur'},
  {id: 17, businessKey: 17, name: 'Chlorine'},
  {id: 18, businessKey: 18, name: 'Argon'},
  {id: 19, businessKey: 19, name: 'Potassium'},
  {id: 20, businessKey: 20, name: 'Calcium'},
];

/**
 * Data source for the ProductList view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class ProductListDataSource extends DataSource<Product> {

  private productsSubject = new BehaviorSubject<Product[]>(EXAMPLE_DATA);
  private loadingSubject = new BehaviorSubject<boolean>(false);

  public loading$ = this.loadingSubject.asObservable();

  constructor(private productsService: ProductsService, private paginator: MatPaginator, private sort: MatSort) {
    super();
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<Product[]> {
    // Combine everything that affects the rendered data into one update
    // stream for the data-table to consume.
    const dataMutations = [
      this.productsSubject.asObservable(),
      this.paginator.page,
      this.sort.sortChange
    ];

    // Set the paginator's length
    this.paginator.length = this.productsSubject.value.length;

    return merge(...dataMutations).pipe(map(() => {
      return this.getPagedData(this.getSortedData([...this.productsSubject.value]));
    }));
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect() {
    this.productsSubject.complete();
    this.loadingSubject.complete();
  }

  loadProducts() {
    this.loadingSubject.next(true);
    this.productsService.findAllProducts()
      .pipe(
        catchError(() => of([])),
        finalize(() => this.loadingSubject.next(false))
      )
      .subscribe(products => this.productsSubject.next(products));
  }

  /**
   * Paginate the data (client-side). If you're using server-side pagination,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getPagedData(data: Product[]) {
    const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
    return data.splice(startIndex, this.paginator.pageSize);
  }

  /**
   * Sort the data (client-side). If you're using server-side sorting,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getSortedData(data: Product[]) {
    if (!this.sort.active || this.sort.direction === '') {
      return data;
    }

    return data.sort((a, b) => {
      const isAsc = this.sort.direction === 'asc';
      switch (this.sort.active) {
        case 'name':
          return compare(a.name, b.name, isAsc);
        case 'id':
          return compare(+a.id, +b.id, isAsc);
        default:
          return 0;
      }
    });
  }
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a, b, isAsc) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
