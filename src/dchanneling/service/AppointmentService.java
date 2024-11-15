package auroraskincare.service;

import auroraskincare.model.Appointment;
import auroraskincare.repository.AppointmentRepository;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class AppointmentService {
    private final AppointmentRepository repo = new AppointmentRepository();

    public Appointment saveAppointment(Appointment appointment) throws SQLException {
        return repo.saveAppointment(appointment);
    }

    public Appointment getAppointmentById(int id) throws SQLException {
        return repo.getAppointmentById(id);
    }
    
    public List<Appointment> getAllAppointments() throws SQLException {
        return repo.getAllAppointments();
    }

    public List<Appointment> getAppointmentsForDermatologist(Integer dermatologistId, LocalDate date) {
        return repo.getAppointmentsForDermatologist(dermatologistId, date);
    }
    
    public List<Appointment> searchAppointments(Integer appointmentId, String patientName, LocalDate appointmentDate) throws SQLException {
        return repo.searchAppointments(appointmentId, patientName, appointmentDate);
    }

    public boolean deleteAppointment(int id) throws SQLException {
        return repo.deleteAppointment(id);
    }

}

