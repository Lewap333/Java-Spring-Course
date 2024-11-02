package pl.edu.pg.AUI.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.product.entity.Category;
import pl.edu.pg.AUI.product.repository.api.CategoryRepository;
import pl.edu.pg.AUI.product.service.api.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
     * @return All categories list
     */
    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
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