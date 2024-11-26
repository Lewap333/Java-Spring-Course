package pl.edu.pg.AUI.shop.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.AUI.shop.controller.api.ProductController;
import pl.edu.pg.AUI.shop.dto.GetProductResponse;
import pl.edu.pg.AUI.shop.dto.GetProductsResponse;
import pl.edu.pg.AUI.shop.dto.PutProductRequest;
import pl.edu.pg.AUI.shop.function.ProductToResponseFunction;
import pl.edu.pg.AUI.shop.function.ProductsToResponseFunction;
import pl.edu.pg.AUI.shop.function.RequestToProductFunction;
import pl.edu.pg.AUI.shop.function.UpdateProductWithRequestFunction;
import pl.edu.pg.AUI.shop.service.api.ProductService;

import java.util.UUID;

@RestController
@Log
public class ProductDefaultController implements ProductController {

    /**
     * Service to manage products
     */
    private final ProductService service;
    /**
     * Converts Product to GetProductResponse
     */
    private final ProductToResponseFunction productToResponse;
    /**
     * Converts List<Products> to GetProductsResponse
     */
    private final ProductsToResponseFunction productsToResponse;
    /**
     * Converts PutProductRequest to Product
     */
    private final RequestToProductFunction requestToProduct;
    /**
     * Convert Product, PatchProductRequest to Product
     */
    private final UpdateProductWithRequestFunction updateProductWithRequest;

    @Autowired
    public ProductDefaultController(
            ProductService service,
            ProductToResponseFunction productToResponse,
            ProductsToResponseFunction productsToResponse,
            RequestToProductFunction requestToProduct,
            UpdateProductWithRequestFunction updateProductWithRequest) {
        this.service = service;
        this.productToResponse = productToResponse;
        this.productsToResponse = productsToResponse;
        this.requestToProduct = requestToProduct;
        this.updateProductWithRequest = updateProductWithRequest;
    }

    @Override
    public GetProductResponse getProduct(UUID id){
        return service.find(id).map(productToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetProductsResponse getProducts(){
        return productsToResponse.apply(service.findAll());
    }
    @Override
    public GetProductsResponse getCategoryProducts(UUID categoryId){
        return service.findAllByCategory(categoryId)
                .map(productsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @Override
    public void putProduct(UUID id, PutProductRequest request){
        service.create(requestToProduct.apply(id, request));
    }
    @Override
    public void deleteProduct(UUID id){
        service.find(id).ifPresentOrElse(
                product -> service.delete(id),
                () -> { throw  new ResponseStatusException(HttpStatus.NOT_FOUND);}
        );
    }
}
