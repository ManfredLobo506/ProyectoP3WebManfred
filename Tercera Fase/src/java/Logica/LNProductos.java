/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADProductos;
import Entidades.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LNProductos {

    //Atributo
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int InsertaroModificar(Productos productos) throws Exception {
        int total = 0;
        ADProductos aDProductos;
        try {
            aDProductos = new ADProductos();
            total = aDProductos.InsertaroModificar(productos);
            _mensaje = aDProductos.getMensaje();
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

    public List<Productos> ListarRegistros(String condicion) throws Exception {
        List<Productos> resultado = new ArrayList();
        ADProductos aDProductos;
        try {
            aDProductos = new ADProductos();
            resultado = aDProductos.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    public Productos ObtenerRegistro(String condicion) throws Exception {
        Productos resultado;
        ADProductos aDProductos;

        aDProductos = new ADProductos();
        resultado = aDProductos.ObtenerRegistro(condicion);

        return resultado;
    }

}
