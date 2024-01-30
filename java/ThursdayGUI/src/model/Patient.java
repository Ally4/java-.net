/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jeremie
 */
public class Patient {
    private int patientId;
    private String patientNames;

    public Patient() {
    }

    public Patient(int patientId, String patientNames) {
        this.patientId = patientId;
        this.patientNames = patientNames;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientNames() {
        return patientNames;
    }

    public void setPatientNames(String patientNames) {
        this.patientNames = patientNames;
    }
    
}
