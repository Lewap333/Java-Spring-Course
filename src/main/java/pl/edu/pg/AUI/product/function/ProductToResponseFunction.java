package pl.edu.pg.AUI.product.function;


import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.dto.GetProductResponse;
import pl.edu.pg.AUI.product.entity.Product;

import java.util.function.Function;

/**
 * Function interface used to convert Product to GetProductResponse
 */
@Component
public class ProductToResponseFunction implements Function<Product, GetProductResponse> {
    @Override
    public GetProductResponse apply(Product entity){
        return GetProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .category(GetProductResponse.Category.builder()
                        .id(entity.getCategory().getId())
                        .name(entity.getCategory().getName())
                        .build())
                .build();
    }
}
