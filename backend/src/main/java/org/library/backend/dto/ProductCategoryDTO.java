package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.ProductCategory} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductCategoryDTO implements Serializable {
    private CategoryDTO categoryID;
    private ProductListDTO productID;
}