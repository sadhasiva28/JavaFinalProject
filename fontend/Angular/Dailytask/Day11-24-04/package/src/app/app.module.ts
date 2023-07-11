import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './materials/materials.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MainTopComponent } from './common/main-top/main-top.component';
import { HomeComponent } from './pages/home/home.component';
import { ProductListComponent } from './pages/product-list/product-list.component';
import { MainBarComponent } from './pages/product-list/main-bar/main-bar.component';
import { ProductPipe } from './pipe/product.pipe';
import { ComplaintComponent } from './pages/complaint/complaint.component';
import { PricerangePipe } from './pipe/pricerange.pipe';
import { ProductClickComponent } from './pages/product-list/product-click/product-click.component';
import { ReviewsComponent } from './pages/product-list/reviews/reviews.component';

@NgModule({
  declarations: [
    AppComponent,
    MainTopComponent,
    HomeComponent,
    ProductListComponent,
    MainBarComponent,
    ProductPipe,
    ComplaintComponent,
    PricerangePipe,
    ProductClickComponent,
    ReviewsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
