import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ProductsService } from 'src/app/services/products.service';
import { FormComponent } from './form/form.component'; 

export type product = {
  name: string;
  image: string;
}

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
  providers: []
})
export class AddProductComponent {
  selected:any;
  Allproducts: product[] = [];

  constructor(private ps: ProductsService, public dialog: MatDialog) {
    this.ps.getProducts().subscribe({
      next: (data: any) => (this.Allproducts = data),
      error: (err) => this.Allproducts = [],
    });
  }

  openDialog() {
    this.dialog.open(FormComponent);
  }
}
