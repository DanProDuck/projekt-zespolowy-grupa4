package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Subscription")
public class Subscription {
    @Id
    @Column(name = "SubscriptionID", nullable = false)
    private Integer id;

    @Column(name = "Subscribed_at")
    private Instant subscribedAt;

    @Size(max = 50)
    @Column(name = "Subscription_token", length = 50)
    private String subscriptionToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonID")
    @JsonBackReference
    private Person personID;

}