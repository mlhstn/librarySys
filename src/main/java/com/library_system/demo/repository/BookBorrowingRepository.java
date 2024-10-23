package com.library_system.demo.repository;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing, Integer> {
}
