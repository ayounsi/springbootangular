import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private httpClient: HttpClient) {
  }

  // TODO make url endpoint parametrized
  findAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>('http://localhost:8080/api/v1/products');
  }
}
