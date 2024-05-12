package com.example.learning.controllers;

import com.example.learning.dto.AuthorDTO;
import com.example.learning.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    IAuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable Long id) {
        Optional<AuthorDTO> author = authorService.getAuthor(id);
        if (author.isPresent())  return ResponseEntity.ok(author.get());
        return ResponseEntity.notFound().build();
    }
}
