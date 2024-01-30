
package DAO;

import java.util.List;
import model.DoctorSchedule;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class DoctorScheduleDao {
//    CRUD
    public DoctorSchedule registerDoctorSchedule(DoctorSchedule doctorScheduleObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(doctorScheduleObj);
            tr.commit();
            ss.close();
            return doctorScheduleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public DoctorSchedule updateDoctorSchedule(DoctorSchedule doctorScheduleObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(doctorScheduleObj);
            tr.commit();
            ss.close();
            return doctorScheduleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public DoctorSchedule deleteDoctorSchedule(DoctorSchedule doctorScheduleObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(doctorScheduleObj);
            tr.commit();
            ss.close();
            return doctorScheduleObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public DoctorSchedule searchDoctorSchedule(DoctorSchedule doctorScheduleObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            DoctorSchedule theDoctorSchedule = (DoctorSchedule)ss.get(DoctorSchedule.class, doctorScheduleObj.getId());
            ss.close();
            return theDoctorSchedule;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<DoctorSchedule> allDoctorSchedules(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<DoctorSchedule> doctorSchedules = ss.createQuery("select theDoctorSchedule from DoctorSchedule theDoctorSchedule").list();
            ss.close();
            return doctorSchedules;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
