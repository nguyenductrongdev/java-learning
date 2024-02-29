package com.example.learning.controllers;

import com.example.learning.dto.BookDTO;
import com.example.learning.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/book")
public class Book {
    private final Logger logger = LoggerFactory.getLogger(Book.class);

    @Autowired
    IBookService bookService;

    @GetMapping
    private ResponseEntity<?> getBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getBook(@PathVariable Long id) {
        Optional<BookDTO> book = bookService.getBook(id);
        if(book.isPresent()) return ResponseEntity.ok(book.get());
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity<?> createBook(@RequestBody BookDTO book, @RequestParam(required = false) String author) {
        Optional<BookDTO> createdBook = bookService.createBook(book);
        if(createdBook.isPresent()) return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
        return ResponseEntity.internalServerError().build();
    }
}
