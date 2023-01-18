package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.library.backend.util.constants.ProductType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link org.library.backend.models.Product} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDTO implements Serializable {
    private Integer id;
    private BigDecimal buyPrice;
    private LocalDate dateOfIssue;
    @Size(max = 50)
    private String description;
    @Size(max = 50)
    private String pictureUrl;
    private Integer quantity;
    private BigDecimal rating;
    private BigDecimal rentPrice;
    @Size(max = 50)
    private String title;
    private ProductType type;
    @NotNull
    private AuthorDTO authorID;
    private Set<CategoryDTO> categories = new LinkedHashSet<>();
    private Set<CommentDTO> comments = new LinkedHashSet<>();
}