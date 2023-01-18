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
    @Size(max = 75)
    private String additionalInfo;
    @Size(max = 50)
    private String city;
    @Size(max = 30)
    private String country;
    @Size(max = 50)
    private String details;
    private Integer houseNumber;
    @Size(max = 12)
    private String postalCode;
    @Size(max = 100)
    private String street;
    @Size(max = 12)
    private String streetNumber;
}