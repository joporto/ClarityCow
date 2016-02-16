package cl.sgg.controller;
/**
 *
 * @author Murciegalo
 */


import java.io.IOException;
import java.io.PrintWriter; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.sgg.business.*;
import java.util.Iterator.*;
import java.util.ArrayList.*;
import cl.sgg.business.*;
import cl.sgg.business.BajaAnimales.*;
import cl.sgg.utils.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;




public class bajaAnimales extends HttpServlet  
{
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
    BajaAnimales anim = new BajaAnimales();
    Respuesta resp = new Respuesta();     
   
     if(!req.getParameter("txtBuscar").isEmpty() || req.getParameter("txtBuscar") != null){
              String textoBusqueda= req.getParameter("txtBuscar");              
              try {   
              resp =  anim.BuscarDIIO(Integer.parseInt(textoBusqueda));
            if( resp.isStatus() == true){
                System.out.print("Entro");
             String message = "Dio Encontrado";
             String dioActual =  anim.getAnimal().getAnimalDiioActual().toString();
            req.setAttribute("message", message);
            req.setAttribute("dioActual",dioActual);
            
           /* req.setAttribute("fechaBaja", anim.getFechaBaja().toString());*/
           
            req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res); 
            
            
            }else
            {
            String message = "Dio NO Encontrado";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res);   
            }
            
              } catch (Exception ex) {
                  Logger.getLogger(bajaAnimales.class.getName()).log(Level.SEVERE, null, ex);
              }
         
     }else{
          String message = "Ingresar Dio";
          req.setAttribute("message", message);
          req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res);   
     }
     
     
     
    

	}
    
    
    
    

    
 
}