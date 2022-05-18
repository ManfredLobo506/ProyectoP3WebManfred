/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADFactura;
import AccesoDatos.ADProductos;
import Entidades.DetalleFactura;
import Entidades.Factura;
import Entidades.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LNFactura {
    //Atributo

    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int Insertar(Factura Entidad, DetalleFactura EntidadDetalle) throws Exception {

        int resultado = 0;

        try {
            ADFactura DA = new ADFactura();
            resultado = DA.Insertar(Entidad, EntidadDetalle);
            _mensaje = DA.getMensaje();
        } catch (Exception ex) {
            resultado = -1;
            throw ex;
        }
        return resultado;
    }

    public String ObtenerVentas(int mes) throws Exception {

        String total = "";

        try {
            ADFactura aDFactura = new ADFactura();
            total = aDFactura.ObtenerVentas(mes);

        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public String ObtenerVentasTrab(int mes, String id) throws Exception {

        String total = "";

        try {
            ADFactura aDFactura = new ADFactura();
            total = aDFactura.ObtenerVentasTrab(mes, id);

        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public int Eliminar(Productos productos) throws Exception {

        int total = 0;
        ADProductos aDProductos;
        try {
            aDProductos = new ADProductos();
            total = aDProductos.Eliminar(productos);
            _mensaje = aDProductos.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    /* public List<Productos> ListarRegistros(String condicion) throws Exception {
        List<Productos> resultado = new ArrayList();
        ADProductos aDProductos;
        try {
            aDProductos = new ADProductos();
            resultado = aDProductos.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }*/
    public Productos ObtenerRegistro(String condicion) throws Exception {
        Productos resultado;
        ADProductos aDProductos;

        aDProductos = new ADProductos();
        resultado = aDProductos.ObtenerRegistro(condicion);

        return resultado;
    }

    public Factura ObtenerRegistroFact(String condicion) throws Exception {
        Factura resultado;
        ADFactura aDFactura;

        aDFactura = new ADFactura();
        resultado = aDFactura.ObtenerRegistroFact(condicion);

        return resultado;
    }

      public int ModificarFactura(Factura Entidad) throws Exception{
        int idfactura = 0;
        
        try{
            ADFactura DA = new ADFactura();
            
            idfactura = DA.ModificarFactura(Entidad);
        }catch(Exception ex){
            throw ex;
        }
        
        return idfactura;
    }
      
          public int ModificarEstado(Factura Entidad) throws Exception {
    
        int resultado = 0;
        
        try{
            ADFactura DA = new ADFactura();
            
            resultado = DA.ModificarEstado(Entidad);
            _mensaje = DA.getMensaje();
        }catch(Exception ex){
            throw ex;
        }
        
        return resultado;
    }
    

    public List<Factura> ListarRegistros(String condicion) throws Exception {
        List<Factura> Datos;

        try {
            ADFactura Da = new ADFactura();
            Datos = Da.ListarRegistros(condicion);
        } catch (Exception ex) {
            Datos = null;
            throw ex;
        }

        return Datos;
    }
    
        public int ModificarTotalFactura(Factura Entidad,double total) throws Exception{
        int resultado = 0;
        try {
             ADFactura DA = new ADFactura();
            resultado = DA.ModificarTotalFactura(Entidad, total);
        } 
        catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    

}
