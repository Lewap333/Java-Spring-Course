package pl.edu.pg.AUI.product.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.AUI.product.controller.api.ProductController;
import pl.edu.pg.AUI.product.dto.GetProductResponse;
import pl.edu.pg.AUI.product.dto.GetProductsResponse;
import pl.edu.pg.AUI.product.dto.PutProductRequest;
import pl.edu.pg.AUI.product.function.ProductToResponseFunction;
import pl.edu.pg.AUI.product.function.ProductsToResponseFunction;
import pl.edu.pg.AUI.product.function.RequestToProductFunction;
import pl.edu.pg.AUI.product.function.UpdateProductWithRequestFunction;
import pl.edu.pg.AUI.product.service.api.ProductService;

import java.util.UUID;

@RestController
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
