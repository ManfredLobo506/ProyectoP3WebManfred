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
public class Productos {
    
   
    //Atributos
  

    String IdProducto;
    String Descripcion;
    String Categoria;
    String Marca;
    int PrecioVenta;
    int cantidad;

   

    
    //Constructores
    
    public Productos(String IdProducto, String Descripcion, String Categoria,  int PrecioVenta, String Marca,int cantidad) {
        this.IdProducto = IdProducto;
        this.Descripcion = Descripcion;
        this.Categoria = Categoria;
        this.PrecioVenta = PrecioVenta;
        this.Marca=Marca;
        this.cantidad=cantidad;

    }
    
    public Productos() {

    }
    
    //Getter y setter
    
    
     public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }


    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    
    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    

}
