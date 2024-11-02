package pl.edu.pg.AUI.product.entity;

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
@Table(name = "product")
public class Product implements Serializable, Comparable<Product> {
    @Id
    @Column(name ="product_id", updatable = false, nullable = false)
    UUID id;
    @Column(name ="product_name")
    String name;
    @Column(name ="price")
    Integer price;
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    Category category;

    @Override
    public int compareTo(Product o) {
        int nameComparison = this.name.compareTo(o.name);
        if(nameComparison != 0){
            return nameComparison;
        }
        return Integer.compare(this.price, o.price);
    }
}
