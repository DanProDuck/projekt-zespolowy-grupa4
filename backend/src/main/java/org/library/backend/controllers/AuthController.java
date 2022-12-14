package org.library.backend.controllers;

import org.library.backend.dto.BasicPersonLoginDTO;
import org.library.backend.dto.PersonDTO;
import org.library.backend.dto.PersonRegistrationDTO;
import org.library.backend.models.Person;
import org.library.backend.security.PersonDetails;
import org.library.backend.services.RegistrationService;
import org.library.backend.util.error.GeneralErrorResponse;
import org.library.backend.util.error.exception.UserAuthException;
import org.library.backend.util.validator.PersonValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true", origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, RegistrationService registrationService, PasswordEncoder passwordEncoder, PersonValidator personValidator, ModelMapper modelMapper) {
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
    public ResponseEntity<String> register(@RequestBody @Valid PersonRegistrationDTO regDTO,
                                           BindingResult bindingResult) {
        Person person = convertToPerson(regDTO);

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new UserAuthException(bindingResult.getAllErrors().toString());
        }

        registrationService.register(person);

        String response = "{\"msg\": \"Success\"";
        return new ResponseEntity<>(response, HttpStatus.OK);
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

    @GetMapping("/login")
    public String redirectToLogin() {
        return "redirect:http://localhost:3000/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public PersonDetails performLogin(HttpServletRequest req, @RequestBody BasicPersonLoginDTO authDTO) {
        // TODO add verificatopn of session, if not already logged in

        Authentication authentication;
        SecurityContext securityContext;
        HttpSession httpSession;
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        authDTO.getUsername(),
                        authDTO.getPassword());

        try {
            authentication = authenticationManager.authenticate(authToken);
            securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            httpSession = req.getSession(true);
//            httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
            httpSession.setAttribute("AAAAAAAAAAA", securityContext);
        } catch (BadCredentialsException e) {
            //should also catch Locked and Disabled exceptions to ensure contracts
            throw new UserAuthException(e.getMessage());
        }

        System.out.println(securityContext.getAuthentication().getPrincipal());

        return (PersonDetails) authentication.getPrincipal();
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
