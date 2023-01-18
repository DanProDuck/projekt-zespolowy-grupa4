package org.library.backend.controllers.api;

import org.library.backend.models.Order;
import org.library.backend.repositories.OrderRepository;
import org.library.backend.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "https://app-bookly.herokuapp.com", allowCredentials = "true")
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> index() {
        return orderRepository.findAll();
    }
}
