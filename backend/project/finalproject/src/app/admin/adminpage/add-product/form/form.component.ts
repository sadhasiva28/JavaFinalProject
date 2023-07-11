import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';
import { FormControl } from '@angular/forms';
@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  image:any;
  name: string = "";
  color: string = "";
  serving_size:any;
  type:any;
  fiber:any;
  sugar:any;
  fat:any;
  calories:any;
  vitamins: any = [];
  minerals: any = [];
  carbohydrates:any;
  proteins:any;
  preparation_tips: string = "";
  category: string = "";
  errors: string[] = [];
  productslist:any;

  toppings = new FormControl('');
  toppingList:string[] = ["Iron", "Calcium", "Magnesium", "Potassium", "Zinc"];
  selectedVitamins = new FormControl('');
  vitaminList:string[] = ["A", "B1", "B2", "B3", "C", "D","E","K"];
  constructor(private ps:ProductsService){
    this.ps.getProducts().subscribe({
      next: (data: any) => (this.productslist = data),
      error: (err) => this.productslist = [],
    });

    this.toppings.valueChanges.subscribe(values => {
      this.minerals = values;
    });
    this.selectedVitamins.valueChanges.subscribe(values => {
      this.vitamins = values;
    })
  }

  submit() {
    this.errors = [];

    if (this.name == undefined || this.name.length < 3)
      this.errors.push("First name should be greater than 3 characters");
    if (this.color == undefined || this.color.length < 3)
      this.errors.push("Last name should be greater than 3 characters");
    if (this.preparation_tips == undefined || this.preparation_tips.length < 30)
      this.errors.push("Message should be greater than 15 characters");
      if (this.image == undefined)
      this.errors.push("Image field need to fill");
      if (this.serving_size == undefined)
      this.errors.push("Serving size should to fill");
      if (this.carbohydrates == undefined)
      this.errors.push("Carbohydrates should be filled");
      if (this.vitamins == undefined)
      this.errors.push("Vitamins should be selected");
      if (this.minerals == undefined)
      this.errors.push("Minerals should be selected");
      if (this.fiber == undefined)
      this.errors.push("Fiber should be filled");
      if (this.sugar == undefined)
      this.errors.push("Sugar should be filled");
      if (this.fat == undefined)
      this.errors.push("Fat should be filled");
      if (this.type == undefined)
      this.errors.push("Type should be selected");
      if (this.calories == undefined)
      this.errors.push("Calories should be filled");
      if (this.proteins == undefined)
      this.errors.push("Proteins should be filled");
    console.log('Errors:', this.errors);
    
    if (this.errors.length == 0) {
      let obj = {
        id: this.productslist.length + 1,
        type: this.type,
        name: this.name,
        color: this.color,
        vitamins: this.vitamins,
        minerals: this.minerals,
        calories: this.calories,
        protein:this.proteins,
        carbohydrates: this.carbohydrates,
        fiber: this.fiber,
        sugar:this.sugar,
        fat:this.fat,
        serving_size: this.serving_size,
        image: this.image,
        preparation_tips: this.preparation_tips
      }

      console.log('Object:', obj);

      this.ps.postProduct(obj).subscribe({
        next: () => {
          console.log('Product added successfully!');
          alert("Your product has been added successfully");
          this.name = "";
          this.color = "";
          this.preparation_tips = "";
          this.category = "";
          location.reload();
        },
        error: () => {
          console.log('There was a problem adding your product!');
          alert("There was a problem adding your product");
        }
      });
    }
  }
}
