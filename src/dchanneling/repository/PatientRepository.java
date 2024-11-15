package auroraskincare.repository;

import dchanneling.config.DatabaseConnection;
import auroraskincare.model.Patient;
import auroraskincare.model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    
    public Patient savePatient(Patient patient) throws SQLException {
        String selectQuery = "SELECT nic FROM patient WHERE nic = ?";
        String insertQuery = "INSERT INTO patient (nic, name, email, phone) VALUES (?, ?, ?, ?)";
        String updateQuery = "UPDATE patient SET name = ?, email = ?, phone = ? WHERE nic = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            try (PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
                selectStmt.setString(1, patient.getNic());
                try (ResultSet rs = selectStmt.executeQuery()) {
                    if (rs.next()) {
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                            updateStmt.setString(1, patient.getName());
                            updateStmt.setString(2, patient.getEmail());
                            updateStmt.setString(3, patient.getPhone());
                            updateStmt.setString(4, patient.getNic());
                            updateStmt.executeUpdate();
                        }
                    } else {
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                            insertStmt.setString(1, patient.getNic());
                            insertStmt.setString(2, patient.getName());
                            insertStmt.setString(3, patient.getEmail());
                            insertStmt.setString(4, patient.getPhone());
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error adding or updating patient: " + e.getMessage());
            throw e;
        }
        return patient;
    }

    public Patient getPatientByNic(String nic) throws SQLException {
        String query = "SELECT * FROM patient WHERE nic = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, nic);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getString("nic"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
            }
        }
        return null;
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patient";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                patients.add(new Patient(rs.getString("nic"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
            }
        }
        return patients;
    }
    
    public boolean deletePatient(String nic) throws SQLException {
        String query = "DELETE FROM patient WHERE nic = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, nic);
            return stmt.executeUpdate() > 0;
        }
        
    }
}
