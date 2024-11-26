package pl.edu.pg.AUI.product.dto;

import lombok.*;
/**
 * PatchProductRequest contains all fields that can be updated by the user.
 * For info on how Product class is defined:
 *      pl.edu.pg.AUI.product.entity.Product
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchProductRequest {
    /**
     * Name of the product.
     */
    private String name;
    /**
     * Product's price.
     */
    private Integer price;
}
