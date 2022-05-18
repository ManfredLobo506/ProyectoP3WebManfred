/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Admin
 */
public class DetalleFactura {
  
    // ATRIBUTOS
    
    private int idFactura;
    private String idProducto;
    private int cantidad;
    private double precio;
    private boolean existeRegistro;
    private String nombreProducto; 

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.idFactura = IdFactura;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.idProducto = IdProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.nombreProducto = NombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int Catnidad) {
        this.cantidad = Catnidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double Precio) {
        this.precio = Precio;
    }

    public boolean isExisteRegistro() {
        return existeRegistro;
    }

    public void setExisteRegistro(boolean ExisteRegistro) {
        this.existeRegistro = ExisteRegistro;
    }
    
    
    
    // CONSTRUCTORES

    public DetalleFactura() {
        idFactura = 0;
        idProducto = "";
        nombreProducto = "";
        cantidad = 0;
        precio = 0;
        existeRegistro = false;
    }

    public DetalleFactura(int IdFactura, String IdProducto, String NombreProducto, int Cantidad, int Precio) {
        this.idFactura = IdFactura;
        this.idProducto = IdProducto;
        this.nombreProducto = NombreProducto;
        this.cantidad = Cantidad;
        this.precio = Precio;
        existeRegistro = true; 
    }
}
