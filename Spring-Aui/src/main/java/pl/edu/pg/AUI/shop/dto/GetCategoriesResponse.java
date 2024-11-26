package pl.edu.pg.AUI.shop.dto;

/**
 * GetCategoriesResponse returns names of available categories.
 * For info on how Category class is defined:
 *      pl.edu.pg.AUI.product.entity.Category
 */

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetCategoriesResponse {
    /**
     * Single category in the list
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Category{
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
     * List of all categories
     * */
    private List<Category> categories;
}
