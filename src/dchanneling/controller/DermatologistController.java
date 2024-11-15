package dchanneling.controller;

import auroraskincare.model.Dermatologist;
import auroraskincare.service.DermatologistService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DermatologistController {
    private final DermatologistService dermatologistService = new DermatologistService();

    public Dermatologist saveDermatologist(Dermatologist dermatologist) {
        try {
            return dermatologistService.saveDermatologist(dermatologist);
        } catch (SQLException e) {
            System.err.println("Error saving dermatologist: " + e.getMessage());
            return null;
        }
    }

    public Dermatologist getDermatologistById(int id) {
        try {
            return dermatologistService.getDermatologistById(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving dermatologist by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Dermatologist> getAllDermatologists() {
        try {
            return dermatologistService.getAllDermatologists();
        } catch (SQLException e) {
            System.err.println("Error retrieving dermatologists: " + e.getMessage());
            return null;
        }
    }

    public boolean deleteDermatologist(int id) {
        try {
            return dermatologistService.deleteDermatologist(id);
        } catch (SQLException e) {
            System.err.println("Error deleting dermatologist: " + e.getMessage());
            return false;
        }
    }
}
