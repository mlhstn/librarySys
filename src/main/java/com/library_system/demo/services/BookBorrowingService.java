package com.library_system.demo.services;

import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.BookBorrowing;
import com.library_system.demo.repository.BookBorrowingRepository;
import com.library_system.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class BookBorrowingService {

    @Autowired
    private BookRepository bookRepository;

    private final BookBorrowingRepository bookBorrowingRepository;

    public void borrowBook(Long id, String borrowerName, Date borrowingDate,Date returnDate){

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Kitap bulunamadı"));

        if (book.getStock() <= 0){
            throw new IllegalStateException("Kitap stokta yok, ödünç verilemez");

        }
        book.setStock(book.getStock()-1);
        bookRepository.save(book);

        // BookBorrowing kaydını ekleyin
        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBook(book);
        bookBorrowing.setBorrowerName(borrowerName);
        bookBorrowing.setBorrowingDate(borrowingDate);
        bookBorrowing.setReturnDate(returnDate);
        bookBorrowingRepository.save(bookBorrowing);

    }

    }
