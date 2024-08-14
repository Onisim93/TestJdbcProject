package org.example.repository;

import org.example.JdbcConnection;
import org.example.model.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {

    private final Connection connection;

    public AuthorRepository() {
        connection = JdbcConnection.getConnection();
    }

    public Author getById(Integer id) {
        try (PreparedStatement ps = connection.prepareStatement("select * from authors where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Author author = null;
            if (rs.next()) {
                author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setBio(rs.getString("bio"));
            }

            return author;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select * from authors")) {
            ResultSet rs = ps.executeQuery();
            Author author = null;

            while (rs.next()) {
                author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("name"));
                author.setBio(rs.getString("bio"));
                authors.add(author);
            }

            return authors;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Author save(Author author) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO authors (name, bio) VALUES (?, ?) RETURNING id")) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getBio());

            ResultSet rs = ps.executeQuery();
            Integer id = null;

            if (rs.next()) {
                id = rs.getInt("id");
            }

            return getById(id);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Author update(Author author) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE authors SET name = ?, bio = ? WHERE id = ?")) {
            ps.setString(1, author.getName());
            ps.setString(2, author.getBio());
            ps.setInt(3, author.getId());

            ps.executeUpdate();

            return getById(author.getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void deleteById(Integer id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM authors where id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
