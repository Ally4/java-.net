
package model;

import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private EAppointmentStatus status;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToOne
    @JoinColumn(name = "schedule_id")
    private DoctorSchedule schedule;

    public Appointment() {
    }

    public Appointment(Integer id) {
        this.id = id;
    }

    public Appointment(Integer id, EAppointmentStatus status, Boolean active, Patient patient, DoctorSchedule schedule) {
        this.id = id;
        this.status = status;
        this.active = active;
        this.patient = patient;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EAppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(EAppointmentStatus status) {
        this.status = status;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public DoctorSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(DoctorSchedule schedule) {
        this.schedule = schedule;
    }
    
}
