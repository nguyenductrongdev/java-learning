package com.example.learning.services;

import com.example.learning.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<BookDTO> getAllBooks();
    Optional<BookDTO> createBook(BookDTO book);
    Optional<BookDTO> getBook(Long id);
}
