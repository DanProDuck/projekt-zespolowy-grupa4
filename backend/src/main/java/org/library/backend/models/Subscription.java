package org.library.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.library.backend.util.constants.SubscriptionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubscriptionID", nullable = false)
    private Integer id;

    @Column(name = "Subscribed_at")
    private Instant subscribedAt;

    @Size(max = 75)
    @Column(name = "Subscription_token", length = 75)
    private String subscriptionToken;

    @Size(max = 10)
    @Column(name = "Subscription_type", length = 10)
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PersonID", nullable = false)
    @JsonBackReference
    private Person personID;

}