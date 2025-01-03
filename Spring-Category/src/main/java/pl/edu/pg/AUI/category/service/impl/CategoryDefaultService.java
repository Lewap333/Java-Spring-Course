package pl.edu.pg.AUI.category.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.category.event.api.CategoryEventRepository;
import pl.edu.pg.AUI.category.repository.api.CategoryRepository;
import pl.edu.pg.AUI.category.service.api.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryDefaultService implements CategoryService {
    /**
     * Repository for category
     */
    private final CategoryRepository categoryRepository;

    /**
     * Sending events about categories
     */
    private final CategoryEventRepository eventRepository;

    @Autowired
    public CategoryDefaultService(CategoryRepository repository, CategoryEventRepository eventRepository) {
        this.categoryRepository = repository;
        this.eventRepository = eventRepository;
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
        eventRepository.save(category);
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
        eventRepository.delete(id);
    }

    @Override
    public void localCreate(Category category){
        categoryRepository.save(category);
    }
}