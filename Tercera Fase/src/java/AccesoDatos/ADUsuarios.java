/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import static AccesoDatos.ClaseConexion.getConnection;
import Entidades.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class ADUsuarios {
    //Atributos

    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    
    public int InsertaroModificar(Usuarios usuarios) throws Exception {
        Connection _conexion = null;
        _conexion = getConnection();
        int total = 0;
        ResultSet rs = null;

        String sentencia = "{call InsertarUsuario(?,?,?,?)}";

        try {

            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, usuarios.getId());
            ps.setString(2, usuarios.getUserName());
            ps.setString(3, usuarios.getPassword());
            ps.setInt(4, usuarios.getPermisos());

            ps.execute();

            _mensaje = "Usuario Ingresado con exito";

        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return total;
    }//Fin Insertar

}
