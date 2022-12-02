package org.library.backend.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Product {
    @Basic
    @Column(name = "Buy_price", nullable = true, precision = 0)
    private BigDecimal buyPrice;
    @Basic
    @Column(name = "Date_of_issue", nullable = true)
    private Date dateOfIssue;
    @Basic
    @Column(name = "Description", nullable = true, length = 250)
    private String description;
    @Basic
    @Column(name = "Rent_price", nullable = true, precision = 0)
    private BigDecimal rentPrice;
    @Basic
    @Column(name = "Title", nullable = true, length = 50)
    private String title;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductID", nullable = false)
    private int productId;
    @Basic
    @Column(name = "AuthorID", nullable = true)
    private Integer authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order orderID;

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
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

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (buyPrice != null ? !buyPrice.equals(product.buyPrice) : product.buyPrice != null) return false;
        if (dateOfIssue != null ? !dateOfIssue.equals(product.dateOfIssue) : product.dateOfIssue != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (rentPrice != null ? !rentPrice.equals(product.rentPrice) : product.rentPrice != null) return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (authorId != null ? !authorId.equals(product.authorId) : product.authorId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = buyPrice != null ? buyPrice.hashCode() : 0;
        result = 31 * result + (dateOfIssue != null ? dateOfIssue.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rentPrice != null ? rentPrice.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        return result;
    }
}
