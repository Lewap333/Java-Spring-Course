package pl.edu.pg.AUI.category.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.AUI.category.dto.PutCategoryRequest;

import java.util.UUID;

public interface CategoryController {
    /**
     * Delete category and it's products
     * @param id category id
     */
    @DeleteMapping("api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCategory(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("api/categories/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putCategory(
            @PathVariable("id")
            UUID uuid,
            @RequestBody
            PutCategoryRequest request
    );
}
