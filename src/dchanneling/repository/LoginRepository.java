package auroraskincare.repository;

import dchanneling.config.DatabaseConnection;
import auroraskincare.model.Login;
import java.sql.*;

public class LoginRepository {

    public Login getLoginByUsername(String username) throws SQLException {
        String query = "SELECT * FROM login WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Login(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
            return null;
        }
    }
    
    public void addLogin(Login login) throws SQLException {
        String query = "INSERT INTO login (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login.getUsername());
            stmt.setString(2, login.getPassword());
            stmt.executeUpdate();
        }
    }

    public void updateLogin(Login login) throws SQLException {
        String query = "UPDATE login SET username = ?, password = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, login.getUsername());
            stmt.setString(2, login.getPassword());
            stmt.setInt(3, login.getId());
            stmt.executeUpdate();
        }
    }
}

