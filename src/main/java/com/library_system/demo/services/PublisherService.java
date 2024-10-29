package com.library_system.demo.services;

import com.library_system.demo.entity.Book;
import com.library_system.demo.entity.Category;
import com.library_system.demo.entity.Publisher;
import com.library_system.demo.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    // Tüm yayınevlerini getir
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    // ID'ye göre yayınevlerini getir
    public Optional<Publisher> getPublisherById(int id) {
        return publisherRepository.findById(id);
    }

    // Belirli bir yayınevini ID’ye göre güncelleme
    public Publisher updatePublisher(Integer id, Publisher publisherDetails) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        // Güncellemeleri yap
        publisher.setName(publisherDetails.getName());
        publisher.setEstablishmentYear(publisherDetails.getEstablishmentYear());
        publisher.setAdress(publisherDetails.getAdress());

        return publisherRepository.save(publisher);
    }
}
