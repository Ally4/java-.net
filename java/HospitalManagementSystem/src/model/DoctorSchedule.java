
package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
@Table(name = "doctor_schedule")
public class DoctorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "reserved_date")
    private Date reserverdDate;
    private Boolean active;
    @OneToOne(mappedBy = "schedule")
    private Appointment appointment;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public DoctorSchedule() {
    }

    public DoctorSchedule(Integer id) {
        this.id = id;
    }

    public DoctorSchedule(Integer id, Date reserverdDate, Boolean active, Appointment appointment, Doctor doctor) {
        this.id = id;
        this.reserverdDate = reserverdDate;
        this.active = active;
        this.appointment = appointment;
        this.doctor = doctor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReserverdDate() {
        return reserverdDate;
    }

    public void setReserverdDate(Date reserverdDate) {
        this.reserverdDate = reserverdDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
}
