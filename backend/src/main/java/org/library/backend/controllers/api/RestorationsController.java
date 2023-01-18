package org.library.backend.controllers.api;

import org.library.backend.models.Restoration;
import org.library.backend.repositories.RestorationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "https://app-bookly.herokuapp.com", allowCredentials = "true")
@RequestMapping("/api/restorations")
public class RestorationsController {
    private final RestorationRepository restorationRepository;

    @Autowired
    public RestorationsController(RestorationRepository restorationRepository) {
        this.restorationRepository = restorationRepository;
    }

    @GetMapping
    public List<Restoration> index() {
        return restorationRepository.findAll();
    }
}
