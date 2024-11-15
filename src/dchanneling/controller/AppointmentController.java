package dchanneling.controller;

import auroraskincare.model.Appointment;
import auroraskincare.service.AppointmentService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AppointmentController {
    private final AppointmentService appointmentService = new AppointmentService();

    public Appointment saveAppointment(Appointment appointment) {
        try {
            return appointmentService.saveAppointment(appointment);
        } catch (SQLException e) {
            System.err.println("Error saving appointment: " + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(int id) {
        try {
            return appointmentService.getAppointmentById(id);
        } catch (SQLException e) {
            System.err.println("Error retrieving appointment by ID: " + e.getMessage());
            return null;
        }
    }

    public List<Appointment> getAllAppointments() {
        try {
            return appointmentService.getAllAppointments();
        } catch (SQLException e) {
            System.err.println("Error retrieving appointments: " + e.getMessage());
            return null;
        }
    }

    public List<Appointment> searchAppointments(Integer appointmentId, String patientName, LocalDate appointmentDate) {
        try {
            return appointmentService.searchAppointments(appointmentId, patientName, appointmentDate);
        } catch (SQLException e) {
            System.err.println("Error searching for appointments: " + e.getMessage());
            return null;
        }
    }
    
    public List<Appointment> getAppointmentsForDermatologist(Integer dermatologistId, LocalDate date) {
        return appointmentService.getAppointmentsForDermatologist(dermatologistId, date);
    }
    
    public boolean deleteAppointment(int id) {
        try {
            return appointmentService.deleteAppointment(id);
        } catch (SQLException e) {
            System.err.println("Error deleting appointment: " + e.getMessage());
            return false;
        }
    }

}
