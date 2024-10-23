package com.library_system.demo.services;

import com.library_system.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;


}
