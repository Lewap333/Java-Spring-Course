package pl.edu.pg.AUI.category.service.api;

import pl.edu.pg.AUI.category.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    /**
     * Find category of given id
     * @param id category id
     * @return Optional container with category
     */
    Optional<Category> find(UUID id);

    /**
     * Create a new category
     * @param category new category
     */
    void create(Category category);

    /**
     * @return List of all available categories
     */
    List<Category> findAll();

    /**
     * Delete category of given id
     * @param id category id
     */
    void delete(UUID id);

    /**
     * Create without sending message to product
     * @param category new category
     */
    void localCreate(Category category);
}
