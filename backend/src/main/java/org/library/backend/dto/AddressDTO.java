package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.Address} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AddressDTO implements Serializable {
    private Integer id;
    private String additionalInfo;
    private String city;
    private String country;
    private String details;
    private Integer houseNumber;
    private String postalCode;
    private String street;
    private Integer streetNumber;
}