package dchanneling.controller;

import auroraskincare.model.Company;
import auroraskincare.service.CompanyService;
import java.sql.*;

public class CompanyController {
    private final CompanyService companyService = new CompanyService();

    public Company showCompanyDetails() {
        try {
            Company company = companyService.getCompany();
            if (company != null) {
                return company;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching company details: " + e.getMessage());
        }
        return null;
    }
    
    public void updateCompanyDetails(String name, String email, String mobile, String address) {
        try {
            Company company = new Company(1, name, email, mobile, address); 
            companyService.updateCompany(company);
            System.out.println("Company details updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating company details: " + e.getMessage());
        }
    }
}

