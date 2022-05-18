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
public class EntradaProductos {
//Atributos
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    int IdEntrada;
    String IdProducto;
    String Proveedor;
    Date FechaIn;
    int Cantidad;
    
//Constructores

    public EntradaProductos(int IdEntrada, String IdProducto, String Proveedor, Date FechaIn, int Cantidad) {
        this.IdEntrada = IdEntrada;
        this.IdProducto = IdProducto;
        this.Proveedor = Proveedor;
        this.FechaIn = FechaIn;
        this.Cantidad = Cantidad;
    }
    public EntradaProductos() {
    }        
    
//Getter and Setter

    public int getIdEntrada() {
        return IdEntrada;
    }

    public void setIdEntrada(int IdEntrada) {
        this.IdEntrada = IdEntrada;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public Date getFechaIn() {
        return FechaIn;
    }

    public void setFechaIn(Date FechaIn) {
        this.FechaIn = FechaIn;
    }

    public int getCantidad() {
        return Cantidad;
    }    
}
