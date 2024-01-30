/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentManagement;

/**
 *
 * @author klion
 */
public class adminModel {
    
    String id;
    String fname;
    String lname;
    String pass;

    public adminModel(String id, String fname, String lname, String pass) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }
    
}
