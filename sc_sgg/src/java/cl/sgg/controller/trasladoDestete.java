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

            cl.sgg.business.FeedlotTraslado ft;
            if (request.getSession().getAttribute("ft") != null) {
                ft = (cl.sgg.business.FeedlotTraslado) request.getSession().getAttribute("ft");
            } else {
                ft = new FeedlotTraslado();
            }

            if (request.getParameter("btnGuardar") != null) {
                String accionBtn = request.getParameter("btnGuardar");

                if (accionBtn.equals("guardarDiio")) {
                    String radioBtn = request.getParameter("optradio");

                    if (radioBtn.equals("Confirmar")) {

                        try {
                            int diio = Integer.parseInt(request.getParameter("txtDiio"));
                            float peso = Float.parseFloat(request.getParameter("txtPeso"));
                            ft.CargarDIIOAConfirmar(diio, peso);
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.getSession().setAttribute("mensaje", e.getMessage());
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                        }
                    } else if (radioBtn.equals("Trasladar")) {
                        try {
                            int diio = Integer.parseInt(request.getParameter("txtDiio"));
                            float peso = Float.parseFloat(request.getParameter("txtPeso"));
                            ft.CargarDIIOATrasladar(diio, peso);
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                        } catch (Exception e) {
                            request.getSession().setAttribute("mensaje", e.getMessage());
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                        }

                    }

                } else if (accionBtn.equals("guardarExcel")) {
                    out.print("Guardar Excel");

                } else if (accionBtn.equals("guardarFormulario")) {

                    try {
                        request.getSession().setAttribute("mensaje", ft.GuardarFeedlotTraslado().getMensaje());
                        request.getRequestDispatcher("/pages/feedlot/feedlot.jsp").forward(request, response);
                    } catch (Exception e) {
                        out.println("No se detecta acción");
                        request.getSession().setAttribute("mensaje", e.getMessage());
                        request.getRequestDispatcher("/pages/feedlot/feedlot.jsp").forward(request, response);

                    }

                } else {
                    //enviar página de error
                    request.getSession().setAttribute("mensaje", "error con feedlot");
                    request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                }

            } 

            if (request.getParameter("btnFiltro") != null) {

                String btnFiltro = request.getParameter("btnFiltro");

                if (btnFiltro.equals("rupOrigen")) {
                    try {
                        if (request.getParameter("busqCodRupOrigen") != null || request.getParameter("busqNomRupOrigen") != null) {
                            ft.BuscarRUPOrigen(Integer.parseInt(request.getParameter("busqCodRupOrigen")), request.getParameter("busqNomRupOrigen"));
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);

                        } else {
                            throw new Exception("Faltan datos rup Origen");

                        }
                    } catch (Exception e) {
                        request.getSession().setAttribute("mensaje", "error por falta de datos");
                        request.getSession().setAttribute("ft", ft);
                        request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                    }

                }
                if (btnFiltro.equals("transportista")) {
                    try {
                        if (request.getParameter("busqRutTrasportista") != null || request.getParameter("busqNombreTransportista") != null) {
                            ft.BuscarTransportista(request.getParameter("busqRutTrasportista"), request.getParameter("busqNombreTransportista"));
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);

                        } else {
                            throw new Exception("Faltan datos rup transportista");

                        }
                    } catch (Exception e) {
                        request.getSession().setAttribute("mensaje", "error por falta de datos");
                        request.getSession().setAttribute("ft", ft);
                        request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                    }

                }
                if (btnFiltro.equals("vehiculo")) {
                    try {
                        if (request.getParameter("txtBusquedaPatente") != null) {
                            ft.BuscarVehiculo(request.getParameter("txtBusquedaPatente"));
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);

                        } else {
                            throw new Exception("Faltan datos rup transportista");

                        }
                    } catch (Exception e) {
                        request.getSession().setAttribute("mensaje", "error por falta de datos");
                        request.getSession().setAttribute("ft", ft);
                        request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                    }

                }
                if (btnFiltro.equals("rupDestino")) {
                    try {
                        if (request.getParameter("txtBusquedaRupDestino") != null || request.getParameter("txtBusquedaNomRupDestino") != null) {
                            ft.BuscarRUPDestino(Integer.parseInt(request.getParameter("txtBusquedaRupDestino")), request.getParameter("txtBusquedaNomRupDestino"));
                            request.getSession().setAttribute("ft", ft);
                            request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);

                        } else {
                            throw new Exception("Faltan datos rup transportista");

                        }
                    } catch (Exception e) {
                        request.getSession().setAttribute("mensaje", "error por falta de datos");
                        request.getSession().setAttribute("ft", ft);
                        request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
                    }

                }

            } else {
                request.getSession().setAttribute("mensaje", "error por falta de datos");
                request.getRequestDispatcher("/pages/feedlot/trasladoDestete.jsp").forward(request, response);
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
