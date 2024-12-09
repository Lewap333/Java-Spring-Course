import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { ProductViewComponent } from './product/view/product-view/product-view.component';
import { ProductListComponent } from './product/view/product-list/product-list.component';
import { ProductEditComponent } from './product/view/product-edit/product-edit.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {ProductService} from './product/service/product.service';
import {CategoryService} from './category/service/category.service';
import { CategoryListComponent } from './category/view/category-list/category-list.component';
import { CategoryViewComponent } from './category/view/category-view/category-view.component';
import { CategoryEditComponent } from './category/view/category-edit/category-edit.component';

@NgModule({
  bootstrap: [AppComponent],
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    ProductViewComponent,
    ProductListComponent,
    ProductEditComponent,
    CategoryListComponent,
    CategoryViewComponent,
    CategoryEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ProductService,
    CategoryService
  ]
})
export class AppModule { }
