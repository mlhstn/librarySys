package com.library_system.demo.services;

import com.library_system.demo.entity.Book;
import com.library_system.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }
}
