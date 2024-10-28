package com.library_system.demo.controller;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import com.library_system.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){

        Book createBook = bookService.createBook(book);
        return new ResponseEntity<>(createBook, HttpStatus.CREATED);

    }

}
