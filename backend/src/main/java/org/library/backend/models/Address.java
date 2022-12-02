package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Size(max = 50)
    @Column(name = "Additional_info", length = 50)
    private String additionalInfo;

    @Size(max = 50)
    @Column(name = "City", length = 50)
    private String city;

    @Size(max = 50)
    @Column(name = "Country", length = 50)
    private String country;

    @Size(max = 50)
    @Column(name = "Details", length = 50)
    private String details;

    @Column(name = "House_number")
    private Integer houseNumber;

    @Size(max = 50)
    @Column(name = "Postal_code", length = 50)
    private String postalCode;

    @Size(max = 50)
    @Column(name = "Street", length = 50)
    private String street;

    @Column(name = "Street_number")
    private Integer streetNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Person_addressID", nullable = false)
    @JsonBackReference
    private PersonAddress personAddressid;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Order_addressID", nullable = false)
    @JsonBackReference
    private OrderAddress orderAddressid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    @JsonBackReference
    private Order orderID;

}