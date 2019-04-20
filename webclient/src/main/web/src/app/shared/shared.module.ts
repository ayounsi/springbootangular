import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MaterialModule} from './material.module';
import {LayoutModule} from '@angular/cdk/layout';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    LayoutModule,
    MaterialModule
  ],
  exports: [
    CommonModule,
    LayoutModule,
    MaterialModule,
  ]
})
export class SharedModule {
}
