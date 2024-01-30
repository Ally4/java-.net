
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
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "joined_date")
    private Date joinedDate;
    private Boolean active;
    private String specialization;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToMany(mappedBy = "doctor")
    private List<DoctorSchedule> schedules = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(Integer id) {
        this.id = id;
    }

    public Doctor(Integer id, Date joinedDate, Boolean active, String specialization, Person person) {
        this.id = id;
        this.joinedDate = joinedDate;
        this.active = active;
        this.specialization = specialization;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<DoctorSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<DoctorSchedule> schedules) {
        this.schedules = schedules;
    }
    
}
