package pl.edu.pg.AUI.catalog;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Builder
@EqualsAndHashCode
public class ProductDto implements Comparable<ProductDto> {
    UUID id;
    String name;
    int price;
    String category;

    @Override
    public int compareTo(ProductDto o) {
        return this.name.compareTo(o.name);
    }
}
