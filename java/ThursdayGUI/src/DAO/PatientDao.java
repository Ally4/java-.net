
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.Patient;

/**
 *
 * @author jeremie
 */
public class PatientDao {
    //Global Variable Declaration
    private String db_Url="jdbc:postgresql://localhost:5432/thursday_evening";
    private String username="postgres";
    private String passwd="ally";
    public String createPatientPrepared(Patient patientObj){
        try{
            // Create Connection
            Connection con = DriverManager.getConnection(db_Url, username, passwd);
            String sql="insert into patient (patient_id,patient_names) "
                    + "values(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, patientObj.getPatientId());
            pst.setString(2, patientObj.getPatientNames());
            int rowAffected = pst.executeUpdate();
            con.close();
            if(rowAffected>=1){
//                con.close();
                return "The data have been updated successfully!.";
            }else{
//                con.close();
                return "The data have not been updated successfully!.";
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            return "This error is coming from the server!.";
        }
//        return "";
    }
    
    
    public String updatePatientPrepared(Patient patientObj){
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(db_Url, username, passwd);
        String sql = "UPDATE your_table_name SET patient_names = ? WHERE patient_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, patientObj.getPatientNames());
        pst.setInt(2, patientObj.getPatientId());
        int rowAffected = pst.executeUpdate();
        con.close();
        if (rowAffected >= 1) {
            return "The data have been updated successfully!";
        } else {
            return "The data have not been updated successfully!";
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        return "An error occurred while updating the data";
    }
    }
    
public String deletePatientPrepared(Patient patientObj) {
    try {
        // Create Connection
        Connection con = DriverManager.getConnection(db_Url, username, passwd);
        String sql = "DELETE FROM your_table_name WHERE patient_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, patientObj.getPatientId());
        int rowAffected = pst.executeUpdate();
        con.close();
        if (rowAffected >= 1) {
            return "The data have been deleted successfully!";
        } else {
            return "The data have not been deleted successfully!";
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        return "An error occurred while deleting the data";
    }
}
}
