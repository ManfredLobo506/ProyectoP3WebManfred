/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class Factura {

  

 // ATRIBUTOS
    private int idFactura;
    private String idCliente;
    private String idtrabajador;
    private java.sql.Date fecha;
    private String estado;
    private boolean existeRegistro;
    private String nombreCliente; 
    private String nombreTrab; 

    private int descuento;

   
    
    // PROPIEDADES
    public String getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(String idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombreTrab() {
        return nombreTrab;
    }

    public void setNombreTrab(String nombreTrab) {
        this.nombreTrab = nombreTrab;
    }

    
     public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.idFactura = IdFactura;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.idCliente = IdCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.nombreCliente = NombreCliente;
    }

    public java.sql.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.sql.Date Fecha) {
        this.fecha = Fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String Estado) {
        this.estado = Estado;
    }

    public boolean isExisteRegistro() {
        return existeRegistro;
    }

    public void setExisteRegistro(boolean ExisteRegistro) {
        this.existeRegistro = ExisteRegistro;
    }
    
    // CONSTRUCTORES

    public Factura() {
        idtrabajador="";
        nombreTrab="";
        idFactura = 0;
        idCliente = "";
        nombreCliente = "";
        fecha = null; 
        estado = "";
        existeRegistro = false;
    }

    public Factura(int IdFactura, String IdCliente, String NombreCliente, java.sql.Date Fecha, String Estado) {
        this.idFactura = IdFactura;
        this.idCliente = IdCliente;
        this.nombreCliente = NombreCliente;
        this.fecha = Fecha;
        this.estado = Estado;
        existeRegistro = true; 
    }
}
