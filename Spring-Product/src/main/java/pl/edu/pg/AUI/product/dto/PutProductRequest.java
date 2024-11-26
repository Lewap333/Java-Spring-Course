package pl.edu.pg.AUI.product.dto;

import lombok.*;

import java.util.UUID;

/**
 * PutProductRequest contains all fields that can be set up by the user while adding a new product.
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
public class PutProductRequest {

    /**
     * Name of the product.
     */
    private String name;
    /**
     * Product's price.
     */
    private Integer price;
    /**
     * ID of the product's category
     */
    private UUID category;
}
