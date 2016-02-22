/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.controller;


import cl.sgg.business.FeedlotManejoDestete;
import cl.sgg.edm.Animal;
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
    
    private List<Animal> list;
    FeedlotManejoDestete man = new FeedlotManejoDestete();
    Respuesta resp = new Respuesta();
    String valorBtn = new String();
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, java.io.IOException {
 request.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(request, response); 
}
    
    
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
        
        
        
    
        
         
      /*  String archivo = req.getParameter("upfile");*/
      
      if("Agregar".equals(valorBtn)){
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
            
           dio = 0; 
        } catch (Exception ex) {
            Logger.getLogger(ManejoDesteteController.class.getName()).log(Level.SEVERE, null, ex);
        }}
      }
       
    req.setAttribute("listaAnimales", list);
        
    req.getRequestDispatcher("/pages/feedlot/manejoDestete.jsp").forward(req, res); 
}
    

 



  	
    


}
