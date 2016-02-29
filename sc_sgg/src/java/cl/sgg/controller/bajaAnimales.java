//v1.0.1
package cl.sgg.controller;

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cl.sgg.business.*;
import cl.sgg.utils.Respuesta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

public class bajaAnimales extends HttpServlet  
{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    int DIIO = 0; 
    BajaAnimales anim = new BajaAnimales();
    Respuesta resp = new Respuesta();  
    List<String> list = new ArrayList<String>();
    String motivo = "Muerto";
    String valorBtn = "";
    String valorDiio = "";
    boolean valorCheck = true;
    //</editor-fold>  
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        try
        {
           if(req.getParameter("botonForm")!= null || "".equals(req.getParameter("botonForm")))
            {
                valorBtn= req.getParameter("botonForm");               
            }
            else
            {
                valorBtn= req.getParameter("valorBoton");            
            }
            if("Buscar".equals(valorBtn.toString()))
            {
                if(!"".equals(req.getParameter("txtBuscar")) && req.getParameter("txtBuscar") != null )
                {
                    valorDiio = req.getParameter("txtBuscar");              
                }
                else
                {
                    valorDiio = req.getParameter("escondido");             
                }
                DIIO = Integer.parseInt(valorDiio);
                resp =  anim.BuscarDIIO(DIIO);
                if(resp.isStatus()) //DIIO encontrado
                {
                    String diioActual =  anim.getAnimal().getAnimalDiioActual().toString();
                    motivo = req.getParameter("Motivo");
                    anim.setMotivoAparente(motivo);
                    Respuesta r = anim.CargarCbMotivoAparente(motivo);
                    if(r.isStatus())
                    {        
                        list =  anim.getListaCb();
                    } 
                    if("Muerto".equals(motivo))
                    {
                        valorCheck = true;
                    }
                    else
                    {
                        valorCheck = false;
                    }  
                    req.setAttribute("MensajeRespuesta", resp.getMensaje());
                    req.setAttribute("StatusRespuesta", resp.isStatus());
                    req.setAttribute("diioActual",diioActual);
                    req.setAttribute("lista", list);
                    req.setAttribute("valorCheck", valorCheck);
                    req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res); 
                }
                else // DIIO No encontrado
                {
                    req.setAttribute("MensajeRespuesta", resp.getMensaje());
                    req.setAttribute("StatusRespuesta", resp.isStatus());
                    req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res);   
                }
            }
            if("Guardar".equals(valorBtn))
            {
                anim.setMotivoAparente(motivo);
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fechaBaja = req.getParameter("fechaBaja");   
                String motivoAparente = req.getParameter("selMotivo");     
                Date fecha = formatter.parse(fechaBaja);     
                anim.GuardarBajaAnimales(fecha, motivo, motivoAparente);
                resp = anim.GuardarBajaAnimales(fecha, motivo, motivoAparente);
           
                if(resp.isStatus())
                {              
                    req.setAttribute("MensajeRespuesta", resp.getMensaje());
                    req.setAttribute("resultadoGuardar", resp.isStatus());
                }
                else
                {
                    //System.out.print("Resultado NO: "+resultado); 
                    //req.setAttribute("resultadoGuardar", resultado);
                }
                req.getRequestDispatcher("/pages/manejos/bajaAnimales.jsp").forward(req, res); 
            }
        } 
        catch (Exception e)
        {
            Logger.getLogger(bajaAnimales.class.getName()).log(Level.SEVERE, null, e);  
        }
    }
}