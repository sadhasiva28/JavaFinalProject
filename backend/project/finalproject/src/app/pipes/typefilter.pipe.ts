import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'typefilter'
})
export class TypefilterPipe implements PipeTransform {

  transform(categories: any, type: string): any {
    if(type=="All")
       return categories;

    return categories.filter((x:any)=>x.type == type)
  }
}
