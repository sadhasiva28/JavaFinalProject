import { Component , Input} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-product-info',
  templateUrl: './product-info.component.html',
  styleUrls: ['./product-info.component.css']
})
export class ProductInfoComponent {
  id:any;
  productdata:any;
  constructor(private pd:ProductsService,private ar:ActivatedRoute){

    this.ar.params.subscribe(              
      {
        next: (params)=>{ 
         this.id =params['id']
         this.readData()
        },
        error: () => this.id = 0
      }
    )
 }

 readData() {
  if (this.id) {
    this.pd.getProductsbyId(this.id).subscribe({
      next: (data: any) => (this.productdata = data),
      error: (err) => this.productdata = [],
    });
  }
}
}
