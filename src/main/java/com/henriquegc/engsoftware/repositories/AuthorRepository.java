package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
