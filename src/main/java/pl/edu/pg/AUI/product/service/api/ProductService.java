package pl.edu.pg.AUI.product.service.api;

import pl.edu.pg.AUI.product.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    /**
     * Find all available products.
     */
    List<Product> findAll();

    /**
     * Find single product by id
     * @param id product's id
     * @return Optional container with product
     */
    Optional<Product> find(UUID id);

    /**
     * Create new product
     * @param product new product
     */
    void create(Product product);

    /**
     * Delete product of given id
     * @param id product's id
     */
    void delete(UUID id);

    /**
     * Update product of given id to the params given in updatedProduct
     * @param id product's id
     * @param updatedProduct product with updated params
     */
    void update(UUID id, Product updatedProduct);

    /**
     * @param categoryId
     * @return list of products of selected category
     */
    Optional<List<Product>> findAllByCategory(UUID categoryId);

    public List<Product> findAllWithCategory();
}
