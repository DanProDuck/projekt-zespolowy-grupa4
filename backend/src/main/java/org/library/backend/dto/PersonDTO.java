package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.Person} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PersonDTO implements Serializable {
    private String email;
    private String name;
    private String password;
    private Integer phoneNumber;
    private String surname;
    private String username;
    private int id;
}