package auroraskincare.service;

import auroraskincare.model.Company;
import auroraskincare.repository.CompanyRepository;
import java.sql.SQLException;

public class CompanyService {

    private final CompanyRepository repo = new CompanyRepository();

    public Company getCompany() throws SQLException {
        return repo.getCompany();
    }

    public void updateCompany(Company company) throws SQLException {
        repo.updateCompany(company);
    }
    
}
