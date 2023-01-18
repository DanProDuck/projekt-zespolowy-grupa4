package org.library.backend.services;

import org.library.backend.models.Person;
import org.library.backend.repositories.PersonRepository;
import org.library.backend.util.constants.PersonRole;
import org.library.backend.util.error.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;

@Service
public class RegistrationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        if (isEmailPresent(person.getEmail())) {
            throw new UserAlreadyExistsException("User with provided email already exists");
        }

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole(PersonRole.ROLE_USER);
        person.setCreatedAt(Instant.now());
        person.setIsEnabled(false);
        person.setIsRestricted(false);

        //create token
        //add it to database

        personRepository.save(person);
    }

    private boolean isEmailPresent(String email) {
        return personRepository.findByEmail(email).isPresent();
    }
}
