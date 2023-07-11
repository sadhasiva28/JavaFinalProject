import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'productfilter'
})
export class ProductfilterPipe implements PipeTransform {

  transform(products: any, type: string): any {
    if(type=="All")
       return products;

    return products.filter((x:any)=>x.type == type)
  }


}
