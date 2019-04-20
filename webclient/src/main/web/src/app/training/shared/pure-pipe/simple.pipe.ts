import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'myUpperCase'})
export class SimplePipe implements PipeTransform {

  transform(value: string, ...args: any[]): any {
    return value.toUpperCase();
  }

}
