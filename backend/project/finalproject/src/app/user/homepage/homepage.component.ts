import { Component, EventEmitter, Output } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';
type format ={
  id: number,
  name:string,
  color:string,
  preparation_tips:string, 
  image:string, 
  serving_size:string
}
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent {
  enteredvalue:any;
  types: string[] = [
    "All",
    "vegetables",
    "fruits",
    "Meat",
    "Nuts",
    "Dairy"
  ]
  selected:string = 'All'
  products:any;
  constructor(private ps:ProductsService) { }

  ngOnInit(): void {
    this.ps.getProducts().subscribe(
      {
        next: (data:format[])=>this.products = data,
        error: ()=> this.products = []
       }
   )
      }
}
