package com.library_system.demo.controller;

import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.Publisher;
import com.library_system.demo.services.BookService;
import com.library_system.demo.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher(@RequestBody Publisher publisher){

        Publisher createPublisher = publisherService.createPublisher(publisher);
        return new ResponseEntity<>(createPublisher, HttpStatus.CREATED);

    }
}
