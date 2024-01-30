
package DAO;

import java.util.List;
import model.Patient;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class PatientDao {
//    CRUD
    public Patient registerPatient(Patient patientObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(patientObj);
            tr.commit();
            ss.close();
            return patientObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Patient updatePatient(Patient patientObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(patientObj);
            tr.commit();
            ss.close();
            return patientObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Patient deletePatient(Patient patientObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(patientObj);
            tr.commit();
            ss.close();
            return patientObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Patient searchPatient(Patient patientObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Patient thePatient = (Patient)ss.get(Patient.class, patientObj.getPatientId());
            ss.close();
            return thePatient;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Patient> allPatients(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Patient> patients = ss.createQuery("select thePatient from Patient thePatient").list();
            ss.close();
            return patients;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
