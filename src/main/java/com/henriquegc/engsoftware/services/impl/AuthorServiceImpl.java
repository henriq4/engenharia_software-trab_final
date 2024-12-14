package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.models.Author;
import com.henriquegc.engsoftware.repositories.AuthorRepository;
import com.henriquegc.engsoftware.services.IAuthorService;

import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements IAuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepository.findById(id).orElse(null);
    }
    
}
