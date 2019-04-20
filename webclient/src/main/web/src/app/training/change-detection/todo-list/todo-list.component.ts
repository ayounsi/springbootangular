import {AfterContentChecked, Component, DoCheck, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {TodoService} from '../../shared/todo.service';
import {Observable} from 'rxjs';
import {Todo} from '../../shared/todo.model';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.scss'],
  // changeDetection: ChangeDetectionStrategy.OnPush
})
export class TodoListComponent implements OnInit, OnChanges, DoCheck, AfterContentChecked {

  todo$: Observable<Todo[]>;
  triggerCount = 0;
  selectedTodo: Todo;
  onChangeCount = 0;
  doCheckCount = 0;
  afterContentChecked = 0;

  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
    this.todo$ = this.todoService.getTodos();
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.onChangeCount++;
  }

  ngDoCheck(): void {
    this.doCheckCount++;
  }

  ngAfterContentChecked(): void {
    this.afterContentChecked++;
  }

  shortList() {
    this.todoService.shortList();
  }

  resetData() {
    this.todoService.reset();
  }

  addTodo() {
    this.todoService.addTodo();
  }

  triggerChange() {
    this.triggerCount++;
  }

  onSelect(event: Todo) {
    this.selectedTodo = event;
  }


}
