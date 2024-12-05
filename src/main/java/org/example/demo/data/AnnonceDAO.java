package org.example.demo.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO {

    public List<Annonce> getAllAnnonces() throws SQLException {
        List<Annonce> annonces = new ArrayList<>();
        String query = "SELECT id, titre, description, image FROM annonces";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Annonce annonce = new Annonce();
                annonce.setId(resultSet.getInt("id"));
                annonce.setTitre(resultSet.getString("titre"));
                annonce.setDescription(resultSet.getString("description"));
                annonce.setImage(resultSet.getString("image"));
                annonces.add(annonce);
            }
        }

        return annonces;
    }

    public Annonce getAnnonceById(int id) throws SQLException {
        Annonce annonce = null;
        String query = "SELECT id, titre, description, image FROM annonces WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                annonce = new Annonce();
                annonce.setId(resultSet.getInt("id"));
                annonce.setTitre(resultSet.getString("titre"));
                annonce.setDescription(resultSet.getString("description"));
                annonce.setImage(resultSet.getString("image"));
            }
        }

        return annonce;
    }

    public List<Annonce> searchAnnonces(String motsCles) throws SQLException {
        List<Annonce> annonces = new ArrayList<>();
        String query = "SELECT id, titre, description, image FROM annonces WHERE titre ILIKE ? OR description ILIKE ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            String searchPattern = "%" + motsCles + "%";
            preparedStatement.setString(1, searchPattern);
            preparedStatement.setString(2, searchPattern);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Annonce annonce = new Annonce();
                annonce.setId(resultSet.getInt("id"));
                annonce.setTitre(resultSet.getString("titre"));
                annonce.setDescription(resultSet.getString("description"));
                annonce.setImage(resultSet.getString("image"));
                annonces.add(annonce);
            }
        }

        return annonces;
    }

}
