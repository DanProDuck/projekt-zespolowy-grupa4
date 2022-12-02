package org.library.backend.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Registration {
    @Basic
    @Column(name = "Expire_at")
    private Timestamp expireAt;
    @Basic
    @Column(name = "Registration_token")
    private String registrationToken;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "RegistrationID")
    private int registrationId;
    @ManyToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    private Person personByPersonId;

    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }

    public String getRegistrationToken() {
        return registrationToken;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return registrationId == that.registrationId && Objects.equals(expireAt, that.expireAt) && Objects.equals(registrationToken, that.registrationToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expireAt, registrationToken, registrationId);
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
