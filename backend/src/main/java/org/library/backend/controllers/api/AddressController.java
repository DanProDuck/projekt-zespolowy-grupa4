package org.library.backend.controllers.api;

import org.library.backend.models.Address;
import org.library.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "https://app-bookly.herokuapp.com", allowCredentials = "true")
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping
    public List<Address> index() {
        return addressRepository.findAll();
    }
}
