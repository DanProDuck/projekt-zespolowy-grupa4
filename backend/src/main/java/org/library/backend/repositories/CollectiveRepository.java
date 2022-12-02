package org.library.backend.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectiveRepository {
    public AddressRepository addressRepository;
    public AuthorRepository authorRepository;
    public CategoryRepository categoryRepository;
    public OrderRepository orderRepository;
    public PersonRepository personRepository;
    public ProductRepository productRepository;

    @Autowired
    public CollectiveRepository(AddressRepository addressRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, OrderRepository orderRepository, PersonRepository personRepository, ProductRepository productRepository) {
        this.addressRepository = addressRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
    }
}
