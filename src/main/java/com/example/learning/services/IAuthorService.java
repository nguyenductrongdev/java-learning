package com.example.learning.services;

import com.example.learning.dto.AuthorDTO;

import java.util.Optional;

public interface IAuthorService {
    public Optional<AuthorDTO> getAuthor(Long authorId);
}
