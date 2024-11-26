package pl.edu.pg.AUI.shop.dto;

import lombok.*;

import java.util.UUID;

/**
 * GetProductResponse contains all fields that can be presented to the user (not all of them can be changed).
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
public class GetProductResponse {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Category {
        /**
         * Unique id identifying category.
         */
        private UUID id;

        /**
         * Name of the category.
         */
        private String name;
    }

    /**
     * Unique id identifying product.
     */
    private UUID id;

    /**
     * Name of the product.
     */
    private String name;

    /**
     * Price of the product.
     */
    private int price;

    /**
     * Product's category.
     */
    private Category category;
}
