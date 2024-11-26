package pl.edu.pg.AUI.category.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.category.dto.GetCategoriesResponse;
import pl.edu.pg.AUI.category.entity.Category;

import java.util.List;
import java.util.function.Function;

@Component
public class CategoriesToResponseFunction implements Function<List<Category>, GetCategoriesResponse> {
    @Override
    public GetCategoriesResponse apply(List<Category> entities) {
        return GetCategoriesResponse.builder().categories(entities.stream()
                .map(category -> GetCategoriesResponse.Category.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList()).build();
    }
}
