package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID", nullable = false)
    private Integer id;

    @Column(name = "Buy_price")
    private BigDecimal buyPrice;

    @Size(max = 50)
    @Column(name = "Category", length = 50)
    private String category;

    @Column(name = "Date_of_issue")
    private LocalDate dateOfIssue;

    @Size(max = 50)
    @Column(name = "Description", length = 50)
    private String description;

    @Column(name = "Rent_price")
    private BigDecimal rentPrice;

    @Size(max = 50)
    @Column(name = "Title", length = 50)
    private String title;

    @Size(max = 50)
    @Column(name = "Type", length = 50)
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AuthorID")
    @JsonBackReference
    private Author authorID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    @JsonBackReference
    private Order orderID;

    @OneToMany(mappedBy = "productID")
    @JsonManagedReference
    private Set<Category> categories = new LinkedHashSet<>();

}