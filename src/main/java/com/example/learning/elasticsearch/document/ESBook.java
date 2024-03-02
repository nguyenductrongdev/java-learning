package com.example.learning.elasticsearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ESBook {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;
}
