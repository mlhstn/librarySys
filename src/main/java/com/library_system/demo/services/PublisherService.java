package com.library_system.demo.services;

import com.library_system.demo.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
}
