package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @Size(max = 50)
    @Column(name = "Author_info", length = 50)
    private String authorInfo;

    @Column(name = "Date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "Date_of_death")
    private LocalDate dateOfDeath;

    @Size(max = 50)
    @Column(name = "Name", length = 50)
    private String name;

    @Size(max = 50)
    @Column(name = "Surname", length = 50)
    private String surname;

    @OneToMany(mappedBy = "authorID")
    @JsonManagedReference
    private Set<Product> products = new LinkedHashSet<>();

}