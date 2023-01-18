package org.library.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link org.library.backend.models.Author} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AuthorDTO implements Serializable {
    private Integer id;
    @Size(max = 50)
    private String alternativeName;
    @Size(max = 200)
    private String authorInfo;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    @Size(max = 30)
    private String name;
    @Size(max = 150)
    private String pictureUrl;
    @Size(max = 50)
    private String surname;
}