package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.Category} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CategoryDTO implements Serializable {
    private Integer id;
    @Size(max = 50)
    private String categoryName;
    @Size(max = 75)
    private String description;
    @Size(max = 20)
    @NotNull
    private String type;
}