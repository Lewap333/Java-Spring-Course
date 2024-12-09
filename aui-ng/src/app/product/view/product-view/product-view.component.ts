import {Component, OnInit} from '@angular/core';
import {ProductDetails} from '../../model/product-details';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-view',
  standalone: false,

  templateUrl: './product-view.component.html',
  styleUrl: './product-view.component.css'
})
export class ProductViewComponent implements OnInit {
  /**
   * Single product
   */
  product: ProductDetails | undefined;

  constructor(private service: ProductService, private route: ActivatedRoute, private router:Router) {
  }
  // Searches for product of given id in backend and fills it's data
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getProduct(params['uuid'])
        .subscribe(product => this.product = product)
    });
  }
}
