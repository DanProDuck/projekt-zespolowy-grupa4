package org.library.backend.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @Basic
    @Column(name = "Additional_info")
    private String additionalInfo;
    @Basic
    @Column(name = "City")
    private String city;
    @Basic
    @Column(name = "Country")
    private String country;
    @Basic
    @Column(name = "Details")
    private String details;
    @Basic
    @Column(name = "House_number")
    private Integer houseNumber;
    @Basic
    @Column(name = "Postal_code")
    private String postalCode;
    @Basic
    @Column(name = "Street")
    private String street;
    @Basic
    @Column(name = "Street_number")
    private Integer streetNumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AddressID")
    private int addressId;
    @Basic
    @Column(name = "Person_addressID")
    private int personAddressId;
    @Basic
    @Column(name = "Order_addressID")
    private int orderAddressId;
    @ManyToOne
    @JoinColumn(name = "Person_addressID", referencedColumnName = "Person_addressID", nullable = false)
    private PersonAddress personAddressByPersonAddressId;
    @ManyToOne
    @JoinColumn(name = "Order_addressID", referencedColumnName = "Order_addressID", nullable = false)
    private OrderAddress orderAddressByOrderAddressId;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    private Order orderByOrderId;

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPersonAddressId() {
        return personAddressId;
    }

    public void setPersonAddressId(int personAddressId) {
        this.personAddressId = personAddressId;
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
        Address address = (Address) o;
        return addressId == address.addressId && personAddressId == address.personAddressId && orderAddressId == address.orderAddressId && Objects.equals(additionalInfo, address.additionalInfo) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(details, address.details) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(postalCode, address.postalCode) && Objects.equals(street, address.street) && Objects.equals(streetNumber, address.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInfo, city, country, details, houseNumber, postalCode, street, streetNumber, addressId, personAddressId, orderAddressId);
    }

    public PersonAddress getPersonAddressByPersonAddressId() {
        return personAddressByPersonAddressId;
    }

    public void setPersonAddressByPersonAddressId(PersonAddress personAddressByPersonAddressId) {
        this.personAddressByPersonAddressId = personAddressByPersonAddressId;
    }

    public OrderAddress getOrderAddressByOrderAddressId() {
        return orderAddressByOrderAddressId;
    }

    public void setOrderAddressByOrderAddressId(OrderAddress orderAddressByOrderAddressId) {
        this.orderAddressByOrderAddressId = orderAddressByOrderAddressId;
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
