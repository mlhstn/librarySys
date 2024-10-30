package com.library_system.demo.repository;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    boolean existsByBooksIsNotEmpty();
}
