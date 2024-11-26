package pl.edu.pg.AUI.shop.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.shop.entity.Product;
import pl.edu.pg.AUI.shop.repository.api.CategoryRepository;
import pl.edu.pg.AUI.shop.repository.api.ProductRepository;
import pl.edu.pg.AUI.shop.service.api.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public void create(Product product) {   productRepository.save(product); }

    @Override
    public void delete(UUID id){ productRepository.deleteById(id); }

    @Override
    public void update(UUID id, Product updatedProduct) {
        Product existingProduct = find(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setPrice(updatedProduct.getPrice());

        productRepository.save(existingProduct);
    }
    @Override
    public Optional<List<Product>> findAllByCategory(UUID categoryId){
        return categoryRepository.findById(categoryId)
                .map(productRepository::findByCategory);
    }

    @Override
    public List<Product> findAllWithCategory() {
        return productRepository.findAllWithCategory();
    }
}
