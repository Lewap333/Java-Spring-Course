package pl.edu.pg.AUI.product.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * GetProductsResponse contains list of available products with their id's and names.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetProductsResponse {
    /**
     * Single product in the list
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Product {
        /**
         * Unique id identifying product.
         */
        private UUID id;

        /**
         * Name of the product.
         */
        private String name;
    }

    /**
     * Names of selected products list
     *
     * @Singular is used to allow adding products individually to the list
     *
     * GetProductsResponse response = GetProductsResponse.builder()
     *         .product(product1)
     *         .product(product2)
     *         .build();
     */
    @Singular
    private List<Product> products;
}
