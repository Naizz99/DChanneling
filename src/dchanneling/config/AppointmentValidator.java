package dchanneling.config;

import auroraskincare.model.Appointment;
import auroraskincare.model.Dermatologist;
import auroraskincare.view.AppointmentForm;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.time.DayOfWeek;
import javax.swing.JOptionPane;

public class AppointmentValidator {

    private static final LocalTime MONDAY_START = LocalTime.of(10, 0);
    private static final LocalTime MONDAY_END = LocalTime.of(13, 0);
    private static final LocalTime WEDNESDAY_START = LocalTime.of(14, 0);
    private static final LocalTime WEDNESDAY_END = LocalTime.of(17, 0);
    private static final LocalTime FRIDAY_START = LocalTime.of(16, 0);
    private static final LocalTime FRIDAY_END = LocalTime.of(20, 0);
    private static final LocalTime SATURDAY_START = LocalTime.of(9, 0);
    private static final LocalTime SATURDAY_END = LocalTime.of(13, 0);

    private List<Appointment> existingAppointments = new ArrayList<>();
    private final AppointmentForm form;
    
    public AppointmentValidator(AppointmentForm form, List<Appointment> existingAppointments) {
        this.existingAppointments = existingAppointments;
        this.form = form;
    }

    public boolean validateAppointment(LocalDate appointmentDate, LocalTime appointmentTime, Dermatologist dermatologist) {
        if (!isValidDay(appointmentDate)) {
            JOptionPane.showMessageDialog(form, "Invalid day for appointment.");
            return false;
        }

        if (!isWithinWorkingHours(appointmentDate, appointmentTime)) {
            JOptionPane.showMessageDialog(form, "Appointment time is outside the available working hours.");
            return false;
        }

        if (isConflictWithExistingAppointments(appointmentDate, appointmentTime, dermatologist)) {
            JOptionPane.showMessageDialog(form, "This time slot is already taken.");
            return false;
        }

        return true;
    }

    private boolean isValidDay(LocalDate appointmentDate) {
        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        return dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.WEDNESDAY || dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    private boolean isWithinWorkingHours(LocalDate appointmentDate, LocalTime appointmentTime) {
        DayOfWeek dayOfWeek = appointmentDate.getDayOfWeek();
        if (null != dayOfWeek) switch (dayOfWeek) {
            case MONDAY:
                return !appointmentTime.isBefore(MONDAY_START) && !appointmentTime.isAfter(MONDAY_END.minusMinutes(15));
            case WEDNESDAY:
                return !appointmentTime.isBefore(WEDNESDAY_START) && !appointmentTime.isAfter(WEDNESDAY_END.minusMinutes(15));
            case FRIDAY:
                return !appointmentTime.isBefore(FRIDAY_START) && !appointmentTime.isAfter(FRIDAY_END.minusMinutes(15));
            case SATURDAY:
                return !appointmentTime.isBefore(SATURDAY_START) && !appointmentTime.isAfter(SATURDAY_END.minusMinutes(15));
            default:
                break;
        }
        return false;
    }

    private boolean isConflictWithExistingAppointments(LocalDate appointmentDate, LocalTime appointmentTime, Dermatologist dermatologist) {
        for (Appointment existingAppointment : existingAppointments) {
            if (existingAppointment.getDermatologist().getId() == dermatologist.getId()
                && existingAppointment.getDate().equals(appointmentDate)) {
            
            LocalTime existingStartTime = existingAppointment.getTime();
            LocalTime existingEndTime = existingStartTime.plusMinutes(14);

            if (!appointmentTime.isBefore(existingStartTime) && !appointmentTime.isAfter(existingEndTime)) {
                System.out.println("Conflicting appointment found: " + existingAppointment.getId());
                return true;
            }
        }

        }
        return false;
    }

}
