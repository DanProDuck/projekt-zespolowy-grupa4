package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Person_address", schema = "public", catalog = "app_database")
public class PersonAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Person_addressID", nullable = false)
    private int personAddressId;

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

    public int getPersonAddressId() {
        return personAddressId;
    }

    public void setPersonAddressId(int personAddressId) {
        this.personAddressId = personAddressId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonAddress that = (PersonAddress) o;

        if (personAddressId != that.personAddressId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personAddressId;
        result = 31 * result;
        return result;
    }
}
