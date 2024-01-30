
package DAO;

import java.util.List;
import model.Roles;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class RolesDao {
//    CRUD
    public Roles registerRoles(Roles rolesObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(rolesObj);
            tr.commit();
            ss.close();
            return rolesObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Roles updateRoles(Roles rolesObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(rolesObj);
            tr.commit();
            ss.close();
            return rolesObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Roles deleteRoles(Roles rolesObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(rolesObj);
            tr.commit();
            ss.close();
            return rolesObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Roles searchRoles(Roles rolesObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Roles theRoles = (Roles)ss.get(Roles.class, rolesObj.getId());
            ss.close();
            return theRoles;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Roles> allRoless(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Roles> roless = ss.createQuery("select theRoles from Roles theRoles").list();
            ss.close();
            return roless;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
