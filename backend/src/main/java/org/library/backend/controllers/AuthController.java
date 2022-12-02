package org.library.backend.controllers;

import org.library.backend.dto.BasicPersonLoginDTO;
import org.library.backend.dto.PersonDTO;
import org.library.backend.dto.PersonRegistrationDTO;
import org.library.backend.models.Person;
import org.library.backend.services.RegistrationService;
import org.library.backend.util.error.GeneralErrorResponse;
import org.library.backend.util.error.exception.UserAuthException;
import org.library.backend.util.validator.PersonValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, RegistrationService registrationService, PersonValidator personValidator, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.registrationService = registrationService;
        this.personValidator = personValidator;
        this.modelMapper = modelMapper;
    }

//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }

    @ResponseBody
    @PostMapping("/registration")
    ////Not model attribute, but RequestBody with DTO?
    //public String registrationPage(@ModelAttribute("person") Person person) {
    public PersonRegistrationDTO register(@RequestBody @Valid PersonRegistrationDTO regDTO,
                                          BindingResult bindingResult) {
        Person person = convertToPerson(regDTO);

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new UserAuthException(bindingResult.getAllErrors().toString());
        }

        registrationService.register(person);
        return regDTO;
    }

    @GetMapping("/registrationPage")
    //Not model attribute, but RequestBody with DTO?
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "register";

        registrationService.register(person);

        return "redirect:/auth/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public BasicPersonLoginDTO performLogin(@RequestBody BasicPersonLoginDTO authDTO) {
        // TODO
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(authDTO.getUsername(), authDTO.getPassword());

        try {
            authenticationManager.authenticate(authToken);
        } catch (BadCredentialsException e) {
            return authDTO.setUsername(e.getMessage());
        }

        return authDTO;
    }

    @ExceptionHandler
    private ResponseEntity<GeneralErrorResponse> authHandler(UserAuthException e) {
        var genErr = new GeneralErrorResponse();
        genErr.setMessage(e.getMessage());
        genErr.setTime(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(genErr, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public Person convertToPerson(PersonRegistrationDTO personDTO) {
        return this.modelMapper.map(personDTO, Person.class);
    }

    public PersonDTO convertToDTO(Person person) {
        return this.modelMapper.map(person, PersonDTO.class);
    }

}
