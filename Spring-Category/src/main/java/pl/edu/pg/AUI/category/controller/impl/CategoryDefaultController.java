package pl.edu.pg.AUI.category.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.AUI.category.controller.api.CategoryController;
import pl.edu.pg.AUI.category.dto.GetCategoriesResponse;
import pl.edu.pg.AUI.category.dto.GetCategoryResponse;
import pl.edu.pg.AUI.category.dto.PutCategoryRequest;
import pl.edu.pg.AUI.category.function.CategoriesToResponseFunction;
import pl.edu.pg.AUI.category.function.CategoryToResponseFunction;
import pl.edu.pg.AUI.category.function.RequestToCategoryFunction;
import pl.edu.pg.AUI.category.service.impl.CategoryDefaultService;

import java.util.UUID;

@RestController
@Log
public class  CategoryDefaultController implements CategoryController {
    /**
     * Service to manage categories
     */
    private final CategoryDefaultService service;
    /**
     * Convert category to GetCategoryResponse
     */
    private final CategoryToResponseFunction categoryToResponse;
    /**
     * Convert List<Category> to GetCategoriesResponse
     */
    private final CategoriesToResponseFunction categoriesToResponse;

    private final RequestToCategoryFunction requestToCategory;

    @Autowired
    public CategoryDefaultController(
            CategoryDefaultService service,
            CategoryToResponseFunction categoryToResponse,
            CategoriesToResponseFunction categoriesToResponse,
            RequestToCategoryFunction requestToCategory) {
        this.service = service;
        this.categoryToResponse = categoryToResponse;
        this.categoriesToResponse = categoriesToResponse;
        this.requestToCategory = requestToCategory;
    }

    @Override
    public GetCategoryResponse getCategory(UUID id){
        return service.find(id)
                .map(categoryToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @Override
    public GetCategoriesResponse getCategories(){
        return categoriesToResponse.apply(service.findAll());
    }

    @Override
    public void deleteCategory(UUID id){
        service.find(id).ifPresentOrElse(
                category -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @Override
    public void putCategory(UUID id, PutCategoryRequest request) {
        service.create(requestToCategory.apply(id, request));
    }
}
