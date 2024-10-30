package com.library_system.demo;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Book;
import com.library_system.demo.repository.AuthorRepository;
import com.library_system.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(@Autowired BookRepository bookRepository, @Autowired AuthorRepository authorRepository) {
		return args -> {
			// Yazar ekleyelim
			Author author = new Author();
			author.setName("Melih üstün");
			author.setBirthDate(LocalDate.of(1990, 2, 9)); // Doğum tarihi ayarlayın
			author.setCountry("Türkiye");

			author = authorRepository.save(author); // Yazar kaydet

			// Kitap ekleyelim
			LocalDate publicationDate = LocalDate.of(2024, 10, 30);
			Book book = new Book();
			book.setName("Akümsanda hayat");
			book.setPublicationYear(publicationDate); // Yayın yılı ayarlayın
			book.setStock(5);
			book.setAuthor(author); // Yazar bilgisini ekle

			bookRepository.save(book); // Kitabı kaydet

			System.out.println("Kitap başarıyla eklendi: " + book.getName());
		};
	}
}
