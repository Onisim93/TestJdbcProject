package org.example.queries;


import lombok.Getter;

@Getter
public enum SqlBookQueries {
    FIND_BY_ID("""
            SELECT b.id AS book_id,
            b.title AS book_title,
            b.description AS book_description,
            b.published_date AS book_published_date,
            b.isbn AS book_isbn,
            a.id AS author_id,
            a.name AS author_name,
            g.id AS genre_id,
            g.name AS genre_name
            FROM books b
            JOIN authors a ON b.author_id = a.id
            LEFT JOIN book_genres bg ON bg.book_id = b.id
            LEFT JOIN genres g ON g.id = bg.genre_id
            WHERE b.id = ?
            """),

    FIND_ALL("""
            SELECT b.id AS book_id,
            b.title AS book_title,
            b.description AS book_description,
            b.published_date AS book_published_date,
            b.isbn AS book_isbn,
            a.id AS author_id,
            a.name AS author_name,
            g.id AS genre_id,
            g.name AS genre_name
            FROM books b
            JOIN authors a ON b.author_id = a.id
            LEFT JOIN book_genres bg ON bg.book_id = b.id
            LEFT JOIN genres g ON g.id = bg.genre_id
            """);


    private String sql;

    SqlBookQueries(String sql) {
        this.sql = sql;
    }
}
