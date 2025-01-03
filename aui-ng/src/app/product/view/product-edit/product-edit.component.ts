import {Component, OnInit} from '@angular/core';
import {ProductForm} from '../../model/product-form';
import {Categories} from '../../../category/model/categories';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../../category/service/category.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit{

  uuid: string | undefined;

  product: ProductForm | undefined;

  original: ProductForm | undefined;

  categories: Categories | undefined;

  constructor(private productService: ProductService, private categoryService: CategoryService, private route: ActivatedRoute, private router:Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.categoryService.getCategories()
        .subscribe(categories => this.categories = categories);

      this.productService.getProduct(params['uuid'])
        .subscribe(product => {
          this.uuid = product.id;
          this.product = {
            name: product.name,
            price: product.price,
            category: product.category.id
          };
          this.original = {...this.product};
        });
    });
  }

  onSubmit(): void {
    this.productService.putProduct(this.uuid!, this.product!)
      .subscribe(() => this.router.navigate(['/products']));
  }
}
