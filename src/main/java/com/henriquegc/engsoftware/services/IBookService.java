package com.henriquegc.engsoftware.services;

import java.util.List;

import com.henriquegc.engsoftware.dtos.book.CreateBookDTO;
import com.henriquegc.engsoftware.models.Book;

public interface IBookService {
    List<Book> getBooks();
    void createBook(CreateBookDTO book);
}
