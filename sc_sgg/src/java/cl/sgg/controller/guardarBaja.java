/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.controller;

import cl.sgg.business.BajaAnimales;
import cl.sgg.utils.Respuesta;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Murciegalo
 */

    public class guardarBaja extends HttpServlet  
{
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
            
     BajaAnimales anim = new BajaAnimales();
    Respuesta resp = new Respuesta();     
    DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
    String fecha = req.getParameter("fechaBaja");
     Date fechaBaja = new Date();
        try {
            fechaBaja = df.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(guardarBaja.class.getName()).log(Level.SEVERE, null, ex);
        }
      String motivo= req.getParameter("fechaBaja");
       String motivoAparente= req.getParameter("fechaBaja");
     
     
        try {
            anim.GuardarBajaAnimales(fechaBaja, motivo, motivoAparente);
        } catch (Exception ex) {
            Logger.getLogger(guardarBaja.class.getName()).log(Level.SEVERE, null, ex);
        }
     
   
}
    
    
    }
