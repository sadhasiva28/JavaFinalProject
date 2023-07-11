import { Component,Input } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent {
@Input() thisid:any;
review:any;
constructor(private ps:ProductService){
  this.ps.getreviews().subscribe(
    {
      next: (data:any)=>this.review=data,
      error:()=>this.review=[]
    }
  )
}
}
