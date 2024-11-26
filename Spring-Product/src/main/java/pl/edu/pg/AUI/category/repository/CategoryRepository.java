package pl.edu.pg.AUI.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.AUI.category.entity.Category;

import java.util.UUID;

/**
 * Repository for category entity. Repositories are used in business layer (services).
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
