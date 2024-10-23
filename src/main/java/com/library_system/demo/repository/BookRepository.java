package com.library_system.demo.repository;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
