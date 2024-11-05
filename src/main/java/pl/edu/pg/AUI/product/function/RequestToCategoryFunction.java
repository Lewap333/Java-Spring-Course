package pl.edu.pg.AUI.product.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.dto.PutCategoryRequest;
import pl.edu.pg.AUI.product.dto.PutProductRequest;
import pl.edu.pg.AUI.product.entity.Category;
import pl.edu.pg.AUI.product.entity.Product;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToCategoryFunction implements BiFunction<UUID, PutCategoryRequest, Category> {
    @Override
    public Category apply(UUID uuid, PutCategoryRequest entity) {
        return Category.builder()
                .id(uuid)
                .name(entity.getName())
                .discount(entity.getDiscount())
                .productList(new ArrayList<>())
                .build();
    }
}
