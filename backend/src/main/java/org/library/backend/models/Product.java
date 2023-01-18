package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.library.backend.util.constants.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
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

    @Column(name = "Date_of_issue")
    private LocalDate dateOfIssue;

    @Size(max = 50)
    @Column(name = "Description", length = 50)
    private String description;

    @Column(name = "Is_for_rent")
    private Boolean isForRent;

    @Column(name = "Is_on_sale")
    private Boolean isOnSale;

    @Size(max = 50)
    @Column(name = "Picture_url", length = 50)
    private String pictureUrl;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Rating")
    private BigDecimal rating;

    @Column(name = "Rent_price")
    private BigDecimal rentPrice;

    @Size(max = 50)
    @Column(name = "Title", length = 50)
    private String title;

    @Column(name = "Type", length = 50)
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AuthorID", nullable = false)
    @JsonBackReference
    private Author authorID;

    @OneToMany(mappedBy = "productID")
    @JsonManagedReference
    private Set<Order> orders = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "ProductCategory",
            joinColumns = @JoinColumn(name = "ProductID"),
            inverseJoinColumns = @JoinColumn(name = "CategoryID"))
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "productID")
    @JsonManagedReference
    private Set<Bookmark> bookmarks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "productID")
    @JsonManagedReference
    private Set<Comment> comments = new LinkedHashSet<>();

}