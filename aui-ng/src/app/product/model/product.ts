
import {Category} from '../../category/model/category';
/*
  Single product in the list
 */
export interface Product {
  /*
    Unique id
   */
  id:string;
  /*
    Product name
   */
  name: string;
  /*
    Product's category
   */
  category: Category;
}
