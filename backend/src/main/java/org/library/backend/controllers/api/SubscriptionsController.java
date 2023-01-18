package org.library.backend.controllers.api;

import org.library.backend.models.Subscription;
import org.library.backend.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "https://app-bookly.herokuapp.com", allowCredentials = "true")
@RequestMapping("/api/subscriptions")
public class SubscriptionsController {
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionsController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @GetMapping
    public List<Subscription> index() {
        return subscriptionRepository.findAll();
    }
}
