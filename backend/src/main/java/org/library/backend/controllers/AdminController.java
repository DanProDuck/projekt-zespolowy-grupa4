package org.library.backend.controllers;

import org.library.backend.models.*;
import org.library.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final CollectiveRepository repository;

    @Autowired
    public AdminController(CollectiveRepository repository) {
        this.repository = repository;
    }
    

    @GetMapping("/addresses")
    private List<Address> getAllAddresses() {
        return repository.addressRepository.findAll();
    }

    @GetMapping("/authors")
    private List<Author> getAllAuthors() {
        return repository.authorRepository.findAll();
    }

    @GetMapping("/categories")
    private List<Category> getAllCategories() {
        return repository.categoryRepository.findAll();
    }

    @GetMapping("/orders")
    private List<Order> getAllOrders() {
        return repository.orderRepository.findAll();
    }

    @GetMapping("/people")
    private List<Person> getAllPeople() {
        return repository.personRepository.findAll();
    }

    @GetMapping("/products")
    private List<Product> getAllProducts() {
        return repository.productRepository.findAll();
    }

    @GetMapping("/registrations")
    private List<Registration> getAllRegistrations() {
        return repository.registrationRepository.findAll();
    }

    @GetMapping("/subscriptions")
    private List<Subscription> getAllSubscriptions() {
        return repository.subscriptionRepository.findAll();
    }
}
