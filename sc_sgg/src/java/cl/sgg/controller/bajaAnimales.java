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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class bajaAnimales extends HttpServlet  
{
    
    int DIO = 0; 
    BajaAnimales anim = new BajaAnimales();
    Respuesta resp = new Respuesta();  
    List<String> list = new ArrayList<String>();
    String motivo = "Muerto";
    String valorBtn = "";
    String valorDio = "";
    boolean valorCheck = true;
 
    /*
      public  List<String> cbEstado(String valor){
       List<String> Lista = new ArrayList<String>();
       
       if("Muerto".equals(motivo)){           
           System.out.print("Entero de Muerto ");           
           Lista =  anim.getListaCb();
           System.out.print("SALE DE ACA ");
       }
       
       if("Robo".equals(motivo)){           
           System.out.print("Entero de Robado ");
           anim.setMotivoAparente(motivo);
           Lista =  anim.getListaCb();
       }                  
       return Lista;
        }
    */
    
    
             
    
    
    
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
          System.out.print("uno");
         
          
              if(req.getParameter("botonForm")!= null || "".equals(req.getParameter("botonForm")))
            {
               valorBtn= req.getParameter("botonForm");               
            }
            else
            {
              valorBtn= req.getParameter("valorBoton");            
            }
      
            
         
       /*  motivo = req.getParameter("radios");*/
         
        
       
        
            if("Buscar".equals(valorBtn.toString()))
            {
       
              if(!"".equals(req.getParameter("txtBuscar")) && req.getParameter("txtBuscar") != null )
            {
               valorDio= req.getParameter("txtBuscar");              
            }
            else
            {
              valorDio= req.getParameter("escondido");             
            }
       
            
               
 
       DIO = Integer.parseInt(valorDio);
         
   
 
   /*  if(!req.getParameter("txtBuscar").isEmpty() || req.getParameter("txtBuscar") != null){*/
            /*  String textoBusqueda= req.getParameter("txtBuscar");*/
           
              try {   
              System.out.print(DIO);
              resp =  anim.BuscarDIIO(DIO);
       
            
            if( resp.isStatus() == true){
              String message = "Dio Encontrado";
          
             String dioActual =  anim.getAnimal().getAnimalDiioActual().toString();
          
             
             
             
             
                 System.out.print(req.getParameter("Motivo"));
                 motivo = req.getParameter("Motivo");
                 anim.setMotivoAparente(motivo);
                 System.out.println("Motivo Aparente ===="+anim.CargarCbMotivoAparente(motivo).isStatus());
                 anim.CargarCbMotivoAparente(motivo);
                try {
                    if(anim.CargarCbMotivoAparente(motivo).isStatus())
                    {        
                       
                        list =  anim.getListaCb();
                        for (int i = 0; i < list.size(); i++) {
                            System.out.print(list.get(i));
                            
                                              }
                    } else {
                    } 
                } catch (Exception e) {
                }
                  
                  
              
             
             if("Muerto".equals(motivo)   ){
                 valorCheck = true;
             }
             else{
                 valorCheck = false;
             }
             
           
            
                
            req.setAttribute("message", message);
            req.setAttribute("dioActual",dioActual);
            req.setAttribute("lista", list);
            req.setAttribute("valorCheck", valorCheck);
            req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res); 

            }else{
            String message = "Dio NO Encontrado";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res);   
            }
            
              } catch (Exception ex) {
                  Logger.getLogger(bajaAnimales.class.getName()).log(Level.SEVERE, null, ex);
              }
         
   /*  }else{
          String message = "Ingresar Dio";
          req.setAttribute("message", message);
          req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res);   
     }*/
     
            }
            
           if("Guardar".equals(valorBtn.toString()))
            {
                  System.out.print("Entro Guardar");
            anim.setMotivoAparente(motivo);

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String fechaBaja = req.getParameter("fechaBaja");   
    String motivoAparente = req.getParameter("selMotivo");
              
         Date fecha = new Date();
        try {
            fecha = formatter.parse(fechaBaja);
            System.out.printf(fecha.toString());         
            Boolean resultado = false ;      
           anim.GuardarBajaAnimales(fecha, motivo, motivoAparente);
           resultado = anim.GuardarBajaAnimales(fecha, motivo, motivoAparente).isStatus();
           
           if(resultado == true){              
           System.out.print("Resultado Guardar: "+resultado);
           req.setAttribute("resultadoGuardar", resultado);
           }
           else{
           System.out.print("Resultado NO: "+resultado); 
           req.setAttribute("resultadoGuardar", resultado);
           }
           
          
           
        } catch (ParseException ex) {
            Logger.getLogger(guardarBaja.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(guardarBaja.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res); 
      
        
      /* String motivo= req.getParameter("fechaBaja"); 
       String motivoAparente= req.getParameter("fechaBaja");*/
          
     
       
      
   
            }
            
            
     
    
 
        }
    

   

    
 
}