import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductViewComponent} from './product/view/product-view/product-view.component';
import {ProductListComponent} from './product/view/product-list/product-list.component';
import {ProductEditComponent} from './product/view/product-edit/product-edit.component';
import {CategoryListComponent} from './category/view/category-list/category-list.component';
import {CategoryViewComponent} from './category/view/category-view/category-view.component';
import {CategoryEditComponent} from './category/view/category-edit/category-edit.component';

const routes: Routes = [
  {
    component: ProductViewComponent,
    path: "products/:uuid"
  },
  {
    component: ProductListComponent,
    path: "products"
  },
  {
    component: ProductEditComponent,
    path: "products/:uuid/edit"
  },
  {
    component: CategoryListComponent,
    path: "categories"
  },
  {
    component: CategoryViewComponent,
    path: "categories/:uuid"
  },
  {
    component: CategoryEditComponent,
    path: "categories/:uuid/edit"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
