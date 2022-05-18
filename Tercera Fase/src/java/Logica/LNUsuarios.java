/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADUsuarios;
import Entidades.Usuarios;

/**
 *
 * @author Admin
 */
public class LNUsuarios {
    //Atributo

    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int InsertaroModificar(Usuarios usuarios) throws Exception {
        int total = 0;
        ADUsuarios aDUsuarios;
        try {
            aDUsuarios = new ADUsuarios();
            total = aDUsuarios.InsertaroModificar(usuarios);
            _mensaje = aDUsuarios.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

}
