package com.henriquegc.engsoftware.mappers;

import com.henriquegc.engsoftware.dtos.book.CreateBookDTO;
import com.henriquegc.engsoftware.models.Author;
import com.henriquegc.engsoftware.models.Book;
import com.henriquegc.engsoftware.models.Publisher;

public class BookMapper {
    public static Book mapToBook(CreateBookDTO book, Author author, Publisher publisher) {
        return Book.builder()
            .title(book.getTitle())
            .description(book.getDescription())
            .author(author)
            .publisher(publisher)
            .isbn(book.getIsbn())
            .year(book.getYear())
            .pages(book.getPages())
            .build();
    }
}