/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.Factura;
import Entidades.Productos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static AccesoDatos.ClaseConexion.getConnection;
import Entidades.DetalleFactura;
import java.sql.CallableStatement;
import java.sql.Types;

/**
 *
 * @author Admin
 */
public class ADFactura {
    //Atributos

    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    //Constructor
    /* public int InsertaroModificar(Factura factura) throws Exception {
        Connection _conexion = null;
        _conexion = getConnection();
        int idFact = 0;
        ResultSet rs = null;

        String sentencia = ("insert into Factura(IdTrabajador,IdCliente,ESTADO) values(?,?,?)");
        String sentencia2 = "select idProducto from productos where idproducto=?";

        PreparedStatement corroborar = _conexion.prepareStatement(sentencia2);
        corroborar.setString(1, "" + factura.getIdFactura());
        rs = corroborar.executeQuery();

        try {

            PreparedStatement ps = _conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, factura.getIdTrabajador());
            ps.setString(2, factura.getIdCliente());
            ps.setString(3, factura.getEstado());
            ps.execute();

            ResultSet rs2 = ps.getGeneratedKeys(); //El result set es como una tabla con un registro
            if (rs2 != null && rs2.next()) { //SI SE GENERÓ EL RESULTSET Y HAY OTRO REGISTRO
                idFact = rs2.getInt(1);

            }

            if (rs.next()) {

                _mensaje = "Factura modificado con exito";
            } else {
                _mensaje = "Factura Ingresada con Exito";
            }

        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }

        return idFact;
    }*///Fin Insertar
    public int Insertar(Factura EntidadFactura, DetalleFactura EntidadDetalle) throws Exception {
        CallableStatement CS;
        int resultado;
        int idFactura;
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection();
            String sentencia = "{call Guardar_Factura(?,?,?,?,?,?)}";//LLAMAMOS EL PROCEDIMIENTO ALMACENADO
            _Conexion.setAutoCommit(false);

            CS = _Conexion.prepareCall(sentencia);
            CS.setInt(1, EntidadFactura.getIdFactura());//ASIGNAMOS LOS PARAMETROS
            CS.setString(2, EntidadFactura.getIdCliente());
            CS.setDate(3, EntidadFactura.getFecha());
            CS.setString(4, EntidadFactura.getEstado());
            CS.setString(5, EntidadFactura.getIdtrabajador());
            CS.setString(6, _mensaje);
            CS.registerOutParameter(1, Types.INTEGER);

            resultado = CS.executeUpdate();
            idFactura = CS.getInt(1);

            CS = _Conexion.prepareCall("{call Guardar_Detalle(?,?,?,?,?)}");//LLAMAMOS EL PROCEDIMIENTO ALMACENADO
            CS.setInt(1, idFactura);
            CS.setString(2, EntidadDetalle.getIdProducto());//ASIGNAMOS LOS PARAMETROS
            CS.setInt(3, EntidadDetalle.getCantidad());
            CS.setDouble(4, (double) EntidadDetalle.getPrecio());
            CS.setString(5, _mensaje);

            CS.registerOutParameter(5, Types.VARCHAR);
            resultado = CS.executeUpdate();

            _mensaje = CS.getString(5);
            _Conexion.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            _Conexion.rollback();
            throw ex;
        } finally {
            if (_Conexion != null) {
                ClaseConexion.close(_Conexion);
            }
        }
        return idFactura;
    }

    public int Eliminar(Productos productos) throws Exception {
        Connection _conexion = null;
        _conexion = getConnection();
        int total = 0;
        ResultSet rs = null;

        String sentencia = "{call EliminarProductos(?)}";//LLAMAMOS EL PROCEDIMIENTO ALMACENADO DE ELIMINAR 
        String sentencia2 = "select IdProducto from Productos where IdProducto=?";

        PreparedStatement corroborar = _conexion.prepareStatement(sentencia2);
        corroborar.setString(1, productos.getIdProducto());
        rs = corroborar.executeQuery();

        try {

            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, productos.getIdProducto());

            ps.execute();

            if (rs.next()) {

                _mensaje = "Producto eliminado con exito";
            } else {
                _mensaje = "El producto no existe";
            }

        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return total;
    }//Fin Insertar

   /* public List<Productos> ListarRegistros(String condicion) throws SQLException, Exception {
        Connection _conexion = null;
        ResultSet rs = null;
        List<Productos> lista = new ArrayList();
        try {
            _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select IdProducto,Nombre,Categoria,Precio,Marca,Cantidada from Productos";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while (rs.next()) {
                lista.add(new Productos(rs.getString("IdProducto"), rs.getString("Nombre"), rs.getString("Categoria"), rs.getInt("Precio"), rs.getString("Marca"), rs.getInt("Cantidada")));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return lista;
    }*/

    public Productos ObtenerRegistro(String condicion) throws SQLException, Exception {
        Connection _conexion = null;
        Productos productos = new Productos();
        ResultSet rs = null;
        try {
            _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Idproducto,nombre,precio from productos";

            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                productos.setIdProducto(rs.getString(1));
                productos.setDescripcion(rs.getString(2));
                productos.setPrecioVenta(rs.getInt(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return productos;
    }

    public String ObtenerVentas(int mes) throws SQLException, Exception {
        Connection _conexion = null;

        ResultSet rs = null;
        String total = "";
        try {
            _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select TotalVentas=SUM(total) from factura where MONTH(fecha)=" + mes;

            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                total = rs.getString("TotalVentas");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return total;
    }

    public String ObtenerVentasTrab(int mes, String id) throws SQLException, Exception {
        Connection _conexion = null;

        ResultSet rs = null;
        String total = "";
        try {
            _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select TotalVentas=SUM(total) from factura where MONTH(fecha)=" + mes + " and id_trabajador='" + id + "'";

            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                total = rs.getString("TotalVentas");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            _conexion = null;
        }
        return total;
    }

    public Factura ObtenerRegistroFact(String condicion) throws Exception {
        ResultSet RsDatos = null;
        Factura Entidad = new Factura();
        String sentencia;
        Connection _conexion = null;
        sentencia = "SELECT NUM_FACTURA, F.ID_CLIENTE, NOMBRE, FECHA, ESTADO FROM FACTURA F "
                + "INNER JOIN CLIENTES ON CLIENTES.IDCLIENTE=F.ID_CLIENTE";
        if (!condicion.equals("")) {
            sentencia = String.format("%s where %s", sentencia, condicion);
        }

        try {
            _conexion = ClaseConexion.getConnection();
            Statement ST = _conexion.createStatement();
            RsDatos = ST.executeQuery(sentencia);
            if (RsDatos.next()) {
                Entidad.setIdFactura(RsDatos.getInt("NUM_FACTURA"));
                Entidad.setIdCliente(RsDatos.getString("ID_CLIENTE"));
                Entidad.setNombreCliente(RsDatos.getString("NOMBRE"));
                Entidad.setFecha(RsDatos.getDate("FECHA"));
                Entidad.setEstado(RsDatos.getString("estado"));
                Entidad.setExisteRegistro(true);
            } else {
                Entidad.setExisteRegistro(false);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return Entidad;
    }

   public int ModificarFactura(Factura EntidadFactura) throws Exception {
        int idfactura = 0;
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection();
            PreparedStatement PS = _Conexion.prepareStatement("update Factura set ID_CLIENTE = ? where NUM_FACTURA = ?");

            PS.setString(1, EntidadFactura.getIdCliente());
            PS.setInt(2, EntidadFactura.getIdFactura());

            PS.executeUpdate();
            idfactura = EntidadFactura.getIdFactura();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (_Conexion != null) {
                ClaseConexion.close(_Conexion);
            }
        }
        return idfactura;
    }
   
     public int ModificarTotalFactura(Factura EntidadFactura,double total) throws Exception {
        int idfactura = 0;
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection();
            PreparedStatement PS = _Conexion.prepareStatement("update Factura set total=? where NUM_FACTURA = ?");

            PS.setDouble(1,total);
            PS.setInt(2, EntidadFactura.getIdFactura());

            PS.executeUpdate();
            idfactura = EntidadFactura.getIdFactura();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (_Conexion != null) {
                ClaseConexion.close(_Conexion);
            }
        }
        return idfactura;
    }
    
    public List<Factura> ListarRegistros(String Condicion) throws Exception {
        ResultSet Rs = null;
        Factura entidad;
        List<Factura> ListaF = new ArrayList<>();
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            Statement ST = _conexion.createStatement();
            String Sentencia;

            Sentencia = "SELECT NUM_FACTURA, F.ID_CLIENTE, NOMBRE, FECHA, ESTADO FROM Factura F "
                    + "INNER JOIN CLIENTES ON CLIENTES.IDCLIENTE = F.ID_CLIENTE";

            if (!Condicion.equals("")) {
                Sentencia = String.format("%s Where %s", Sentencia, Condicion);
            }

            Rs = ST.executeQuery(Sentencia);
            while (Rs.next()) {
                entidad = new Factura(Rs.getInt("NUM_FACTURA"),
                        Rs.getString("Id_cliente"),
                        Rs.getString("Nombre"),
                        Rs.getDate("Fecha"),
                        Rs.getString("Estado"));
                ListaF.add(entidad);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (_conexion != null) {
                ClaseConexion.close(_conexion);
            }
        }
        return ListaF;
    }
    
        public int ModificarEstado(Factura EntidadFactura) throws Exception {
        int resultado = 0;
        Connection _Conexion = null;
        try {
            _Conexion = ClaseConexion.getConnection();
            PreparedStatement PS = _Conexion.prepareStatement("Update Factura set Estado = ? where NUM_FACTURA = ?");

            PS.setString(1, EntidadFactura.getEstado());
            PS.setInt(2, EntidadFactura.getIdFactura());

            resultado = PS.executeUpdate();
        } catch (Exception ex) {
            resultado = -1;
            throw ex;
        } finally {
            if (_Conexion != null) {
                ClaseConexion.close(_Conexion);
            }
        }
        if(resultado > 0){
            _mensaje = "Factura Cancelada";
        }else{
            _mensaje = "No se ha podido Cancelar la factura";
        }
        return resultado;
    }
 
}


    
