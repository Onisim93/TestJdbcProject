package org.example.repository;

import org.example.JdbcConnection;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final Connection connection;

    public UserRepository() {
        connection = JdbcConnection.getConnection();
    }

    public boolean authUser(String username, String password) {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from users where username = '" + username + "' and password = '" + password + "'";
            ResultSet rs = statement.executeQuery(sql);
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));

                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getById(Integer id) {
        try (PreparedStatement ps = connection.prepareStatement("select * from users where id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }


            return user;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select * from users")) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));

                users.add(user);
            }



            return users;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User save(User user) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?) RETURNING id")) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

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

    public User update(User user) {
        try (PreparedStatement ps = connection.prepareStatement("UPDATE users SET username = ?, password = ?, email = ? WHERE id = ?")) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());

            ps.executeUpdate();
            return getById(user.getId());
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void deleteById(Integer id) {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM users where id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
