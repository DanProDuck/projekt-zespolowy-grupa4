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
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonID", nullable = false)
    private Integer id;

    @Column(name = "Created_at")
    private LocalDate createdAt;

    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;

    @Size(max = 50)
    @Column(name = "Name", length = 50)
    private String name;

    @Size(max = 50)
    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "Phone_number")
    private Integer phoneNumber;

    @Size(max = 50)
    @Column(name = "Role", length = 50)
    private String role;

    @Size(max = 50)
    @Column(name = "Surname", length = 50)
    private String surname;

    @Column(name = "Updated_at")
    private LocalDate updatedAt;

    @Size(max = 50)
    @Column(name = "Username", length = 50)
    private String username;

    @OneToMany(mappedBy = "personID")
    @JsonManagedReference
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "personID")
    @JsonManagedReference
    private Set<Subscription> subscriptions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "personID")
    @JsonManagedReference
    private Set<PersonAddress> personAddresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "personID")
    @JsonManagedReference
    private Set<Registration> registrations = new LinkedHashSet<>();

}