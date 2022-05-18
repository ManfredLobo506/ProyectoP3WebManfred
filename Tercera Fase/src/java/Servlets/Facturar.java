/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entidades.DetalleFactura;
import Entidades.Factura;
import Logica.LNFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Facturar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try{
            LNFactura LogicaFactura = new LNFactura();
            Factura EntidadFactura= new Factura();
            DetalleFactura EntidadDetalle = new DetalleFactura();
            int resultado;
            String mensaje= "";
            
            if(request.getParameter("txtNombreCliente")!= null && 
                    !request.getParameter("txtNombreCliente").equals("")){
                EntidadFactura.setIdCliente(request.getParameter("txtIdCliente"));
                EntidadFactura.setIdtrabajador(request.getParameter("txtIdTrabajador"));
                EntidadFactura.setIdFactura(Integer.parseInt(request.getParameter("txtnumFactura")));
                EntidadFactura.setDescuento(Integer.parseInt(request.getParameter("txtDescuento")));
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaString  = request.getParameter("txtFechaFactura");
                Date fecha = formato.parse(fechaString);
                java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
                EntidadFactura.setFecha(fechasql);
                EntidadFactura.setIdCliente(request.getParameter("txtIdCliente"));
                EntidadFactura.setEstado("Pendiente");
                if(!(request.getParameter("txtdescripcion").equals("")) &&
                        !(request.getParameter("txtcantidad").equals("")) &&
                        !(request.getParameter("txtprecio").equals(""))){
                    EntidadDetalle.setIdFactura(-1);
                    EntidadDetalle.setIdProducto((request.getParameter("txtIdProducto")));
                    EntidadDetalle.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));
                    EntidadDetalle.setPrecio(Double.parseDouble(request.getParameter("txtprecio")));
                    resultado = LogicaFactura.Insertar(EntidadFactura, EntidadDetalle);
                    mensaje = LogicaFactura.getMensaje();
                }else{
                    resultado = LogicaFactura.ModificarFactura(EntidadFactura);
                }
                response.sendRedirect("Frm_facturar.jsp?msgFac="+mensaje+"&txtnumFactura="+resultado+"&txtIdCliente="+EntidadFactura.getIdCliente()+"&txtDescuento="+EntidadFactura.getDescuento());
            }else{
                response.sendRedirect("Frm_facturar.jsp?txtnumFactura="+
                        request.getParameter("txtnumFactura"));
            }
        }catch(Exception ex){
            out.print(ex.getMessage());
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
