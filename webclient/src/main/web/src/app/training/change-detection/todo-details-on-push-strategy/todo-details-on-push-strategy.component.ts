import {ChangeDetectionStrategy, Component, DoCheck, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Todo} from '../../shared/todo.model';

@Component({
  selector: 'app-todo-details-on-push-strategy',
  templateUrl: './todo-details-on-push-strategy.component.html',
  styleUrls: ['./todo-details--on-push-strategy.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TodoDetailsOnPushStrategyComponent implements OnInit, OnChanges, DoCheck {

  @Input()
  todo: Todo;

  changeDetectionCount = 0;
  doCheckCountOnPushStrategy = 0;

  constructor() {
  }

  ngOnInit() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.changeDetectionCount++;
  }

  ngDoCheck(): void {
    this.doCheckCountOnPushStrategy++;
  }

}
