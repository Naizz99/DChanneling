package auroraskincare.service;

import auroraskincare.model.Treatment;
import auroraskincare.repository.TreatmentRepository;
import java.sql.SQLException;
import java.util.List;

public class TreatmentService {
    private final TreatmentRepository repo;

    public TreatmentService() {
        repo = new TreatmentRepository();
    }

    public Treatment saveTreatment(Treatment treatment) throws SQLException {
        return repo.saveTreatment(treatment);
    }

    public Treatment getTreatmentById(int id) throws SQLException {
        return repo.getTreatmentById(id);
    }

    public List<Treatment> getAllTreatments() throws SQLException {
        return repo.getAllTreatments();
    }
    
    public boolean deleteTreatment(int id) throws SQLException {
        return repo.deleteTreatment(id);
    }
}