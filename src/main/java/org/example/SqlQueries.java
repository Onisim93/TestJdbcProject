package org.example;

public enum SqlQueries {

    SELECT_BY_ID("select * from books b where b.author_id = ? and b.id = ?"),
    CREATE("INSERT INTO genres (name, description) VALUES (?,?)"),
    CREATE_ST("INSERT INTO genres (description) VALUES (?)"),
    UPDATE("UPDATE genres SET name = ?, description = ? WHERE id = ?"),
    DELETE("DELETE FROM genres WHERE id = ?");


    public final String sql;

    SqlQueries(String sql) {
        this.sql = sql;
    }
}
