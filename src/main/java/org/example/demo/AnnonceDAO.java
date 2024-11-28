package org.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDAO {

    // Méthode pour récupérer toutes les annonces
    public List<Annonce> getAllAnnonces() throws SQLException {
        List<Annonce> annonces = new ArrayList<>();
        String query = "SELECT id, titre, description, image FROM annonce";

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
        String query = "SELECT * FROM annonce WHERE id = ?";

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


        public List<Annonce> searchAnnonces(String keywords) throws SQLException {
            List<Annonce> annonces = new ArrayList<>();
            String query = "SELECT * FROM annonce WHERE titre ILIKE ? OR description ILIKE ?";

            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {

                String keywordPattern = "%" + keywords + "%";
                statement.setString(1, keywordPattern);
                statement.setString(2, keywordPattern);

                ResultSet resultSet = statement.executeQuery();

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





