
package DAO;

import java.util.List;
import model.Rights;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class RightsDao {
//    CRUD
    public Rights registerRights(Rights rightsObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(rightsObj);
            tr.commit();
            ss.close();
            return rightsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Rights updateRights(Rights rightsObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(rightsObj);
            tr.commit();
            ss.close();
            return rightsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Rights deleteRights(Rights rightsObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(rightsObj);
            tr.commit();
            ss.close();
            return rightsObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Rights searchRights(Rights rightsObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Rights theRights = (Rights)ss.get(Rights.class, rightsObj.getId());
            ss.close();
            return theRights;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Rights> allRightss(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Rights> rightss = ss.createQuery("select theRights from Rights theRights").list();
            ss.close();
            return rightss;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
