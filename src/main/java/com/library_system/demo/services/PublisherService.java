package com.library_system.demo.services;

import com.library_system.demo.entity.Category;
import com.library_system.demo.entity.Publisher;
import com.library_system.demo.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
}
