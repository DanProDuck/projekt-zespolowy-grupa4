package org.library.backend.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Category_name", length = 50)
    private String categoryName;

    @Size(max = 75)
    @Column(name = "Description", length = 75)
    private String description;

    @Size(max = 20)
    @NotNull
    @Column(name = "Type", nullable = false, length = 20)
    private String type;

    @ManyToMany
    @JoinTable(name = "ProductCategory",
            joinColumns = @JoinColumn(name = "CategoryID"),
            inverseJoinColumns = @JoinColumn(name = "ProductID"))
    private Set<Product> products = new LinkedHashSet<>();

}