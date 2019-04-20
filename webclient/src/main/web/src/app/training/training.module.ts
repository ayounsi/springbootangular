import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {SimplePipe} from './shared/pure-pipe/simple.pipe';
import {SharedModule} from '../shared/shared.module';
import {TodoListComponent} from './change-detection/todo-list/todo-list.component';
import {TodoDetailsComponent} from './change-detection/todo-details/todo-details.component';
import {TodoDetailsOnPushStrategyComponent} from './change-detection/todo-details-on-push-strategy/todo-details-on-push-strategy.component';
import {TrainingRoutingModule} from './training-routing.module';

@NgModule({
  declarations: [
    SimplePipe,
    TodoListComponent,
    TodoDetailsComponent,
    TodoDetailsOnPushStrategyComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    TrainingRoutingModule
  ]
})
export class TrainingModule {

}
