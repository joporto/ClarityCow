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
    
    private List<Animal> list = new ArrayList<Animal>();
    private List<GrillaInsumo> listGrilla = new ArrayList<GrillaInsumo>();
    private List<Insumo> listInsumo = new ArrayList<Insumo>();
    FeedlotManejoDestete man = new FeedlotManejoDestete();
    Respuesta resp = new Respuesta();
    String valorBtn = new String();
    
    /*
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, java.io.IOException {
 request.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(request, response); 
}
    */
    
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
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
        if(req.getParameter("txtDio")!= null){
        try {
            man.CargarDIIOAManejar(dio);
            if(man.CargarDIIOAManejar(dio).isStatus())
            {
                list = man.getListAnimal();
              /*     for (int i = 0; i < list.size(); i++) {
                            System.out.print(list.get(i).getAnimalDiioActual()  );
                            
                                              }*/
            }
            
        
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }}
      }
      
       if("Cargar".equals(valorBtn)){
           int insumo =Integer.parseInt(req.getParameter("selMotivo")) ;   
           System.out.print("Insumo ======>"+insumo);
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
            man.GuardarInsumoGrilla("PREMEZCLAS", 1);
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        listGrilla = man.getListGrillaInsumo();
       
    
        
        if("Agregar Insumo".equals(valorBtn)){
           String tipoInsumo =req.getParameter("valorSelect") ;   
           int  insumo = Integer.parseInt(req.getParameter("selMotivo")) ;
            
                    try {
            man.GuardarInsumoGrilla(tipoInsumo,insumo);
            listGrilla = man.getListGrillaInsumo();
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    req.setAttribute("listaInsumos", listInsumo);      
    req.setAttribute("listaRegistroInsumos", listGrilla);
    req.setAttribute("listaAnimales", list);
        
    req.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(req, res); 
}
    


}
