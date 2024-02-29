package com.example.learning.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learning.entities.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
