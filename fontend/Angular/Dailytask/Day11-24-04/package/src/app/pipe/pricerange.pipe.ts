import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pricerange'
})
export class PricerangePipe implements PipeTransform {

  transform(productslist: any, min: any, max:any): any{
    return productslist.filter(
      (x:any)=>(x.price>=min)&&(x.price<=max)
    )
  }

}
