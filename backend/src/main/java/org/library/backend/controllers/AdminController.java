package org.library.backend.controllers;

import org.library.backend.controllers.api.AuthorsController;
import org.library.backend.models.Author;
import org.library.backend.repositories.CollectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    CollectiveRepository repository;
    AuthorsController authorsController;

    @Autowired
    public AdminController(CollectiveRepository repository, AuthorsController authorsController) {
        this.repository = repository;
        this.authorsController = authorsController;
    }

    @GetMapping("/authors")
    private List<Author> getAllAuthors() {
        return authorsController.index();
    }
}
