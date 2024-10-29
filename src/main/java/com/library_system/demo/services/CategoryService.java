package com.library_system.demo.services;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.Category;
import com.library_system.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Tüm kategorileri getirme
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // ID'ye göre kategori getirme
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
    // Belirli bir kategoriyi ID’ye göre güncelleme
    public Category updateCategory(Integer id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Güncellemeleri yap
        category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());

        return categoryRepository.save(category);
    }

}

