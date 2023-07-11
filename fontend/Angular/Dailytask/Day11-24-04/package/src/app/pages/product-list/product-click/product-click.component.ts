import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-click',
  templateUrl: './product-click.component.html',
  styleUrls: ['./product-click.component.css']
})
export class ProductClickComponent {
  id:any;
  product:any;
  details:any;
  productForm:any;
 constructor(private hs:ProductService,private ar:ActivatedRoute,private fb:FormBuilder){
    this.ar.params.subscribe(
      {
        next: (params)=>{ 
         this.id =params['id']
         this.readData()
        },
        error: () => this.id = 0
      }
    )
    this.productForm= this.fb.group({
      message:['',[Validators.required,Validators.minLength(30)]]

    });
   
    
    
 }



 readData(){

    this.hs.getproductsById(this.id).subscribe({
       next: (data:any)=> this.product=data,
       error: ()=> this.product = {}
    })

    this.hs.getdetails(this.id).subscribe({
        next: (data:any)=> this.details =data,
        error: ()=> this.details = {}
    })
 }


savedetails(){
  var temp:any={
    productid:this.id,
    message:this.productForm.value.message
  }
  this.hs.postdetails(temp).subscribe(
    {
      next:data=>{
        alert('your review is saved')
        location.reload();
      },
      error:(error)=>alert('not saved  ---some Error')
    }
   )
 }
}
