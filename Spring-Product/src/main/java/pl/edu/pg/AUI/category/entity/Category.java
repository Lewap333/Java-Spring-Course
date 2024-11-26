package pl.edu.pg.AUI.category.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.edu.pg.AUI.product.entity.Product;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Entity class for product's categories.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "category")
public class Category implements Serializable {
    /**
     * Unique ID
     */
    @Id
    private UUID id;

    private String name;
    /**
     * List of products, not loaded from the database by default.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> productList;

}
