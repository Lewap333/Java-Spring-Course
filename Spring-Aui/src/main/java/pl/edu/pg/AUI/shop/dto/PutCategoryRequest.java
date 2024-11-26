package pl.edu.pg.AUI.shop.dto;

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
