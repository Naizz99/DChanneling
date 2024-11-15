package auroraskincare.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    
    public enum STATUS {
        PENDING,
        REGISTERED,
        COMPLETED
      }

    
    private int id;
    private LocalDate date;
    private LocalTime time;
    private Patient patient;
    private Dermatologist dermatologist;
    private Treatment treatment;
    private String status;

    public Appointment(Integer id, LocalDate date, LocalTime time, Patient patient, Dermatologist dermatologist, Treatment treatment, String status) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.dermatologist = dermatologist;
        this.treatment = treatment;
        this.status = status;
    }

    public int getId() { return id; }
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public Patient getPatient() { return patient; }
    public Dermatologist getDermatologist() { return dermatologist; }
    public Treatment getTreatment() { return treatment; }
    public String getStatus() { return status; }

    public void setId(int aInt) {
        this.id = id;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
