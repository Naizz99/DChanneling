package auroraskincare.repository;

import dchanneling.config.DatabaseConnection;
import auroraskincare.model.Appointment;
import auroraskincare.model.Dermatologist;
import auroraskincare.model.Patient;
import auroraskincare.model.Treatment;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    public Appointment saveAppointment(Appointment appointment) throws SQLException {
        String insertQuery = "INSERT INTO appointment (date, time, patient, dermatologist, treatment, status) VALUES (?, ?, ?, ?, ?, ?)";
        String updateQuery = "UPDATE appointment SET date = ?, time = ?, patient = ?, dermatologist = ?, treatment = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (appointment.getId() == 0) {
                try (PreparedStatement stmt = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setDate(1, Date.valueOf(appointment.getDate()));
                    stmt.setTime(2, Time.valueOf(appointment.getTime()));
                    stmt.setString(3, appointment.getPatient().getNic());
                    stmt.setInt(4, appointment.getDermatologist().getId());
                    stmt.setInt(5, (int) appointment.getTreatment().getId());
                    stmt.setString(6, appointment.getStatus());

                    stmt.executeUpdate();
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            appointment.setId(generatedKeys.getInt(1));
                        }
                    }
                }
            } else {
                try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
                    stmt.setDate(1, Date.valueOf(appointment.getDate()));
                    stmt.setTime(2, Time.valueOf(appointment.getTime()));
                    stmt.setString(3, appointment.getPatient().getNic());
                    stmt.setInt(4, appointment.getDermatologist().getId());
                    stmt.setInt(5, (int) appointment.getTreatment().getId());
                    stmt.setString(6, appointment.getStatus());
                    stmt.setInt(7, appointment.getId());

                    stmt.executeUpdate();
                }
            }
        }
        return appointment;
    }

    public Appointment getAppointmentById(int id) throws SQLException {
        String query = "SELECT * FROM appointment WHERE id = ?";
        Appointment appointment = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Patient patient = new PatientRepository().getPatientByNic(rs.getString("patient"));
                    Dermatologist dermatologist = new DermatologistRepository().getDermatologistById(rs.getInt("dermatologist"));
                    Treatment treatment = new TreatmentRepository().getTreatmentById(rs.getInt("treatment"));

                    appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime(),
                        patient,
                        dermatologist,
                        treatment,
                        rs.getString("status")
                    );
                }
            }
        }
        return appointment;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointment";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Patient patient = new PatientRepository().getPatientByNic(rs.getString("patient"));
                Dermatologist dermatologist = new DermatologistRepository().getDermatologistById(rs.getInt("dermatologist"));
                Treatment treatment = new TreatmentRepository().getTreatmentById(rs.getInt("treatment"));

                Appointment appointment = new Appointment(
                    rs.getInt("id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getTime("time").toLocalTime(),
                    patient,
                    dermatologist,
                    treatment,
                    rs.getString("status")
                );
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public List<Appointment> getAppointmentsForDermatologist(Integer dermatologistId, LocalDate date) {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointment WHERE dermatologist = ? AND date = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, dermatologistId);
            stmt.setDate(2, Date.valueOf(date));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Patient patient = new PatientRepository().getPatientByNic(rs.getString("patient"));
                    Dermatologist dermatologist = new DermatologistRepository().getDermatologistById(rs.getInt("dermatologist"));
                    Treatment treatment = new TreatmentRepository().getTreatmentById(rs.getInt("treatment"));

                    Appointment appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime(),
                        patient,
                        dermatologist,
                        treatment,
                        rs.getString("status")
                    );
                    appointments.add(appointment);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return appointments;
    }

    
    public List<Appointment> searchAppointments(Integer appointmentId, String patientName, LocalDate appointmentDate) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM appointment a JOIN patient p ON a.patient = p.nic WHERE 1=1");

        if (appointmentId != null) {
            queryBuilder.append(" AND a.id = ?");
        }
        if (patientName != null && !patientName.isEmpty()) {
            queryBuilder.append(" AND p.name LIKE ?");
        }
        if (appointmentDate != null) {
            queryBuilder.append(" AND a.date = ?");
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryBuilder.toString())) {

            int index = 1;
            if (appointmentId != null) {
                stmt.setInt(index++, appointmentId);
            }
            if (patientName != null && !patientName.isEmpty()) {
                stmt.setString(index++, "%" + patientName + "%");
            }
            if (appointmentDate != null) {
                stmt.setDate(index, Date.valueOf(appointmentDate));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Patient patient = new PatientRepository().getPatientByNic(rs.getString("patient"));
                    Dermatologist dermatologist = new DermatologistRepository().getDermatologistById(rs.getInt("dermatologist"));
                    Treatment treatment = new TreatmentRepository().getTreatmentById(rs.getInt("treatment"));

                    Appointment appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime(),
                        patient,
                        dermatologist,
                        treatment,
                        rs.getString("status")
                    );
                    appointments.add(appointment);
                }
            }
        }
        return appointments;
    }
    
    public boolean deleteAppointment(int id) throws SQLException {
        String query = "DELETE FROM appointment WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

}
