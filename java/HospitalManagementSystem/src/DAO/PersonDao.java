
package DAO;

import java.util.List;
import model.Person;
import org.hibernate.*;

/**
 *
 * @author jeremie
 */
public class PersonDao {
//    CRUD
    public Person registerPerson(Person personObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.save(personObj);
            tr.commit();
            ss.close();
            return personObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Person updatePerson(Person personObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.update(personObj);
            tr.commit();
            ss.close();
            return personObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Person deletePerson(Person personObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            // transaction
            Transaction tr = ss.beginTransaction();
            // perform action
            ss.delete(personObj);
            tr.commit();
            ss.close();
            return personObj;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    // search
    public Person searchPerson(Person personObj){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Person thePerson = (Person)ss.get(Person.class, personObj.getId());
            ss.close();
            return thePerson;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public List<Person> allPersons(){
        try{
            // create session
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Person> persons = ss.createQuery("select thePerson from Person thePerson").list();
            ss.close();
            return persons;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 1. we get list of all person from database and
     * 2. in order to get a single person from list of person we use .get(index)
     *    and in-order to get the last one we use persons.size()>> it will return number
     *    of elements we have in list and then after because it's on array logic we get deduct 1
     *    from size so that we get last element because it start from 0 index to size()-1
     * @return person
     */
    public Person getLatestRecorded(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        List<Person> persons = ss.createQuery("select thePerson from Person thePerson").list();
        if(persons!=null){
            return persons.get(persons.size()-1);
        }
        return null;
    }
}
