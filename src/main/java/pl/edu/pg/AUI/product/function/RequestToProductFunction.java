package pl.edu.pg.AUI.product.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.dto.PutProductRequest;
import pl.edu.pg.AUI.product.entity.Category;
import pl.edu.pg.AUI.product.entity.Product;

import java.util.UUID;
import java.util.function.BiFunction;

/**
 * Convert product request to Product entity, id isn't created in this function.
 */
@Component
public class RequestToProductFunction implements BiFunction<UUID, PutProductRequest, Product> {
    @Override
    public Product apply(UUID uuid, PutProductRequest request) {
        return Product.builder()
                .id(uuid)
                .name(request.getName())
                .price(request.getPrice())
                .category(Category.builder()
                        .id(request.getCategory())
                        .build())
                .build();
    }
}
