package pl.edu.pg.AUI.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pg.AUI.product.entity.Category;
import pl.edu.pg.AUI.product.entity.Product;
import pl.edu.pg.AUI.product.service.impl.CategoryDefaultService;
import pl.edu.pg.AUI.product.service.impl.ProductDefaultService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
public class CommandLineApp implements CommandLineRunner {
    private final CategoryDefaultService categoryService;
    private final ProductDefaultService productService;

    @Autowired
    public CommandLineApp(CategoryDefaultService categoryService, ProductDefaultService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Available Commands ---");
            System.out.println("1. List all categories");
            System.out.println("2. List all products");
            System.out.println("3. Add new product");
            System.out.println("4. Delete a product");
            System.out.println("5. Exit");
            System.out.print("Choose a command: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listCategories();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    addProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    System.out.println("Exit called..");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
        scanner.close();
    }

    private void listCategories() {
        List<Category> categories = categoryService.findAll();
        System.out.println("\n--- Categories ---");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    private void listProducts() {
        List<Product> products = productService.findAllWithCategory();
        System.out.println("\n--- Products ---");
        for (Product product : products) {
            String categoryName = product.getCategory() != null ? product.getCategory().getName() : "No Category";
            System.out.printf("Product: %s, Price: %d, Category: %s%n", product.getName(), product.getPrice(), categoryName);
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.println("\n--- Add New Product ---");

        listCategories();

        System.out.print("Enter the category name: ");
        String categoryName = scanner.nextLine();

        // Find category by name
        List<Category> categories = categoryService.findAll();
        Category selectedCategory = categories.stream()
                .filter(category -> category.getName().equalsIgnoreCase(categoryName))
                .findFirst()
                .orElse(null);

        if (selectedCategory == null) {
            System.out.println("Category not found. Creating product failed.");
            return;
        }

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        int productPrice = Integer.parseInt(scanner.nextLine());

        // Create new product
        Product newProduct = Product.builder()
                .id(UUID.randomUUID())
                .name(productName)
                .price(productPrice)
                .category(selectedCategory)
                .build();

        // Save product to db
        productService.create(newProduct);
        System.out.println("Product added successfully.");
    }

    private void deleteProduct(Scanner scanner) {
        System.out.println("\n--- Delete Product ---");

        listProducts();

        System.out.print("Enter the product name to delete: ");
        String productName = scanner.nextLine();

        // Find product by name
        List<Product> products = productService.findAll();
        Product selectedProduct = products.stream()
                .filter(prod -> prod.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

        if (selectedProduct == null) {
            System.out.println("Product not found. Delete failed.");
            return;
        }

        // Delete product from db
        productService.delete(selectedProduct.getId());
        System.out.println("Product deleted successfully.");
    }
}