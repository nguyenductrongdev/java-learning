package com.example.learning.services.impl;

import com.example.learning.dto.BookDTO;
import com.example.learning.entities.Book;
import com.example.learning.repository.BookRepository;
import com.example.learning.services.IBookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<BookDTO> getAllBooks() {
        try {
            BookDTO test_book = BookDTO.builder().name("breaking").build();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(test_book);
            System.out.println("Serialized JSON: " + json);
            System.out.println(objectMapper);
        } catch (JsonProcessingException e) {
            System.out.println("Bug cmnr");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Bug!!!");
        }

        return bookRepository
                .findAll()
                .stream()
                .map(book -> mapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<BookDTO> createBook(BookDTO book) {
        Book bookEntity = new Book();
        bookEntity.setId(UUID.randomUUID());
        bookEntity.setCreated_at(LocalDateTime.now());
        bookEntity.setUpdated_at(LocalDateTime.now());
        bookEntity.setObject_id(UUID.randomUUID());
        bookEntity.setName(book.getName());
        bookEntity.setPages(book.getPages());

        Book savedBook = bookRepository.save(bookEntity);
        return Optional.of(mapper.map(savedBook, BookDTO.class));
    }
}
