package com.example.learning.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import com.example.learning.entities.Book;

@Repository
public interface BookRepository extends CassandraRepository<Book, UUID> {

}
