package auroraskincare.repository;

import dchanneling.config.DatabaseConnection;
import auroraskincare.model.Treatment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatmentRepository {
    public Treatment saveTreatment(Treatment treatment) throws SQLException {
        String selectQuery = "SELECT id FROM treatment WHERE type = ?";
        String insertQuery = "INSERT INTO treatment (type, price) VALUES (?, ?)";
        String updateQuery = "UPDATE treatment SET type = ?, price = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, treatment.getType());
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        int existingId = rs.getInt("id");
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, treatment.getType());
                            updateStmt.setDouble(2, treatment.getPrice());
                            updateStmt.setInt(3, existingId);
                            updateStmt.executeUpdate();
                        }
                    } else {
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                            insertStmt.setString(1, treatment.getType());
                            insertStmt.setDouble(2, treatment.getPrice());
                            insertStmt.executeUpdate();

                            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                                if (generatedKeys.next()) {
                                    treatment.setId(generatedKeys.getInt(1));
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error adding or updating treatment: " + e.getMessage());
            throw e;
        }

        return treatment;
    }



    public Treatment getTreatmentById(int id) throws SQLException {
        String query = "SELECT * FROM treatment WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, String.valueOf(id));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Treatment(Integer.parseInt(rs.getString("id")), rs.getString("type"), Double.parseDouble(rs.getString("price")));
            }
        }
        return null;
    }

    public List<Treatment> getAllTreatments() throws SQLException {
        List<Treatment> treatments = new ArrayList<>();
        String query = "SELECT * FROM treatment";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                treatments.add(new Treatment(Integer.parseInt(rs.getString("id")), rs.getString("type"), Double.parseDouble(rs.getString("price"))));
            }
        }
        return treatments;
    }
    
    public boolean deleteTreatment(int id) throws SQLException {
        String query = "DELETE FROM treatment WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;
        }
    }
}
