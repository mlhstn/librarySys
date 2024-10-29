package com.library_system.demo.controller;

import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.Category;
import com.library_system.demo.entity.Publisher;
import com.library_system.demo.services.BookService;
import com.library_system.demo.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // Tüm yayınevlerini getirme
    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }

    // Belirli bir yayınevini ID’ye göre getirme
    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable int id) {
        return publisherService.getPublisherById(id)
                .map(publisher -> new ResponseEntity<>(publisher, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Belirli bir yayınevini ID’ye göre güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(
            @PathVariable Integer id,
            @RequestBody Publisher publisherDetails) {
        Publisher updatedPublisher = publisherService.updatePublisher(id, publisherDetails);
        return ResponseEntity.ok(updatedPublisher);
    }
}
