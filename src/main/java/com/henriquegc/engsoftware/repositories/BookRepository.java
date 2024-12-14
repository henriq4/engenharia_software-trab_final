package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
