package org.library.backend.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Product {
    @Basic
    @Column(name = "Buy_price")
    private BigInteger buyPrice;
    @Basic
    @Column(name = "Category")
    private String category;
    @Basic
    @Column(name = "Date_of_issue")
    private Date dateOfIssue;
    @Basic
    @Column(name = "Description")
    private String description;
    @Basic
    @Column(name = "Rent_price")
    private BigInteger rentPrice;
    @Basic
    @Column(name = "Title")
    private String title;
    @Basic
    @Column(name = "Type")
    private String type;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID")
    private int productId;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<Category> categoriesByProductId;
    @ManyToOne
    @JoinColumn(name = "AuthorID", referencedColumnName = "AuthorID")
    private Author authorByAuthorId;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order orderByOrderId;

    public BigInteger getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigInteger buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigInteger rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        Product product = (Product) o;
        return productId == product.productId && Objects.equals(buyPrice, product.buyPrice) && Objects.equals(category, product.category) && Objects.equals(dateOfIssue, product.dateOfIssue) && Objects.equals(description, product.description) && Objects.equals(rentPrice, product.rentPrice) && Objects.equals(title, product.title) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyPrice, category, dateOfIssue, description, rentPrice, title, type, productId);
    }

    public Collection<Category> getCategoriesByProductId() {
        return categoriesByProductId;
    }

    public void setCategoriesByProductId(Collection<Category> categoriesByProductId) {
        this.categoriesByProductId = categoriesByProductId;
    }

    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
