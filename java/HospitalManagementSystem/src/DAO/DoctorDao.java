
package DAO;

import java.util.List;
import model.Doctor;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class DoctorDao {
//    CRUD
    public Doctor registerDoctor(Doctor doctorObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(doctorObj);
            tr.commit();
            ss.close();
            return doctorObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Doctor updateDoctor(Doctor doctorObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(doctorObj);
            tr.commit();
            ss.close();
            return doctorObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Doctor deleteDoctor(Doctor doctorObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(doctorObj);
            tr.commit();
            ss.close();
            return doctorObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Doctor searchDoctor(Doctor doctorObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Doctor theDoctor = (Doctor)ss.get(Doctor.class, doctorObj.getId());
            ss.close();
            return theDoctor;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Doctor> allDoctors(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Doctor> doctors = ss.createQuery("select theDoctor from Doctor theDoctor").list();
            ss.close();
            return doctors;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
