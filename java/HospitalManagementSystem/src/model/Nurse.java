
package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "joined_date")
    private Date joinedDate;
    private Boolean active;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Nurse() {
    }

    public Nurse(Integer id) {
        this.id = id;
    }

    public Nurse(Integer id, Date joinedDate, Boolean active, Person person) {
        this.id = id;
        this.joinedDate = joinedDate;
        this.active = active;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
