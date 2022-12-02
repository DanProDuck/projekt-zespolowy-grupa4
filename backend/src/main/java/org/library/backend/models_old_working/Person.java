package org.library.backend.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Person {
    @Basic
    @Column(name = "Created_at")
    private Date createdAt;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Password")
    private String password;
    @Basic
    @Column(name = "Phone_number")
    private Integer phoneNumber;
    @Basic
    @Column(name = "Role")
    private String role;
    @Basic
    @Column(name = "Surname")
    private String surname;
    @Basic
    @Column(name = "Updated_at")
    private Date updatedAt;
    @Basic
    @Column(name = "Username")
    private String username;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "PersonID")
    private int personId;
    @OneToMany(mappedBy = "personByPersonId")
    private Collection<Order> ordersByPersonId;
    @OneToMany(mappedBy = "personByPersonId")
    private Collection<PersonAddress> personAddressesByPersonId;
    @OneToMany(mappedBy = "personByPersonId")
    private Collection<Registration> registrationsByPersonId;
    @OneToMany(mappedBy = "personByPersonId")
    private Collection<Subscription> subscriptionsByPersonId;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && Objects.equals(createdAt, person.createdAt) && Objects.equals(email, person.email) && Objects.equals(name, person.name) && Objects.equals(password, person.password) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(role, person.role) && Objects.equals(surname, person.surname) && Objects.equals(updatedAt, person.updatedAt) && Objects.equals(username, person.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, email, name, password, phoneNumber, role, surname, updatedAt, username, personId);
    }

    public Collection<Order> getOrdersByPersonId() {
        return ordersByPersonId;
    }

    public void setOrdersByPersonId(Collection<Order> ordersByPersonId) {
        this.ordersByPersonId = ordersByPersonId;
    }

    public Collection<PersonAddress> getPersonAddressesByPersonId() {
        return personAddressesByPersonId;
    }

    public void setPersonAddressesByPersonId(Collection<PersonAddress> personAddressesByPersonId) {
        this.personAddressesByPersonId = personAddressesByPersonId;
    }

    public Collection<Registration> getRegistrationsByPersonId() {
        return registrationsByPersonId;
    }

    public void setRegistrationsByPersonId(Collection<Registration> registrationsByPersonId) {
        this.registrationsByPersonId = registrationsByPersonId;
    }

    public Collection<Subscription> getSubscriptionsByPersonId() {
        return subscriptionsByPersonId;
    }

    public void setSubscriptionsByPersonId(Collection<Subscription> subscriptionsByPersonId) {
        this.subscriptionsByPersonId = subscriptionsByPersonId;
    }
}
