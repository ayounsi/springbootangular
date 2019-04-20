import {Injectable} from '@angular/core';
import {Todo} from './todo.model';
import {BehaviorSubject, Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  TODO_LIST: Todo[] = [
    {
      id: 1,
      name: 'Task 1',
      description: 'Description 1'
    },
    {
      id: 2,
      name: 'Task 2',
      description: 'Description 2'
    },
    {
      id: 3,
      name: 'Task 3',
      description: 'Description 3'
    },
    {
      id: 4,
      name: 'Task 4',
      description: 'Description 4'
    },
    {
      id: 5,
      name: 'Task 5',
      description: 'Description 5'
    },
    {
      id: 6,
      name: 'Task 6',
      description: 'Description 6'
    }
  ];

  private todoList = [...this.TODO_LIST];
  private todoListBehaviorSubject = new BehaviorSubject<Todo[]>(this.todoList);
  todoList$ = this.todoListBehaviorSubject.asObservable();

  constructor() {
  }

  getTodos(): Observable<Todo[]> {
    return this.todoList$;
  }

  shortList() {
    this.todoList = this.todoList.slice(0, 1);
    this.reloadData();
  }

  addTodo() {
    this.todoList.push({...this.TODO_LIST[3]});
    this.reloadData();
  }

  reset() {
    this.todoList = [...this.TODO_LIST];
    this.reloadData();
  }

  private reloadData() {
    this.todoListBehaviorSubject.next(this.todoList);
  }
}
