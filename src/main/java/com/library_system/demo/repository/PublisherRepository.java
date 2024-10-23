package com.library_system.demo.repository;

import com.library_system.demo.entity.Author;
import com.library_system.demo.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
