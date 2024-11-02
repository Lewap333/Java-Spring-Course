package pl.edu.pg.AUI.product.dto;

import lombok.*;

import java.util.UUID;

/**
 * GetCategoryResponse includes details about selected category.
 * For info on how Category class is defined:
 *      pl.edu.pg.AUI.product.entity.Category
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCategoryResponse {
    /**
     * Unique id identifying category.
     */
    private UUID id;

    /**
     * Name of the category.
     */
    private String name;

    /**
     * Discount for the category.
     */
    private Integer discount;
}
