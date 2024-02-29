package com.example.learning.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private String name;
    private Integer age;
    private List<BookDTO> books;
}
