import { Pipe, PipeTransform } from '@angular/core';
import { product } from '../admin/adminpage/add-product/add-product.component';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {
  transform(products: product[], searchTerm: string): product[] {
    if (!searchTerm) {
      return products;
    }
    searchTerm = searchTerm.toLowerCase();
    return products.filter(product =>
      product.name.toLowerCase().includes(searchTerm)
    );
  }
}
