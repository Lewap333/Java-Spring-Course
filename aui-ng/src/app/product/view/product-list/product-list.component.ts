import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Products} from '../../model/products';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  standalone: false,

  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit{

  /**
   * @param service products service
   */
  constructor(private service: ProductService) {
  }

  /**
   * Available products.
   */
  products: Products | undefined;

  ngOnInit(): void {
    this.service.getProducts().subscribe(products => this.products = products);
  }

  /**
   * Deletes selected product.
   *
   * @param product to be removed
   */
  onDelete(product: Product): void {
    this.service.deleteProduct(product.id).subscribe(() => this.ngOnInit());
  }

}
