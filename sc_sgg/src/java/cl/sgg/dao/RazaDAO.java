//v1.0.1
package cl.sgg.dao;

import cl.sgg.dal.NewHibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RazaDAO {
    public int add(cl.sgg.edm.Raza a) throws Exception {
        Session sessionA = NewHibernateUtil.getSessionFactory().openSession();
        sessionA.beginTransaction();
        try 
        {
            sessionA.save(a);
            sessionA.getTransaction().commit();
            int result = ((BigInteger) sessionA.createSQLQuery("SELECT LAST_INSERT_ID()")
            .uniqueResult()).intValue();
            sessionA.close();
            
            return result;
        } 
        catch (Exception e) 
        {
            sessionA.getTransaction().rollback();
            sessionA.close();
            System.err.println(e.getMessage());
            throw e;            
        }      
    }
    
    public List<cl.sgg.edm.Raza> getList() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try 
        {
            return (List<cl.sgg.edm.Raza>) session.createCriteria(cl.sgg.edm.Raza.class).list(); 
        } 
        catch (Exception e) 
        {
            session.getTransaction().rollback();
            session.close();
            System.err.println(e.getMessage());
            throw e;
        } 
        finally
        {
            session.close();
        }
    }
    
    public boolean delete(cl.sgg.edm.Raza a) throws Exception {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try 
        {
            session.delete(a);
            session.getTransaction().commit();
            session.close();
            return true;  
        } catch (Exception e) 
        {
            session.getTransaction().rollback();
            session.close();
            System.err.println(e.getMessage());
            throw e;
        } 
    }
     
    public boolean update(cl.sgg.edm.Raza a) throws Exception {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try 
        {
            session.update(a);
            session.getTransaction().commit();
            session.close();
            return true;  
        } catch (Exception e) 
        {
            session.getTransaction().rollback();
            session.close();
            System.err.println(e.getMessage());
            throw e;
        } 
    }
    
    public cl.sgg.edm.Raza getRazaById(int id) throws Exception
    {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cl.sgg.edm.Raza tmp = (cl.sgg.edm.Raza) session.createCriteria(cl.sgg.edm.Raza.class)
                    .add(Restrictions.eq("razaId", id))
                    .uniqueResult();
            
            session.close();
            return tmp;

        } catch (Exception e) 
        {
            System.err.print(e.getMessage());
            session.close();
            throw e;
        }
        
    }
}