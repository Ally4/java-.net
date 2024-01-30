
package DAO;

import java.util.List;
import model.Nurse;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class NurseDao {
//    CRUD
    public Nurse registerNurse(Nurse nurseObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(nurseObj);
            tr.commit();
            ss.close();
            return nurseObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Nurse updateNurse(Nurse nurseObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(nurseObj);
            tr.commit();
            ss.close();
            return nurseObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Nurse deleteNurse(Nurse nurseObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(nurseObj);
            tr.commit();
            ss.close();
            return nurseObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Nurse searchNurse(Nurse nurseObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Nurse theNurse = (Nurse)ss.get(Nurse.class, nurseObj.getId());
            ss.close();
            return theNurse;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Nurse> allNurses(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Nurse> nurses = ss.createQuery("select theNurse from Nurse theNurse").list();
            ss.close();
            return nurses;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
