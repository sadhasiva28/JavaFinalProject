import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { MaterialModule } from '../material/material.module';
import { AddResponseComponent } from './adminpage/add-response/add-response.component';
import { AddProductComponent } from './adminpage/add-product/add-product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SearchPipe } from '../pipes/search.pipe';
import { FormComponent } from './adminpage/add-product/form/form.component';
import { ResponseBoxComponent } from './adminpage/add-response/response-box/response-box.component';
import { ResponseFormComponent } from './adminpage/add-response/response-form/response-form.component';



@NgModule({
  declarations: [
    AdminpageComponent,
    AddResponseComponent,
    AddProductComponent,
    SearchPipe,
    FormComponent,
    ResponseBoxComponent,
    ResponseFormComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class AdminModule { }
