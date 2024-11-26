package pl.edu.pg.AUI.product.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.category.service.api.CategoryService;
import pl.edu.pg.AUI.product.entity.Product;
import pl.edu.pg.AUI.category.service.impl.CategoryDefaultService;
import pl.edu.pg.AUI.product.service.api.ProductService;
import pl.edu.pg.AUI.product.service.impl.ProductDefaultService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public InitializeData(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // Create product categories
        Category mobileDevices = Category.builder()
                .id(UUID.fromString("0b38eb32-3cb3-458a-adc4-eb4dbed679d0"))
                .name("Mobile Devices")
                .build();

        Category computers = Category.builder()
                .id(UUID.fromString("833716b6-7c43-4af9-81c2-988857039853"))
                .name("Computers & Laptops")
                .build();

        categoryService.create(mobileDevices);
        categoryService.create(computers);

        // Create products
        Product lenovoYogaPro = Product.builder()
                .id(UUID.fromString("5e0dde89-a72d-488d-bd38-fc640778aba1"))
                .name("Lenovo Yoga Pro")
                .price(8999)
                .category(computers)
                .build();

        Product appleMacBookAir = Product.builder()
                .id(UUID.fromString("771901b8-61dd-4b66-b782-2b227599129c"))
                .name("Apple MacBook Air")
                .price(5999)
                .category(computers)
                .build();

        Product iphone = Product.builder()
                .id(UUID.fromString("4446af8b-58f4-4b64-844f-b3c5834e2dd9"))
                .name("iPhone 13")
                .price(2599)
                .category(mobileDevices)
                .build();

        productService.create(lenovoYogaPro);
        productService.create(appleMacBookAir);
        productService.create(iphone);

    }
}
