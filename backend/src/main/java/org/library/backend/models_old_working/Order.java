package org.library.backend.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Order {
    @Basic
    @Column(name = "Date_due_to")
    private Date dateDueTo;
    @Basic
    @Column(name = "Date_rent_from")
    private Date dateRentFrom;
    @Basic
    @Column(name = "Description")
    private String description;
    @Basic
    @Column(name = "Order_date")
    private Date orderDate;
    @Basic
    @Column(name = "Quantity")
    private Integer quantity;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderID")
    private int orderId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<Address> addressesByOrderId;
    @ManyToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    private Person personByPersonId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderAddress> orderAddressesByOrderId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<Product> productsByOrderId;

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
        return orderId == order.orderId && Objects.equals(dateDueTo, order.dateDueTo) && Objects.equals(dateRentFrom, order.dateRentFrom) && Objects.equals(description, order.description) && Objects.equals(orderDate, order.orderDate) && Objects.equals(quantity, order.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateDueTo, dateRentFrom, description, orderDate, quantity, orderId);
    }

    public Collection<Address> getAddressesByOrderId() {
        return addressesByOrderId;
    }

    public void setAddressesByOrderId(Collection<Address> addressesByOrderId) {
        this.addressesByOrderId = addressesByOrderId;
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    public Collection<OrderAddress> getOrderAddressesByOrderId() {
        return orderAddressesByOrderId;
    }

    public void setOrderAddressesByOrderId(Collection<OrderAddress> orderAddressesByOrderId) {
        this.orderAddressesByOrderId = orderAddressesByOrderId;
    }

    public Collection<Product> getProductsByOrderId() {
        return productsByOrderId;
    }

    public void setProductsByOrderId(Collection<Product> productsByOrderId) {
        this.productsByOrderId = productsByOrderId;
    }
}
