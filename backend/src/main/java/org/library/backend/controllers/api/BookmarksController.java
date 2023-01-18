package org.library.backend.controllers.api;

import org.library.backend.models.Bookmark;
import org.library.backend.repositories.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(value = "https://app-bookly.herokuapp.com", allowCredentials = "true")
@RequestMapping("/api/bookmarks")
public class BookmarksController {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarksController(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @GetMapping
    public List<Bookmark> index() {
        return bookmarkRepository.findAll();
    }
}
