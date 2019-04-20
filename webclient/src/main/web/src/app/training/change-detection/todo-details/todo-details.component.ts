import {Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Todo} from '../../shared/todo.model';

@Component({
  selector: 'app-todo-details',
  templateUrl: './todo-details.component.html',
  styleUrls: ['./todo-details.component.scss']
})
export class TodoDetailsComponent implements OnInit, OnChanges, DoCheck {

  @Input()
  todo: Todo;

  changeDetectionCount = 0;
  doCheckCount = 0;

  constructor() {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.changeDetectionCount++;
  }

  ngDoCheck(): void {
    this.doCheckCount++;
  }

}
