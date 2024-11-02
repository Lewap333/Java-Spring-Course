package pl.edu.pg.AUI.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.product.entity.Category;
import pl.edu.pg.AUI.product.entity.Product;
import pl.edu.pg.AUI.product.repository.api.CategoryRepository;
import pl.edu.pg.AUI.product.repository.api.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class    ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<Product> findAllProducts() {
        return productRepository.findAllWithCategory();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
