package org.library.backend.services;

import org.library.backend.models.Address;
import org.library.backend.repositories.CollectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    public final CollectiveRepository repository;

    @Autowired
    public AdminService(CollectiveRepository repository) {
        this.repository = repository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void testAdminMethod() {
        System.out.println("Hello from admin method");
    }

}