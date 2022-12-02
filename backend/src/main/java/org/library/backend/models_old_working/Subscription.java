package org.library.backend.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Subscription {
    @Basic
    @Column(name = "Subscribed_at")
    private Timestamp subscribedAt;
    @Basic
    @Column(name = "Subscription_token")
    private String subscriptionToken;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SubscriptionID")
    private int subscriptionId;
    @ManyToOne
    @JoinColumn(name = "PersonID", referencedColumnName = "PersonID")
    private Person personByPersonId;

    public Timestamp getSubscribedAt() {
        return subscribedAt;
    }

    public void setSubscribedAt(Timestamp subscribedAt) {
        this.subscribedAt = subscribedAt;
    }

    public String getSubscriptionToken() {
        return subscriptionToken;
    }

    public void setSubscriptionToken(String subscriptionToken) {
        this.subscriptionToken = subscriptionToken;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return subscriptionId == that.subscriptionId && Objects.equals(subscribedAt, that.subscribedAt) && Objects.equals(subscriptionToken, that.subscriptionToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscribedAt, subscriptionToken, subscriptionId);
    }

    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }
}
