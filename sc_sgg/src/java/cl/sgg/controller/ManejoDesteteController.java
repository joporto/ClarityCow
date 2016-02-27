/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.controller;


import cl.sgg.business.FeedlotManejoDestete;
import cl.sgg.business.GrillaInsumo;
import cl.sgg.edm.Animal;
import cl.sgg.edm.Insumo;
import cl.sgg.utils.Respuesta;
import com.sun.faces.action.RequestMapping;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
 

 


import java.io.*;
 import java.util.*;

/**
 *
 * @author Murciegalo
 */
public class ManejoDesteteController extends HttpServlet  {
    
   
    private List<GrillaInsumo> listGrilla = new ArrayList<GrillaInsumo>();
    private List<Insumo> listInsumo = new ArrayList<Insumo>();
    FeedlotManejoDestete man = new FeedlotManejoDestete();
    Respuesta resp = new Respuesta();
    List<Animal> list = null;
   
    
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, java.io.IOException {
 request.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(request, response); 
}
    */
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        String valorBtn = "";
        int dio = 0;    
            if(req.getParameter("botonForm")!= null || "".equals(req.getParameter("botonForm")))
            {
               valorBtn= req.getParameter("botonForm");               
            }
            else
            {
              valorBtn= req.getParameter("valorBoton");            
            }
        
            
            
            
      if("Agregar".equals(valorBtn)){
         System.out.print("Agregarx");
         dio = Integer.parseInt(req.getParameter("txtDio"));
       
         String mensaje = null;
        if(req.getParameter("txtDio")!= null){
        try {          
            if(man.CargarDIIOAManejar(dio).isStatus())
            {
                list= man.getListAnimal();
                req.setAttribute("listaAnimales", list);
              /*     for (int i = 0; i < list.size(); i++) {
                            System.out.print(list.get(i).getAnimalDiioActual()  );
                }*/             
            }
            else{
                mensaje = "DIIO no encontrado";
                req.setAttribute("mensaje", mensaje);   
                req.setAttribute("listaAnimales", list);   
            }

        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }}
      }
      
       if("Cargar".equals(valorBtn)){
           int insumo =Integer.parseInt(req.getParameter("selMotivo")) ;   
            System.out.print("Entro Cargar");
            try {
                  if(man.CargarInsumo(insumo).isStatus())
                listInsumo = man.getListInsumo();              
                System.out.print("Lleno Lista");
            } catch (Exception ex) {
                Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
            } 
       }
       
        if("LlenarCombo".equals(valorBtn)){
            System.out.print("Entro Llenar");      
            String valorSelect= req.getParameter("txtDio");
            try {
          
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

    System.out.print("Valor Boton" +valorBtn);
        if("Agregar Insumo".equals(valorBtn)){
           String tipoInsumo =req.getParameter("valorSelect") ;  
           System.out.print("Entro de nuevo");
           int  insumo = Integer.parseInt(req.getParameter("selMotivo")) ;            
                    try {
           if( man.GuardarInsumoGrilla(tipoInsumo,insumo).isStatus())
            listGrilla = man.getListGrillaInsumo();
            req.setAttribute("listaRegistroInsumos", listGrilla);
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }
      req.removeAttribute("botonForm");
      valorBtn = "";
        }
        
            if("EliminarDIIO".equals(valorBtn)){
                
                if(req.getParameter("selMotivo") != null)
                {
                  int dioeliminar  = Integer.parseInt(req.getParameter("selMotivo"))  ;
               /* man.DeleteDIIOGrilla(dioeliminar)*/
                }
            
            }
            
       
        
        
    req.setAttribute("listaInsumos", listInsumo);      
   
    
    req.removeAttribute("botonForm");
    valorBtn = "";
    req.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(req, res); 
}
    


}
