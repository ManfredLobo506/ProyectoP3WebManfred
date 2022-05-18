/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.DetalleFactura;
import Logica.LNDetallefact;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminarDetalle extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String codigo = request.getParameter("idproducto");
        int factura = Integer.parseInt(request.getParameter("idfactura"));
        int resultado;
        try {
            LNDetallefact LogicaDetalle = new LNDetallefact();
            DetalleFactura Entidad = new DetalleFactura();
            Entidad.setIdProducto(codigo);
            Entidad.setIdFactura(factura);
            resultado = LogicaDetalle.Eliminar(Entidad);
            String mensaje = LogicaDetalle.getMensaje();
            List<DetalleFactura> entidadDetalle = null;
            entidadDetalle = LogicaDetalle.ListarRegistros("Num_factura =" + factura);
            if (entidadDetalle.isEmpty()) {
                response.sendRedirect("Frm_facturar.jsp?txtnumFactura=" + -1+"&msgFac="+mensaje);

            } else {
                response.sendRedirect("Frm_facturar.jsp?txtnumFactura=" + factura+"&msgFac="+mensaje);
            }

        } catch (Exception e) {
            out.print(e.getMessage());
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
