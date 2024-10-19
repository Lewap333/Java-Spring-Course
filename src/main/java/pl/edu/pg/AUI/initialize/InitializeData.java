package pl.edu.pg.AUI.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.catalog.Category;
import pl.edu.pg.AUI.catalog.Product;
import pl.edu.pg.AUI.service.CategoryService;
import pl.edu.pg.AUI.service.ProductService;

import java.util.ArrayList;
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
                .id(UUID.randomUUID())
                .name("Mobile Devices")
                .discount(10)
                .productList(new ArrayList<>())
                .build();

        Category computers = Category.builder()
                .id(UUID.randomUUID())
                .name("Computers & Laptops")
                .discount(5)
                .productList(new ArrayList<>())
                .build();

        // Create products
        Product lenovoYogaPro = Product.builder()
                .id(UUID.randomUUID())
                .name("Lenovo Yoga Pro")
                .price(8999)
                .category(computers)
                .build();

        Product appleMacBookAir = Product.builder()
                .id(UUID.randomUUID())
                .name("Apple MacBook Air")
                .price(5999)
                .category(computers)
                .build();

        Product iphone = Product.builder()
                .id(UUID.randomUUID())
                .name("iPhone 13")
                .price(2599)
                .category(mobileDevices)
                .build();

        // Add products to categories
        mobileDevices.getProductList().add(iphone);
        computers.getProductList().add(lenovoYogaPro);
        computers.getProductList().add(appleMacBookAir);

        // Save categories (cascade saves products)
        categoryService.saveCategory(mobileDevices);
        categoryService.saveCategory(computers);

        System.out.println("Initialize data complete.");
    }
}
