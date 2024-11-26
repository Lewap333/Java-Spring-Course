package pl.edu.pg.AUI.product.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.AUI.product.dto.GetProductResponse;
import pl.edu.pg.AUI.product.dto.GetProductsResponse;
import pl.edu.pg.AUI.product.dto.PutProductRequest;

import java.util.UUID;

public interface ProductController {

    /**
     * @param id Product's id
     * @return Single product
     */
    @GetMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductResponse getProduct(
            @PathVariable("id")
            UUID id
    );

    /**
     * @return list of products
     */
    @GetMapping("api/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getProducts();

    /**
     * @param categoryId Selected category id
     * @return List of products from a category
     */
    @GetMapping("api/categories/{categoryId}/products")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetProductsResponse getCategoryProducts(
            @PathVariable("categoryId")
            UUID categoryId
    );

    /**
     * @param uuid Product's id
     * @param request Create new product
     */
    @PutMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putProduct(
            @PathVariable("id")
            UUID uuid,
            @RequestBody
            PutProductRequest request
    );

    /**
     * Delete product of given id
     * @param uuid product's id
     */
    @DeleteMapping("api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(
            @PathVariable("id")
            UUID uuid
    );
}
