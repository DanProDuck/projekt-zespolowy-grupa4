package org.library.backend.controllers.api;

import org.library.backend.dto.PersonDTO;
import org.library.backend.models.Person;
import org.library.backend.repositories.PersonRepository;
import org.library.backend.util.error.GeneralErrorResponse;
import org.library.backend.util.error.exception.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PeopleController {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Person> index() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable int id) {
        return personRepository.findById(id).orElseThrow(new PersonNotFoundException(id));
    }

    @PatchMapping
    public void updatePerson(@RequestBody PersonDTO personDTO) {
        int id = personDTO.getId();

    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id) {
        personRepository.deleteById(id);
    }

    @ExceptionHandler
    private ResponseEntity<GeneralErrorResponse> handlePersonError(PersonNotFoundException e) {
        GeneralErrorResponse res = new GeneralErrorResponse();
        res.setMessage("Person with id '" + e.getId() + "' was not found");
        res.setTime(new Timestamp(System.currentTimeMillis()));

        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    private Person convertFromDTO(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }
}
