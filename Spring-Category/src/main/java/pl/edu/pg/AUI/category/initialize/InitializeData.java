package pl.edu.pg.AUI.category.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.category.service.impl.CategoryDefaultService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final CategoryDefaultService categoryDefaultService;

    @Autowired
    public InitializeData(CategoryDefaultService categoryDefaultService) {
        this.categoryDefaultService = categoryDefaultService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Category mobileDevices = Category.builder()
                .id(UUID.fromString("0b38eb32-3cb3-458a-adc4-eb4dbed679d0"))
                .name("Mobile Devices")
                .discount(10)
                .build();

        Category computers = Category.builder()
                .id(UUID.fromString("833716b6-7c43-4af9-81c2-988857039853"))
                .name("Computers & Laptops")
                .discount(5)
                .build();

        categoryDefaultService.create(mobileDevices);
        categoryDefaultService.create(computers);
    }
}
