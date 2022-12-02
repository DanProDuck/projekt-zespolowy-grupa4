package org.library.backend.models;

import javax.persistence.*;

@Entity
public class Address {
    @Basic
    @Column(name = "Additional_info", nullable = true, length = 100)
    private String additionalInfo;
    @Basic
    @Column(name = "City", nullable = true, length = 30)
    private String city;
    @Basic
    @Column(name = "Country", nullable = true, length = 30)
    private String country;
    @Basic
    @Column(name = "Details", nullable = true, length = 50)
    private String details;
    @Basic
    @Column(name = "House_number", nullable = true)
    private Integer houseNumber;
    @Basic
    @Column(name = "Postal_code", nullable = true, length = 12)
    private String postalCode;
    @Basic
    @Column(name = "Street", nullable = true, length = 50)
    private String street;
    @Basic
    @Column(name = "Street_number", nullable = true)
    private Integer streetNumber;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AddressID", nullable = false)
    private int addressId;
    @Basic
    @Column(name = "Person_addressID", nullable = false)
    private int personAddressId;
    @Basic
    @Column(name = "Order_addressID", nullable = false)
    private int orderAddressId;

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

        if (addressId != address.addressId) return false;
        if (personAddressId != address.personAddressId) return false;
        if (orderAddressId != address.orderAddressId) return false;
        if (additionalInfo != null ? !additionalInfo.equals(address.additionalInfo) : address.additionalInfo != null)
            return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (details != null ? !details.equals(address.details) : address.details != null) return false;
        if (houseNumber != null ? !houseNumber.equals(address.houseNumber) : address.houseNumber != null) return false;
        if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (streetNumber != null ? !streetNumber.equals(address.streetNumber) : address.streetNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = additionalInfo != null ? additionalInfo.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
        result = 31 * result + addressId;
        result = 31 * result + personAddressId;
        result = 31 * result + orderAddressId;
        return result;
    }
}
