package pl.edu.pg.AUI.category.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.AUI.category.dto.PutCategoryRequest;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.category.event.api.CategoryEventRepository;

import java.util.UUID;

@Repository
public class CategoryEventRestRepository implements CategoryEventRepository {

    private final RestTemplate restTemplate;
    @Autowired
    public CategoryEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID id){
        // calls delete at localhost:8081/api/categories/{id}
        restTemplate.delete("/api/categories/{id}", id);
    }

    @Override
    public void save(Category category) {
        // PUT to localhost:8081/api/categories/{id}
        PutCategoryRequest request = PutCategoryRequest.builder()
                .name(category.getName())
                .build();

        restTemplate.put("/api/categories/{id}", request, category.getId());
    }
}
