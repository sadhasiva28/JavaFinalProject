import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { AddResponseComponent } from './adminpage/add-response/add-response.component';
import { AddProductComponent } from './adminpage/add-product/add-product.component';
import { ResponseFormComponent } from './adminpage/add-response/response-form/response-form.component';
import { LoginComponent } from '../login/login.component';

const routes: Routes = [
  {path:"",component:AdminpageComponent},
  {path:"add-response",component:AddResponseComponent},
  {path:"add-product",component:AddProductComponent},
  {path:"response-form/:id",component:ResponseFormComponent},
  {path:"login",component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
