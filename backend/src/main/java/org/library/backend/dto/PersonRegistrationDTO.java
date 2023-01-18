package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.library.backend.util.validator.MatchingPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link org.library.backend.models.Person} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@MatchingPassword
public class PersonRegistrationDTO implements Serializable {
    //@Email annotation allows intranet domain names, e.g. name@domain
    @Email(message = "Provided email is not in valid format")
    @NotEmpty(message = "Email can not be empty")
    private String email;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters long")
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    private String repeatedPassword;

    @NotEmpty(message = "Surname can not be empty")
    @Size(min = 2, max = 30, message = "Surname should be between 2 and 30 characters long")
    private String surname;

    @NotEmpty(message = "Username can not be empty")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters long")
    private String username;
}