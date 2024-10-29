package com.library_system.demo.services;

import com.library_system.demo.entity.Book;
import com.library_system.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ID'ye göre kitabı getir
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Yeni alanlara göre güncelleme işlemi
        book.setName(bookDetails.getName());
        book.setPublicationYear(bookDetails.getPublicationYear());
        book.setStock(bookDetails.getStock());

        return bookRepository.save(book);
    }

}
