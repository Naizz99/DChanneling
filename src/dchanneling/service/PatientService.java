package auroraskincare.service;

import auroraskincare.model.Patient;
import auroraskincare.repository.PatientRepository;
import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private final PatientRepository repo;

    public PatientService() {
        repo = new PatientRepository();
    }

    public Patient savePatient(Patient patient) throws SQLException {
        return repo.savePatient(patient);
    }

    public Patient getPatientByNic(String nic) throws SQLException  {
        return repo.getPatientByNic(nic);
    }

    public List<Patient> getAllPatients() throws SQLException  {
        return repo.getAllPatients();
    }
    
    public boolean deletePatient(String nic) throws SQLException  {
        return repo.deletePatient(nic);
    }
}