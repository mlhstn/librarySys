package com.library_system.demo.services;

import com.library_system.demo.repository.BookBorrowingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookBorrowingService {

    private final BookBorrowingRepository bookBorrowingRepository;
}
