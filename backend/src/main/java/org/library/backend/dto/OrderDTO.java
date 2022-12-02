package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link org.library.backend.models.Order} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDTO implements Serializable {
    private Integer id;
    private LocalDate dateDueTo;
    private LocalDate dateRentFrom;
    private String description;
    private LocalDate orderDate;
    private Integer quantity;
}