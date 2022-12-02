package org.library.backend.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Order_address", schema = "public", catalog = "app_database_new")
public class OrderAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Order_addressID")
    private int orderAddressId;
    @OneToMany(mappedBy = "orderAddressByOrderAddressId")
    private Collection<Address> addressesByOrderAddressId;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID", nullable = false)
    private Order orderByOrderId;

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
        return orderAddressId == that.orderAddressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAddressId);
    }

    public Collection<Address> getAddressesByOrderAddressId() {
        return addressesByOrderAddressId;
    }

    public void setAddressesByOrderAddressId(Collection<Address> addressesByOrderAddressId) {
        this.addressesByOrderAddressId = addressesByOrderAddressId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
