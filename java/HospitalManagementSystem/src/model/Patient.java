
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;
    private EVisit visit;
    @Column(name = "visit_date")
    private Date visitDate;
    private EService service;
    private String observation;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<>();

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient(Integer patientId, EVisit visit, Date visitDate, EService service, String observation, Person person) {
        this.patientId = patientId;
        this.visit = visit;
        this.visitDate = visitDate;
        this.service = service;
        this.observation = observation;
        this.person = person;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public EVisit getVisit() {
        return visit;
    }

    public void setVisit(EVisit visit) {
        this.visit = visit;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public EService getService() {
        return service;
    }

    public void setService(EService service) {
        this.service = service;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
}
