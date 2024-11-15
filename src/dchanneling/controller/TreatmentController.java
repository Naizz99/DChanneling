package dchanneling.controller;

import auroraskincare.model.Treatment;
import auroraskincare.service.TreatmentService;
import java.sql.SQLException;
import java.util.List;

public class TreatmentController {
    private final TreatmentService treatmentService = new TreatmentService();

    public Treatment saveTreatment(Treatment treatment) {
        try {
            return treatmentService.saveTreatment(treatment);
        } catch (SQLException e) {
            System.err.println("Error saving treatment: " + e.getMessage());
            return null;
        }
    }

    public Treatment getTreatmentById(int id) {
        try {
            return treatmentService.getTreatmentById(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving treatment by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Treatment> getAllTreatments() {
        try {
            return treatmentService.getAllTreatments();
        } catch (SQLException e) {
            System.err.println("Error retrieving treatments: " + e.getMessage());
            return null;
        }
    }

    public boolean deleteTreatment(int id) {
        try {
            return treatmentService.deleteTreatment(id);
        } catch (SQLException e) {
            System.err.println("Error deleting treatment: " + e.getMessage());
            return false;
        }
    }

}
