package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.dtos.book.CreateBookDTO;
import com.henriquegc.engsoftware.models.Book;
import com.henriquegc.engsoftware.repositories.BookRepository;
import com.henriquegc.engsoftware.services.IAuthorService;
import com.henriquegc.engsoftware.services.IBookService;
import com.henriquegc.engsoftware.services.IPublisherService;

import static com.henriquegc.engsoftware.mappers.BookMapper.mapToBook;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {
    private final BookRepository BookRepository;
    
    private final IAuthorService authorService;
    private final IPublisherService publisherService;

    public BookServiceImpl(BookRepository BookRepository, 
                            IAuthorService authorService, 
                            IPublisherService publisherService) {
        this.BookRepository = BookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public void createBook(CreateBookDTO book) {
        var author = this.authorService.getById(book.getAuthorId());

        if (author == null) throw new IllegalArgumentException("Author not found");

        var publisher = this.publisherService.getById(book.getPublisherId());

        if (publisher == null) throw new IllegalArgumentException("Publisher not found");

        this.BookRepository.save(mapToBook(book, author, publisher));
    }

    @Override
    public List<Book> getBooks() {
        return this.BookRepository.findAll();
    }
    
}
