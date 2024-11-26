package pl.edu.pg.AUI.category.event.api;

import pl.edu.pg.AUI.category.entity.Category;

import java.util.UUID;

/**
 * For sending events about category
 */
public interface CategoryEventRepository {
    /**
     * Delete category
     * @param id category id
     */
    void delete(UUID id);

    void save(Category category);
}
