package com.example.learning.services.impl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.dto.AuthorDTO;
import com.example.learning.entities.Author;
import com.example.learning.repository.AuthorRepository;
import com.example.learning.services.IAuthorService;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Optional<AuthorDTO> getAuthor(Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);

        if(!author.isPresent()) return Optional.empty();

        return Optional.of(mapper.map(author.get(), AuthorDTO.class));
    }
}
