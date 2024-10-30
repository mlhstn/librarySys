package com.library_system.demo.repository;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Integer> {
    Optional<BookBorrowing> findByBookIdAndBookStockGreaterThan(Long bookId, int stock);}
