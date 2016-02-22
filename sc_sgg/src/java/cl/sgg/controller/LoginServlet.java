/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.sgg.controller;

import cl.sgg.dao.UsuariosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author javierOporto
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            
            
            if(request.getParameter("Usuario") != null && request.getParameter("password") != null)
            {
            
                String usr=request.getParameter("Usuario");
                String psw=request.getParameter("password"); 
            
                cl.sgg.dao.UsuariosDAO usrDao = new UsuariosDAO();
                
                //Implementar la tabla de roles
                cl.sgg.utils.UserRol usrRol = new cl.sgg.utils.UserRol(1, "admin");
                try 
                {
                    if(usrDao.getUser(usr, psw) != null)
                    {
                        cl.sgg.utils.UserSession usrSession = 
                                new cl.sgg.utils.UserSession(usrDao.getUser(usr, psw),usrRol);
                        request.getSession().setAttribute("userSession", usrSession);
                        response.sendRedirect("index.jsp");
                    }
                    else
                    {
                        throw new Exception("Usuario o Password incorrectos");
                    }
                } 
                catch (Exception e) 
                {
                    request.setAttribute("mensaje", "Usuario o Password incorrectos");
                    request.getRequestDispatcher("login.jsp").forward(request, response); 
                }
            }
            else
            {
                request.setAttribute("mensaje", "Usuario o Password incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response); 
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
