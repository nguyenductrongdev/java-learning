package com.example.learning.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.learning.elasticsearch.document.ESBook;

public interface IESBookRepository extends ElasticsearchRepository<ESBook, String> {
    
}
