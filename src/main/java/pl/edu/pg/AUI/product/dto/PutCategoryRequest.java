package pl.edu.pg.AUI.product.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutCategoryRequest {

    String name;

    Integer discount;
}
