package org.library.backend.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Category {
    @Basic
    @Column(name = "Category_readable_name")
    private String categoryReadableName;
    @Basic
    @Column(name = "Type")
    private String type;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CategoryID")
    private int categoryId;
    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
    private Product productByProductId;

    public String getCategoryReadableName() {
        return categoryReadableName;
    }

    public void setCategoryReadableName(String categoryReadableName) {
        this.categoryReadableName = categoryReadableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(categoryReadableName, category.categoryReadableName) && Objects.equals(type, category.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryReadableName, type, categoryId);
    }

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
