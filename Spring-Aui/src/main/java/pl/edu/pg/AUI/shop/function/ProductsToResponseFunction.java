package pl.edu.pg.AUI.shop.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.shop.dto.GetProductsResponse;
import pl.edu.pg.AUI.shop.entity.Product;

import java.util.List;
import java.util.function.Function;

/**
 * Convert list of products to GetProductsResponse
 */
@Component
public class ProductsToResponseFunction implements Function<List<Product>, GetProductsResponse> {

    @Override
    public GetProductsResponse apply(List<Product> entities) {
        return GetProductsResponse.builder().products(entities.stream()
                .map(product -> GetProductsResponse.Product.builder()
                        .id(product.getId())
                        .name(product.getName()).
                        build())
                .toList())
                .build();
    }
}
