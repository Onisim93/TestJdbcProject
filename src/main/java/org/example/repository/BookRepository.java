package org.example.repository;

import org.example.JdbcConnection;
import org.example.model.Author;
import org.example.model.Book;
import org.example.model.Genre;
import org.example.queries.SqlBookQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {

    private final Connection connection;

    public BookRepository() {
        this.connection = JdbcConnection.getConnection();
    }

    public Book findById(Integer id) {
        Map<Integer, Book> books = new HashMap<>();

        try (PreparedStatement ps = connection.prepareStatement(SqlBookQueries.FIND_BY_ID.getSql())) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            Book book = null;

            while (rs.next()) {
                Integer bookId = rs.getInt("book_id");
                Integer authorId = rs.getInt("author_id");
                String title = rs.getString("book_title");
                String isbn = rs.getString("book_isbn");
                String authorName = rs.getString("author_name");
                String publishedDate = rs.getString("book_published_date");
                String description = rs.getString("book_description");
                Integer genreId = rs.getInt("genre_id");
                String genreName = rs.getString("genre_name");

                Genre genre = new Genre(genreId, genreName);
                Author author = new Author(authorId, authorName);

                book = new Book(bookId, title, description, publishedDate, isbn, author, new ArrayList<>(List.of(genre)));

                if (books.containsKey(bookId)) {
                    books.get(bookId).getGenres().addAll(List.of(genre));
                }
                else {
                    books.put(bookId, book);
                }
            }

            return books.get(id);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> findAll() {
        Map<Integer, Book> books = new HashMap<>();

        try (PreparedStatement ps = connection.prepareStatement(SqlBookQueries.FIND_ALL.getSql())) {
            ResultSet rs = ps.executeQuery();

            Book book = null;

            while (rs.next()) {
                Integer bookId = rs.getInt("book_id");
                Integer authorId = rs.getInt("author_id");
                String title = rs.getString("book_title");
                String isbn = rs.getString("book_isbn");
                String authorName = rs.getString("author_name");
                String publishedDate = rs.getString("book_published_date");
                String description = rs.getString("book_description");
                Integer genreId = rs.getInt("genre_id");
                String genreName = rs.getString("genre_name");

                Genre genre = new Genre(genreId, genreName);
                Author author = new Author(authorId, authorName);

                book = new Book(bookId, title, description, publishedDate, isbn, author, new ArrayList<>(List.of(genre)));

                if (books.containsKey(bookId)) {
                    books.get(bookId).getGenres().addAll(List.of(genre));
                }
                else {
                    books.put(bookId, book);
                }
            }

            return books.values().stream().toList();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Integer id) {
        try (PreparedStatement ps = connection.prepareStatement("delete from books where id = ?");
            PreparedStatement deleteFromBookGenres = connection.prepareStatement("delete from book_genres where book_id = ?")) {
            deleteFromBookGenres.setInt(1, id);
            deleteFromBookGenres.executeUpdate();

            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
