package pl.edu.pg.AUI.product.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.product.entity.Product;
import pl.edu.pg.AUI.category.repository.CategoryRepository;
import pl.edu.pg.AUI.product.repository.api.ProductRepository;
import pl.edu.pg.AUI.product.service.api.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * Service layer for all business actions regarding product entity.
 */
@Service
public class ProductDefaultService implements ProductService {
    /**
     * repository for product
     */
    private final ProductRepository productRepository;
    /**
     * repository for category
     */
    private final CategoryRepository categoryRepository;
    @Autowired
    public ProductDefaultService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> findAll(){

        return productRepository.findAll();
    }
    @Override
    public Optional<Product> find(UUID id){

        return productRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(UUID id){
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product updatedProduct) {
        productRepository.save(updatedProduct);
    }
    @Override
    public Optional<List<Product>> findAllByCategory(UUID categoryId){
        return categoryRepository.findById(categoryId)
                .map(productRepository::findAllByCategory);
    }

}
