/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Entidades.DetalleFactura;
import Entidades.EntradaProductos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static AccesoDatos.ClaseConexion.getConnection;

/**
 *
 * @author Admin
 */
public class ADInventario {
    
         //Atributos

    private String _mensaje;
    
    
    public String getMensaje() {
        return _mensaje;
    }
    //Constructor

      public int InsertaroModificar(EntradaProductos entradaProductos) throws Exception {
        Connection _conexion = null;
        _conexion = getConnection();
        int total = 0;
        ResultSet rs = null;

        String sentencia = "{call InsertarInvetario(?,?,?)}";//LLAMAMOS EL PROCEDIMIENTO ALMACENADO

        try {

            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, entradaProductos.getIdProducto());//ASIGNAMOS VALORES A LOS PARAMETROS
            ps.setInt(2, entradaProductos.getCantidad());
            ps.setString(3, entradaProductos.getProveedor());

            ps.execute();
            _mensaje="Se ha agregado el registro correctamente";

        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return total;
    }//Fin Insertar
}
