package org.library.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class CollectiveRepository {
    public final AddressRepository addressRepository;
    public final AuthorRepository authorRepository;
    public final CategoryRepository categoryRepository;
    public final OrderRepository orderRepository;
    public final PersonRepository personRepository;
    public final ProductRepository productRepository;
    public final RegistrationRepository registrationRepository;
    public final SubscriptionRepository subscriptionRepository;


    @Autowired
    public CollectiveRepository(AddressRepository addressRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, OrderRepository orderRepository, PersonRepository personRepository, ProductRepository productRepository, RegistrationRepository registrationRepository, SubscriptionRepository subscriptionRepository) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.registrationRepository = registrationRepository;
        this.subscriptionRepository = subscriptionRepository;
    }
}
