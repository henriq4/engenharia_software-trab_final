package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.models.Publisher;
import com.henriquegc.engsoftware.repositories.PublisherRepository;
import com.henriquegc.engsoftware.services.IPublisherService;

import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements IPublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher getById(Long id) {
        return this.publisherRepository.findById(id).orElse(null);
    }
    
}
