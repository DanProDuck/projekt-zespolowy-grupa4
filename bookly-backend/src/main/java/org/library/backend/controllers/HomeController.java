package org.library.backend.controllers;

import org.library.backend.dto.PersonDTO;
import org.library.backend.models.Person;
import org.library.backend.security.PersonDetails;
import org.library.backend.util.error.GeneralErrorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@CrossOrigin("https://app-bookly.herokuapp.com")
@RequestMapping("/")
public class HomeController {

    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String index() {
        return "forward:/currentUserInfo";
    }

    @ResponseBody
    @GetMapping("/currentUserInfo")
    public PersonDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() == null) {
            throw new RuntimeException("No auth in context");
        }
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        Person userDetails = personDetails.getPerson();
        PersonDTO user = modelMapper.map(userDetails, PersonDTO.class);

        return user;
    }

    @ResponseBody
    @ExceptionHandler
    private ResponseEntity<GeneralErrorResponse> handleException(Exception e) {
        GeneralErrorResponse res = new GeneralErrorResponse();
        res.setMessage(e.getMessage());
        res.setTime(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler
    private ResponseEntity<GeneralErrorResponse> handleCriticalError(Throwable e) {
        GeneralErrorResponse res = new GeneralErrorResponse();
        res.setMessage(e.getMessage());
        res.setTime(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
