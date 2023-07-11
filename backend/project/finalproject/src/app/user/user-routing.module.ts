import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { DietpageComponent } from './dietpage/dietpage.component';
import { HomepageComponent } from './homepage/homepage.component';
import { OwndietpageComponent } from './owndietpage/owndietpage.component';
import { ForumpageComponent } from './forumpage/forumpage.component';
import { DietContentComponent } from './dietpage/diet-content/diet-content.component';
import { ProductInfoComponent } from './homepage/product-info/product-info.component';
import { ForumContentComponent } from './forumpage/forum-content/forum-content.component';
import { SuggestionsComponent } from './suggestions/suggestions.component';
import { AdminResponseComponent } from './suggestions/admin-response/admin-response.component';
import { LoginComponent } from '../login/login.component';


const routes: Routes = [
  {path:"",component:ToolbarComponent,
   children: [
    {path:"",component:HomepageComponent},
    {path:"home",component:HomepageComponent},
    {path:"dietpage",component:DietpageComponent},
    {path:"owndietpage",component:OwndietpageComponent},
    {path:"suggestionspage",component:SuggestionsComponent},
    {path:"forumpage",component:ForumpageComponent},
    {path:"diet-content/:id",component:DietContentComponent},
    {path:"product-info/:id",component:ProductInfoComponent},
    {path:"forum-content/:id",component:ForumContentComponent},
    {path:"admin_response/:id",component:AdminResponseComponent},
    {path:"login",component:LoginComponent}
   ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
