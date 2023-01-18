package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.Person} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PersonCommentDTO implements Serializable {
    @Size(max = 60)
    private String email;
    @Size(max = 30)
    private String name;
    @Size(max = 50)
    private String surname;
    @Size(max = 30)
    private String username;
}