package pl.edu.pg.AUI.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.category.repository.CategoryRepository;
import pl.edu.pg.AUI.category.service.api.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service layer for all business actions regarding product's profession entity.
 */
@Service
public class CategoryDefaultService implements CategoryService {
    /**
     * Repository for category
     */
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDefaultService(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    /**
     * @param id category id
     * @return Optional container with category
     */
    @Override
    public Optional<Category> find(UUID id){
        return categoryRepository.findById(id);
    }

    /**
     * Create new category
     * @param category new category
     */
    @Override
    public void create(Category category){
        categoryRepository.save(category);
    }

    /**
     * Delete category of given id
     * @param id category id
     */
    @Override
    public void delete(UUID id){
        categoryRepository.deleteById(id);
    }
}