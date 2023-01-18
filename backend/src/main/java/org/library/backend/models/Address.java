package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID", nullable = false)
    private Integer id;

    @Size(max = 75)
    @Column(name = "Additional_info", length = 75)
    private String additionalInfo;

    @Size(max = 50)
    @Column(name = "City", length = 50)
    private String city;

    @Size(max = 30)
    @Column(name = "Country", length = 30)
    private String country;

    @Size(max = 50)
    @Column(name = "Details", length = 50)
    private String details;

    @Column(name = "House_number")
    private Integer houseNumber;

    @Size(max = 12)
    @Column(name = "Postal_code", length = 12)
    private String postalCode;

    @Size(max = 100)
    @Column(name = "Street", length = 100)
    private String street;

    @Size(max = 12)
    @Column(name = "Street_number", length = 12)
    private String streetNumber;

    @OneToMany(mappedBy = "addressID")
    @JsonManagedReference
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "addressID")
    @JsonManagedReference
    private Set<Person> people = new LinkedHashSet<>();

}