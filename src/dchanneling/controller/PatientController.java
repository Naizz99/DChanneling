package dchanneling.controller;

import auroraskincare.model.Patient;
import auroraskincare.service.PatientService;
import java.sql.SQLException;
import java.util.List;

public class PatientController {

    private final PatientService patientService = new PatientService();

    public Patient savePatient(Patient patient) {
        try {
            return patientService.savePatient(patient);
        } catch (SQLException e) {
            System.err.println("Error saving patient: " + e.getMessage());
            return null;
        }
    }

    public Patient getPatientByNic(String nic) {
        try {
            return patientService.getPatientByNic(nic);
        } catch (SQLException e) {
            System.err.println("Error retrieving patient by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Patient> getAllPatients() {
        try {
            return patientService.getAllPatients();
        } catch (SQLException e) {
            System.err.println("Error retrieving patients: " + e.getMessage());
            return null;
        }
    }
    
    public boolean deletePatient(String nic) {
        try {
            return patientService.deletePatient(nic);
        } catch (SQLException e) {
            System.err.println("Error deleting patient: " + e.getMessage());
            return false;
        }
    }
}
