package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Order {
    @Basic
    @Column(name = "Date_due_to", nullable = true)
    private Date dateDueTo;
    @Basic
    @Column(name = "Date_rent_from", nullable = true)
    private Date dateRentFrom;
    @Basic
    @Column(name = "Description", nullable = true, length = 250)
    private String description;
    @Basic
    @Column(name = "Order_date", nullable = true)
    private Date orderDate;
    @Basic
    @Column(name = "Quantity", nullable = true)
    private Integer quantity;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID", nullable = false)
    private int orderId;

    @OneToMany(mappedBy = "orderID")
    private Set<Product> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "orderID")
    @JsonManagedReference
    private Set<OrderAddress> orderAddresses = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    @JsonBackReference
    private Person personID;

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public Set<OrderAddress> getOrderAddresses() {
        return orderAddresses;
    }

    public void setOrderAddresses(Set<OrderAddress> orderAddresses) {
        this.orderAddresses = orderAddresses;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Date getDateDueTo() {
        return dateDueTo;
    }

    public void setDateDueTo(Date dateDueTo) {
        this.dateDueTo = dateDueTo;
    }

    public Date getDateRentFrom() {
        return dateRentFrom;
    }

    public void setDateRentFrom(Date dateRentFrom) {
        this.dateRentFrom = dateRentFrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;

        if (orderId == order.orderId) if (Objects.equals(dateDueTo, order.dateDueTo))
        if (Objects.equals(dateRentFrom, order.dateRentFrom)) if (Objects.equals(description, order.description))
        if (Objects.equals(orderDate, order.orderDate)) if (Objects.equals(quantity, order.quantity))
        return true;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDueTo, dateRentFrom, description, orderDate, quantity, orderId);
    }
}
