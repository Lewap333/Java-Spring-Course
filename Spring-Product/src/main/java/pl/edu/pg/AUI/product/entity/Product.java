package pl.edu.pg.AUI.product.entity;

import jakarta.persistence.*;
import lombok.*;
import pl.edu.pg.AUI.category.entity.Category;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     * Unique id (primary key).
     */
    @Id
    private UUID id;
    /**
     * Product's name
     */
    private String name;
    /**
     * Product's price
     */
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
