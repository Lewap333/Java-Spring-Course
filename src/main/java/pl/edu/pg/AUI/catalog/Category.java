package pl.edu.pg.AUI.catalog;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
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
public class Category implements Serializable, Comparable<Category> {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;
    @Column(name ="category_name")
    String name;
    @Column(name ="discount")
    int discount;
    @ToString.Exclude
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> productList;

    @Override
    public int compareTo(Category o) {
        return this.name.compareTo(o.name);
    }
}
