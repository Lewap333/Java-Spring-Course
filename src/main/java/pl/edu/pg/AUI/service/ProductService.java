package pl.edu.pg.AUI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.catalog.Category;
import pl.edu.pg.AUI.catalog.Product;
import pl.edu.pg.AUI.repository.CategoryRepository;
import pl.edu.pg.AUI.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
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
    public Product findProductById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> findProductsByCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productRepository.findByCategory(category);
    }
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }
}
