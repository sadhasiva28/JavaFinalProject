import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { MaterialModule } from '../material/material.module';
import { DietpageComponent } from './dietpage/dietpage.component';
import { DietBoxComponent } from './dietpage/diet-box/diet-box.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ForumpageComponent } from './forumpage/forumpage.component';
import { OwndietpageComponent } from './owndietpage/owndietpage.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { DietContentComponent } from './dietpage/diet-content/diet-content.component';
import { ProductComponent } from './homepage/product/product.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from '../common/common.module';
import { TypefilterPipe } from '../pipes/typefilter.pipe';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { ProductInfoComponent } from './homepage/product-info/product-info.component';
import { ForumBoxComponent } from './forumpage/forum-box/forum-box.component';
import { ForumContentComponent } from './forumpage/forum-content/forum-content.component';
import { SuggestionsComponent } from './suggestions/suggestions.component';
import { SuggestionBoxComponent } from './suggestions/suggestion-box/suggestion-box.component';
import { FormComponent } from './suggestions/form/form.component';
import { AdminResponseComponent } from './suggestions/admin-response/admin-response.component';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http,'./assets/i18n/','.json');
}

@NgModule({
  declarations: [
    ToolbarComponent,
    DietpageComponent,
    DietBoxComponent,
    HomepageComponent,
    ForumpageComponent,
    OwndietpageComponent,
    DietContentComponent,
    ProductComponent,
    TypefilterPipe,
    ProductInfoComponent,
    ForumBoxComponent,
    ForumContentComponent,
    SuggestionsComponent,
    SuggestionBoxComponent,
    FormComponent,
    AdminResponseComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    SharedModule,
    DragDropModule,
    ReactiveFormsModule,
    SharedModule,
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
      }
  })
  ]
})
export class UserModule { }
