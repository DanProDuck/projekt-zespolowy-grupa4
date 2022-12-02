package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID", nullable = false)
    private Integer id;

    @Column(name = "Date_due_to")
    private LocalDate dateDueTo;

    @Column(name = "Date_rent_from")
    private LocalDate dateRentFrom;

    @Size(max = 50)
    @Column(name = "Description", length = 50)
    private String description;

    @Column(name = "Order_date")
    private LocalDate orderDate;

    @Column(name = "Quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    @JsonBackReference
    private Person personID;

    @OneToMany(mappedBy = "orderID")
    @JsonManagedReference
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "orderID")
    @JsonManagedReference
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "orderID")
    @JsonManagedReference
    private Set<OrderAddress> orderAddresses = new LinkedHashSet<>();

}