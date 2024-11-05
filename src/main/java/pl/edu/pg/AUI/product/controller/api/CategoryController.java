package pl.edu.pg.AUI.product.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.AUI.product.dto.GetCategoriesResponse;
import pl.edu.pg.AUI.product.dto.GetCategoryResponse;
import pl.edu.pg.AUI.product.dto.PutCategoryRequest;
import pl.edu.pg.AUI.product.dto.PutProductRequest;

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