
package DAO;

import java.util.List;
import model.Appointment;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class AppointmentDao {
//    CRUD
    public Appointment registerAppointment(Appointment appointmentObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(appointmentObj);
            tr.commit();
            ss.close();
            return appointmentObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Appointment updateAppointment(Appointment appointmentObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(appointmentObj);
            tr.commit();
            ss.close();
            return appointmentObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Appointment deleteAppointment(Appointment appointmentObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(appointmentObj);
            tr.commit();
            ss.close();
            return appointmentObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Appointment searchAppointment(Appointment appointmentObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Appointment theAppointment = (Appointment)ss.get(Appointment.class, appointmentObj.getId());
            ss.close();
            return theAppointment;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Appointment> allAppointments(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Appointment> appointments = ss.createQuery("select theAppointment from Appointment theAppointment").list();
            ss.close();
            return appointments;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
