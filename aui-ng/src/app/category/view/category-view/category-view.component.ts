import { Component } from '@angular/core';
import {CategoryDetails} from '../../model/category-details';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Products} from '../../../product/model/products';
import {ProductService} from '../../../product/service/product.service';
import {Product} from '../../../product/model/product';

@Component({
  selector: 'app-category-view',
  standalone: false,

  templateUrl: './category-view.component.html',
  styleUrl: './category-view.component.css'
})
export class CategoryViewComponent {

  /**
   * Single category
   */
  category: CategoryDetails | undefined;

  products: Products | undefined;

  constructor(private productService: ProductService,private service: CategoryService, private route: ActivatedRoute, private router:Router) {
  }
  // Searches for product of given id in backend and fills it's data
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getCategory(params['uuid'])
        .subscribe(category => this.category = category)
    });

    this.route.params.subscribe(params =>{
      this.productService.getProductsByCategory(params['uuid'])
        .subscribe(products => this.products = products)
    });
  }

  onDelete(product: Product): void {
    this.productService.deleteProduct(product.id).subscribe(() => this.ngOnInit());
  }
}
