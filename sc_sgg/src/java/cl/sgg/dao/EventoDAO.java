//v1.1.0
package cl.sgg.dao;

import cl.sgg.dal.NewHibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EventoDAO {
    
    public int add(cl.sgg.edm.Evento a) throws Exception {
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
    
    public List<cl.sgg.edm.Evento> getList() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try 
        {
            return (List<cl.sgg.edm.Evento>) session.createCriteria(cl.sgg.edm.Evento.class).list(); 
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
    
    public boolean delete(cl.sgg.edm.Evento a) throws Exception {
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
     
    public boolean update(cl.sgg.edm.Evento a) throws Exception {
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
    
    public cl.sgg.edm.Evento getEventoById(int id) throws Exception
    {
         Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cl.sgg.edm.Evento tmp = (cl.sgg.edm.Evento) session.createCriteria(cl.sgg.edm.Evento.class)
                    .add(Restrictions.eq("eventoId", id))
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
