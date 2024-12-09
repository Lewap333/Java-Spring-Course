import {Category} from '../../category/model/category';

export interface ProductDetails {
  /**
   * Unique id identifying product.
   */
  id: string;

  /**
   * Name of the product.
   */
  name: string;
  /**
    Product's price
  */
  price: number;
  /**
   * Product's category
   */
  category: Category;
}
