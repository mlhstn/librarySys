package com.library_system.demo.controller;

import com.library_system.demo.entity.Author;
import com.library_system.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){

        Author createAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(createAuthor,HttpStatus.CREATED);

    }
}
