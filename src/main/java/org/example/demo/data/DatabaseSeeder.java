package org.example.demo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSeeder {

    public static void seedDatabase() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            createTables(connection);
            deleteExistingData(connection);
            insertSampleAnnonces(connection);
            System.out.println("Database seeding completed successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Database seeding failed: " + e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS annonces (" +
                "id SERIAL PRIMARY KEY," +
                "titre TEXT NOT NULL," +
                "description TEXT NOT NULL," +
                "image TEXT" +
                ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    private static void deleteExistingData(Connection connection) throws SQLException {
        String deleteSQL = "DELETE FROM annonces;";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(deleteSQL);
        }
    }

    private static void insertSampleAnnonces(Connection connection) throws SQLException {
        String sql = "INSERT INTO annonces (titre, description, image) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, "Maison charmante à la campagne");
            pstmt.setString(2, "Belle maison de 3 chambres avec un grand jardin.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Appartement moderne en centre-ville");
            pstmt.setString(2, "Appartement rénové, proche de toutes les commodités.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Voiture d'occasion en excellent état");
            pstmt.setString(2, "Voiture fiable avec faible kilométrage.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Bureau en chêne massif");
            pstmt.setString(2, "Bureau ancien idéal pour le salon ou le bureau.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Vélo de course haut de gamme");
            pstmt.setString(2, "Vélo léger, parfait pour les amateurs de cyclisme.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Télévision 4K Ultra HD");
            pstmt.setString(2, "Téléviseur 55 pouces avec technologie HDR.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Table en verre pour salle à manger");
            pstmt.setString(2, "Table contemporaine pouvant accueillir jusqu'à 6 personnes.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Console de jeux dernière génération");
            pstmt.setString(2, "Console neuve avec deux manettes et trois jeux inclus.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Smartphone avec écran OLED");
            pstmt.setString(2, "Téléphone haut de gamme avec grande capacité de stockage.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();

            pstmt.setString(1, "Cours de piano pour débutants");
            pstmt.setString(2, "Professeur expérimenté propose des cours particuliers à domicile.");
            pstmt.setString(3, "https://fastly.picsum.photos/id/1/200/300.jpg?hmac=jH5bDkLr6Tgy3oAg5khKCHeunZMHq0ehBZr6vGifPLY");
            pstmt.executeUpdate();
        }
    }
}
