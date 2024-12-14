package com.henriquegc.engsoftware.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquegc.engsoftware.dtos.book.CreateBookDTO;
import com.henriquegc.engsoftware.models.Book;
import com.henriquegc.engsoftware.services.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @PostMapping()
    public void createBook(@RequestBody CreateBookDTO book) {
        this.bookService.createBook(book);
    }

}
