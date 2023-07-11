import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { ComplaintComponent } from './pages/complaint/complaint.component';
import { ProductClickComponent } from './pages/product-list/product-click/product-click.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"productslist",component:ProductListComponent},
  {path:"Complaint",component:ComplaintComponent},
  {path: "details/:id", component:ProductClickComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
