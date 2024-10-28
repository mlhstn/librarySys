package com.library_system.demo.services;

import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.Category;
import com.library_system.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}

