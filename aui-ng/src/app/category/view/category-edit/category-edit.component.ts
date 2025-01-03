import { Component } from '@angular/core';
import {ProductForm} from '../../../product/model/product-form';
import {Categories} from '../../model/categories';
import {ProductService} from '../../../product/service/product.service';
import {CategoryService} from '../../service/category.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryForm} from '../../model/category-form';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent {

  uuid: string | undefined;

  category: CategoryForm | undefined;

  original: CategoryForm | undefined;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute, private router:Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.categoryService.getCategory(params['uuid'])
        .subscribe(category => {
          this.uuid = category.id;
          this.category = {
            name: category.name,
            discount: category.discount,
          };
          this.original = {...this.category};
        });
    });
  }

  onSubmit(): void {
    this.categoryService.putCategory(this.uuid!, this.category!)
      .subscribe(() => this.router.navigate(['/categories']));
  }
}
