/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.DetalleFactura;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static AccesoDatos.ClaseConexion.getConnection;
import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ADDetalleFact {
     //Atributos
    private Connection _cnn;
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }
    //Constructor
    public List<DetalleFactura> ListarRegistros(String Condicion) throws Exception{
        ResultSet Rs = null;
        DetalleFactura entidad;
        List<DetalleFactura> Lista = new ArrayList<>();
        Connection _conexion = null;
        try{
            _conexion = ClaseConexion.getConnection();
            Statement ST = _conexion.createStatement();
            String Sentencia;
            
            Sentencia = "SELECT NUM_FACTURA, DETALLE_FACTURA.ID_PRODUCTO , Nombre, CANTIDAD, PRECIO_VENTA"
                    + " FROM DETALLE_FACTURA "
                    + "INNER JOIN PRODUCTOS ON DETALLE_FACTURA.ID_PRODUCTO = PRODUCTOS.IDPRODUCTO";
            if(!Condicion.equals("")){
                Sentencia = String.format("%s Where %s", Sentencia, Condicion);
            }
            Rs = ST.executeQuery(Sentencia);
            while(Rs.next()){
                entidad = new DetalleFactura(Rs.getInt("NUM_FACTURA"),
                        Rs.getString("id_producto"),
                        Rs.getString("Nombre"),
                        Rs.getInt("cantidad"),
                        Rs.getInt("precio_venta"));
                Lista.add(entidad);//METEMOS ELEMENTOS A LA LISTA
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return Lista;
    }    
       public int Eliminar(DetalleFactura Entidad) throws Exception{
        CallableStatement CS = null;
        int resultado = 0;
        Connection _Conexion = null;
        try{
            _Conexion = ClaseConexion.getConnection();
            CS = _Conexion.prepareCall("{call eliminar_Detalle(?,?,?)}");//LLAMAMOS EL PROCESO ALMACENADO ELIMINAR
            
            CS.setInt(1, Entidad.getIdFactura());//ASIGNAMOS LOS PARAMETROS
            CS.setString(2, Entidad.getIdProducto());
            CS.setString(3, _mensaje);
            
            CS.registerOutParameter(3, Types.VARCHAR);
            resultado = CS.executeUpdate();
            
            _mensaje=CS.getString(3);
            
        }catch(Exception ex){
            resultado = -1;
            throw ex;
        }finally{
            if(_Conexion != null){
                ClaseConexion.close(_Conexion);
            }
        }
        return resultado;
    }
}
