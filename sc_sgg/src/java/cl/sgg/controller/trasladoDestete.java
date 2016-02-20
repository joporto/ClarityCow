/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.controller;

import cl.sgg.business.FeedlotTraslado;
import cl.sgg.business.FormFeedlotTraslado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javierOporto
 */
@WebServlet(name = "trasladoDestete", urlPatterns = {"/trasladoDestete"})
public class trasladoDestete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
          if(request.getParameter("btnGuardar")!= null)
          {
              String accionBtn = request.getParameter("btnGuardar");
              
              if(accionBtn.equals("guardarDiio"))
              {
                  cl.sgg.business.FeedlotTraslado ft = new FeedlotTraslado();
                  
                  if(request.getParameter("optradio").equals("Confirmar"));
                  {
                      try 
                      {
                          ft = (cl.sgg.business.FeedlotTraslado)request.getSession().getAttribute("ft");
                          
                          ft.CargarDIIOAConfirmar(Integer.parseInt(request.getParameter("txtDiio")),Float.parseFloat(request.getParameter("txtPeso")));
                          
                          request.getSession().setAttribute("ft", ft);
                          request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response); 
                          
                      } 
                      catch (Exception e) 
                      {
                          out.print(e.getMessage());
                      }
                      
                  }
                  
                
                  
                  
                  
                 
                
                  
              }
              else if(accionBtn.equals("guardarExcel"))
              {
                  
              }
              else if(accionBtn.equals("guardarFormulario"))
              {
                  
              }else
              {
                  //enviar página de error
                  out.println("No se detecta acción");
              }
              
          }
          
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
