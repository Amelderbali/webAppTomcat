package org.example.demo.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/annonces?characterEncoding=UTF-8"; // URL de la base de données
    private static final String USER = "postgres"; // Nom d'utilisateur PostgreSQL
    private static final String PASSWORD = "admin"; // Mot de passe PostgreSQL

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Erreur de chargement du driver JDBC", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
