package com.library_system.demo.services;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import com.library_system.demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    // Tüm yazarları getir
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // ID'ye göre yazar getir
    public Optional<Author> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    // Belirli bir yazarı ID’ye göre güncelleme
    public Author updateAuthor(int id, Author authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        // Güncellemeleri yap
        author.setName(authorDetails.getName());
        author.setBirthDate(authorDetails.getBirthDate());
        author.setCountry(authorDetails.getCountry());

        return authorRepository.save(author);
    }
    // Belirli bir yazarı ID’ye göre silme
    public void deleteAuthor(int id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Author not found");
        }
        authorRepository.deleteById(id);
    }

}
