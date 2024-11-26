package pl.edu.pg.AUI.shop.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.AUI.shop.dto.GetCategoriesResponse;
import pl.edu.pg.AUI.shop.dto.GetCategoryResponse;
import pl.edu.pg.AUI.shop.dto.PutCategoryRequest;

import java.util.UUID;

public interface CategoryController {

    @GetMapping("api/categories")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCategoriesResponse getCategories();

    @GetMapping("api/categories/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetCategoryResponse getCategory(
            @PathVariable("id")
            UUID id
    );

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
