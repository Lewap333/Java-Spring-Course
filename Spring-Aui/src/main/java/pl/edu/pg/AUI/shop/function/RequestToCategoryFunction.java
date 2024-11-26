package pl.edu.pg.AUI.shop.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.shop.dto.PutCategoryRequest;
import pl.edu.pg.AUI.shop.entity.Category;

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
