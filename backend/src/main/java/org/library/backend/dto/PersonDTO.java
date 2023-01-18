package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.library.backend.util.constants.PersonRole;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link org.library.backend.models.Person} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PersonDTO implements Serializable {
    private Integer id;
    private Instant createdAt;
    @Size(max = 60)
    private String email;
    private Boolean isEnabled;
    private Boolean isRestricted;
    @Size(max = 30)
    private String name;
    private Integer phoneNumber;
    @Size(max = 17)
    private PersonRole role;
    @Size(max = 50)
    private String surname;
    private Instant updatedAt;
    @Size(max = 30)
    private String username;
}