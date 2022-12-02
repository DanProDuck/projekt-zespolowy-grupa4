package org.library.backend.models;

import javax.persistence.*;

@Entity
public class Category {
    @Basic
    @Column(name = "Category_readable_name", nullable = true, length = 50)
    private String categoryReadableName;
    @Basic
    @Column(name = "Type", nullable = true, length = 30)
    private String type;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CategoryID", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "ProductID", nullable = false)
    private int productId;

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryId != category.categoryId) return false;
        if (productId != category.productId) return false;
        if (categoryReadableName != null ? !categoryReadableName.equals(category.categoryReadableName) : category.categoryReadableName != null)
            return false;
        if (type != null ? !type.equals(category.type) : category.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryReadableName != null ? categoryReadableName.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + productId;
        return result;
    }
}
