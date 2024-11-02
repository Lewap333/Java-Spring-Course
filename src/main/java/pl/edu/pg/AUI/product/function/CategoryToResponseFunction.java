package pl.edu.pg.AUI.product.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.dto.GetCategoryResponse;
import pl.edu.pg.AUI.product.entity.Category;

import java.util.function.Function;

@Component
public class CategoryToResponseFunction implements Function<Category, GetCategoryResponse> {

    @Override
    public GetCategoryResponse apply(Category entity) {
        return GetCategoryResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .discount(entity.getDiscount())
                .build();
    }
}
