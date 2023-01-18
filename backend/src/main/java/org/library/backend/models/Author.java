package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Alternative_name", length = 50)
    private String alternativeName;

    @Size(max = 200)
    @Column(name = "Author_info", length = 200)
    private String authorInfo;

    @Column(name = "Date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "Date_of_death")
    private LocalDate dateOfDeath;

    @Size(max = 30)
    @Column(name = "Name", length = 30)
    private String name;

    @Size(max = 150)
    @Column(name = "Picture_url", length = 150)
    private String pictureUrl;

    @Size(max = 50)
    @Column(name = "Surname", length = 50)
    private String surname;

    @OneToMany(mappedBy = "authorID")
    @JsonManagedReference
    private Set<Product> products = new LinkedHashSet<>();

}