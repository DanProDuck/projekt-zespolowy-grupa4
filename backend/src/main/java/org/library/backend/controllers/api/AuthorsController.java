package org.library.backend.controllers.api;

import org.library.backend.dto.AuthorDTO;
import org.library.backend.models.Author;
import org.library.backend.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/api/author")
public class AuthorsController {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorsController(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    //InvalidSessionStrategy for request sessions

    @GetMapping
    public ResponseEntity<List<Author>> index(HttpServletRequest req) {
        var res = authorRepository.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccessControlAllowMethods(Collections.singletonList(HttpMethod.POST));
        headers.setAccessControlAllowHeaders(Arrays.asList("Content-Type", "Authorization"));
        headers.setAccessControlAllowCredentials(true);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable int id) {
        var res = authorRepository.findById(id).orElse(null);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccessControlAllowMethods(Collections.singletonList(HttpMethod.POST));
        headers.setAccessControlAllowHeaders(Arrays.asList("Content-Type", "Authorization"));
        headers.setAccessControlAllowCredentials(true);

        return new ResponseEntity<>(res, headers, HttpStatus.OK);
    }

    @PostMapping
    public Author addNewAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = convertFromDTO(authorDTO);

        authorRepository.save(author);
        return author;
    }

    @PatchMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO) {
        return convertFromDTO(authorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorRepository.deleteById(id);
    }

    private Author convertFromDTO(AuthorDTO authorDTO) {
        return modelMapper.map(authorDTO, Author.class);
    }
}
