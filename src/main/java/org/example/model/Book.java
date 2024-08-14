package org.example.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;
    private String title;
    private String description;
    private String publishedDate;
    private String isbn;

    private Author author;
    private List<Genre> genres;

    public Book(String title, String description, String publishedDate, String isbn, Author author) {
        this.title = title;
        this.description = description;
        this.publishedDate = publishedDate;
        this.isbn = isbn;
        this.author = author;
    }
}
