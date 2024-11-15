package auroraskincare.service;

import auroraskincare.model.Dermatologist;
import auroraskincare.repository.DermatologistRepository;
import java.sql.SQLException;
import java.util.List;

public class DermatologistService {
    private final DermatologistRepository repo;

    public DermatologistService() {
        repo = new DermatologistRepository();
    }

    public Dermatologist saveDermatologist(Dermatologist dermatologist) throws SQLException {
        return repo.saveDermatologist(dermatologist);
    }

    public Dermatologist getDermatologistById(int id) throws SQLException {
        return repo.getDermatologistById(id);
    }

    public List<Dermatologist> getAllDermatologists() throws SQLException {
        return repo.getAllDermatologists();
    }
    
    public boolean deleteDermatologist(int id) throws SQLException {
        return repo.deleteDermatologist(id);
    }
}