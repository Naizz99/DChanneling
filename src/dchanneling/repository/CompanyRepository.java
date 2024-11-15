package auroraskincare.repository;

import auroraskincare.model.Company;
import dchanneling.config.DatabaseConnection;
import java.sql.*;

public class CompanyRepository {

    public Company getCompany() throws SQLException {
        String query = "SELECT * FROM company WHERE id = 1"; 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return new Company(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("mobile"),
                    rs.getString("address")
                );
            }
            return null; 
        }
    }

    public void updateCompany(Company company) throws SQLException {
        String query = "UPDATE company SET name = ?, email = ?, mobile = ?, address = ? WHERE id = 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, company.getName());
            stmt.setString(2, company.getEmail());
            stmt.setString(3, company.getMobile());
            stmt.setString(4, company.getAddress());
            stmt.executeUpdate();
        }
    }
}
