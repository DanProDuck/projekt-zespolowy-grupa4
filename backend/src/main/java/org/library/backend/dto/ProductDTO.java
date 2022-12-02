package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
    private String category;
    private LocalDate dateOfIssue;
    private String description;
    private BigDecimal rentPrice;
    private String title;
    private String type;
}