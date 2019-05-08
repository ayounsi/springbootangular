import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient: HttpClient) {
  }

  // TODO make url endpoint parametrized
  findAllBooks(): Observable<Book[]> {
    return this.httpClient.get<Book[]>('http://localhost:8080/api/v1/books');
  }
}
