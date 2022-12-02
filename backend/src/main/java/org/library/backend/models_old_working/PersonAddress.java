package org.library.backend.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Person_address", schema = "public", catalog = "app_database_new")
public class PersonAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Person_addressID")
    private int personAddressId;
    @OneToMany(mappedBy = "personAddressByPersonAddressId")
    private Collection<Address> addressesByPersonAddressId;
    @ManyToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID", nullable = false)
    private Person personByPersonId;

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
        return personAddressId == that.personAddressId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personAddressId);
    }

    public Collection<Address> getAddressesByPersonAddressId() {
        return addressesByPersonAddressId;
    }

    public void setAddressesByPersonAddressId(Collection<Address> addressesByPersonAddressId) {
        this.addressesByPersonAddressId = addressesByPersonAddressId;
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
