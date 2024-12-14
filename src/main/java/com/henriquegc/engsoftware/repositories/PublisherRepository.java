package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
