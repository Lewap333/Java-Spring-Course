package pl.edu.pg.AUI.product.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.dto.PatchProductRequest;
import pl.edu.pg.AUI.product.entity.Product;

import java.util.function.BiFunction;

/**
 * Convert Product, PatchProductRequest to Product
 */
@Component
public class UpdateProductWithRequestFunction implements BiFunction<Product, PatchProductRequest, Product> {
    @Override
    public Product apply(Product entity, PatchProductRequest request) {
        return Product.builder()
                .id(entity.getId())
                .name(request.getName())
                .price(request.getPrice())
                .category(entity.getCategory())
                .build();
    }
}
