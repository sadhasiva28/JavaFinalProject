import { Component } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
  productslist:any;
  min:number=0;
  max:number=1000;
  types:string[]=[
    "All",
    "Electronics",
    "Cosmetics",
    "Groceries",
    "Books"
  ]
  selected:string="All"
  constructor(private ps:ProductService){

    this.ps.getproducts().subscribe({
      next:(data:any)=>this.productslist=data,
      error:()=>this.productslist=[]
    }
    )
  }

}
