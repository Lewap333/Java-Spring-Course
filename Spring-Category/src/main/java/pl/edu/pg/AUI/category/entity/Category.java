package pl.edu.pg.AUI.category.entity;

import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "category")
public class Category implements Serializable {
    /**
     * Unique id (primary key).
     */
    @Id
    private UUID id;

    /**
     * Category name
     */
    private String name;
    /**
     * Category discount
     */
    private Integer discount;
}
