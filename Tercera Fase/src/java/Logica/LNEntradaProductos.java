/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADInventario;
import Entidades.EntradaProductos;

/**
 *
 * @author Admin
 */
public class LNEntradaProductos {

    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int InsertaroModificar(EntradaProductos entradaProductos) throws Exception {
        int id = 0;
        ADInventario aDInventario;
        try {
            aDInventario = new ADInventario();
            id = aDInventario.InsertaroModificar(entradaProductos);
            _mensaje = aDInventario.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }

}
