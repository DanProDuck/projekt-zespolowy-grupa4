package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Order_address", schema = "public", catalog = "app_database")
public class OrderAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Order_addressID", nullable = false)
    private int orderAddressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    @JsonBackReference
    private Order orderID;

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public int getOrderAddressId() {
        return orderAddressId;
    }

    public void setOrderAddressId(int orderAddressId) {
        this.orderAddressId = orderAddressId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderAddress that = (OrderAddress) o;

        if (orderAddressId != that.orderAddressId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderAddressId;
        result = 31 * result;
        return result;
    }
}
