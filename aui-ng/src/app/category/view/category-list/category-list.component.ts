import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category.service';
import {Categories} from '../../model/categories';
import {Category} from '../../model/category';
import {Product} from '../../../product/model/product';

@Component({
  selector: 'app-category-list',
  standalone: false,

  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent implements OnInit {

  /**
   * @param service category service
   */
  constructor(private service: CategoryService) {
  }

  /**
   * Available categories.
   */
  categories: Categories | undefined;

  ngOnInit(): void {
    this.service.getCategories().subscribe(categories => this.categories = categories);
  }

  /**
   * Deletes selected category.
   *
   * @param category to be removed
   */
  onDelete(category: Category): void {
    this.service.deleteCategory(category.id).subscribe(() => this.ngOnInit());
  }

}
