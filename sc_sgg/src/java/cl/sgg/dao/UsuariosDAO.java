/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.dao;

import cl.sgg.dal.NewHibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author javierOporto
 */
public class UsuariosDAO 
{
    public boolean add(cl.sgg.edm.Usuarios a) throws Exception {
        Session sessionA = NewHibernateUtil.getSessionFactory().openSession();
        sessionA.beginTransaction();
        try 
        {
            sessionA.save(a);
            sessionA.getTransaction().commit();
            sessionA.close();
            return true;            
        } 
        catch (Exception e) 
        {
            sessionA.getTransaction().rollback();
            sessionA.close();
            System.err.println(e.getMessage());
            throw e;            
        }      
    }
    
    public List<cl.sgg.edm.Usuarios> getList() throws Exception {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try 
        {
            return (List<cl.sgg.edm.Usuarios>) session.createCriteria(cl.sgg.edm.Usuarios.class).list(); 
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
     
    public boolean update(cl.sgg.edm.Usuarios a) throws Exception {
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
    
    public cl.sgg.edm.Usuarios getUser(String userName, String password) throws Exception
    {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cl.sgg.edm.Usuarios tmp = (cl.sgg.edm.Usuarios) session.createCriteria(cl.sgg.edm.Usuarios.class)
                    .add(Restrictions.eq("userName", userName))
                    .add(Restrictions.eq("password", password))
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
