package org.library.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectiveRepository {
    public final AddressRepository addressRepository;
    public final AuthorRepository authorRepository;
    public final BookmarkRepository bookmarkRepository;
    public final CategoryRepository categoryRepository;
    public final CommentRepository commentRepository;
    public final OrderRepository orderRepository;
    public final PersonRepository personRepository;
    public final ProductRepository productRepository;
    public final RegistrationRepository registrationRepository;
    public final RestorationRepository restorationRepository;
    public final SubscriptionRepository subscriptionRepository;


    @Autowired
    public CollectiveRepository(AddressRepository addressRepository, AuthorRepository authorRepository, BookmarkRepository bookmarkRepository, CategoryRepository categoryRepository, CommentRepository commentRepository, OrderRepository orderRepository, PersonRepository personRepository, ProductRepository productRepository, RegistrationRepository registrationRepository, RestorationRepository restorationRepository, SubscriptionRepository subscriptionRepository) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.bookmarkRepository = bookmarkRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.registrationRepository = registrationRepository;
        this.restorationRepository = restorationRepository;
        this.subscriptionRepository = subscriptionRepository;
    }
}
