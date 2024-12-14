package com.henriquegc.engsoftware.services;

import com.henriquegc.engsoftware.models.Author;

public interface IAuthorService {
    Author getById(Long id);
}
