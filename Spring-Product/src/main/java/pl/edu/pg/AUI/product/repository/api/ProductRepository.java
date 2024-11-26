package pl.edu.pg.AUI.product.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.pg.AUI.category.entity.Category;
import pl.edu.pg.AUI.product.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Find all products that share same category
     * @param category Product's category
     * @return
     */
    List<Product> findAllByCategory(Category category);

}
