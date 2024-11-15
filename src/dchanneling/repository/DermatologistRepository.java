package auroraskincare.repository;

import dchanneling.config.DatabaseConnection;
import auroraskincare.model.Dermatologist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DermatologistRepository {
    public Dermatologist saveDermatologist(Dermatologist dermatologist) throws SQLException {
        String selectQuery = "SELECT id, name FROM dermatologist WHERE name = ?";
        String insertQuery = "INSERT INTO dermatologist (name) VALUES (?)";
        String updateQuery = "UPDATE dermatologist SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, dermatologist.getName());
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        int existingId = rs.getInt("id");
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, dermatologist.getName());
                            updateStmt.setInt(2, existingId);
                            updateStmt.executeUpdate();
                        }

                    } else {
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                            insertStmt.setString(1, dermatologist.getName());
                            insertStmt.executeUpdate();

                            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                                if (generatedKeys.next()) {
                                    dermatologist.setId(generatedKeys.getInt(1));
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error adding or updating dermatologist: " + e.getMessage());
            throw e;
        }

        return dermatologist;
    }


    public Dermatologist getDermatologistById(int id) throws SQLException {
        String query = "SELECT * FROM dermatologist WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Dermatologist(Integer.parseInt(rs.getString("id")), rs.getString("name"));
            }
        }
        return null;
    }

    public List<Dermatologist> getAllDermatologists() throws SQLException {
        List<Dermatologist> dermatologists = new ArrayList<>();
        String query = "SELECT * FROM dermatologist";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                dermatologists.add(new Dermatologist(Integer.parseInt(rs.getString("id")), rs.getString("name")));
            }
        }
        return dermatologists;
    }
    
    public boolean deleteDermatologist(int id) throws SQLException {
        String query = "DELETE FROM dermatologist WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;
        }
    }
}
