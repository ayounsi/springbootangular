import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort} from '@angular/material';
import {BookListDataSource} from './book-list-datasource';
import {BookService} from '../shared/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: BookListDataSource;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'title'];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.dataSource = new BookListDataSource(this.bookService, this.paginator, this.sort);
    this.dataSource.loadBooks();
  }

}
