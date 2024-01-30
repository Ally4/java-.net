
package model;

import javax.persistence.*;

/**
 *
 * @author jeremie
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String names;
    private String email;
    private String address;
    private String phone;
    @OneToOne(mappedBy = "person")
    private Patient patient;
    @OneToOne(mappedBy = "person")
    private Nurse nurse;
    @OneToOne(mappedBy = "person")
    private Doctor doctor;
    @OneToOne(mappedBy = "person")
    private Users users;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Person(Integer id, String names, String email, String address, String phone, Patient patient, Nurse nurse, Doctor doctor, Users users) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.patient = patient;
        this.nurse = nurse;
        this.doctor = doctor;
        this.users = users;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
}
