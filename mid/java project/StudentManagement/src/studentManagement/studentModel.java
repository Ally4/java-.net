/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManagement;

/**
 *
 * @author bertrandyrn
 */
public class studentModel {
    String id;
    String fname;
    String lname;
    String address;
    String email;

    public studentModel(String id, String fname, String lname, String address, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getFac() {
        return address;
    }

    public String getDep() {
        return email;
    } 
}
