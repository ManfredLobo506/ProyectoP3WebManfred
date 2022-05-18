/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADTrabajadores;
import Entidades.Trabajadores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LNTrabajadores {

    //Atributo
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int InsertaroModificar(Trabajadores trabajadores) throws Exception {
        int total = 0;
        ADTrabajadores aDTrabajadores;
        try {
            aDTrabajadores = new ADTrabajadores();
            total = aDTrabajadores.InsertaroModificar(trabajadores);
            _mensaje = aDTrabajadores.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public int Eliminar(Trabajadores trabajadores) throws Exception {
        int total = 0;
        ADTrabajadores aDTrabajadores;
        try {
            aDTrabajadores = new ADTrabajadores();
            total = aDTrabajadores.Eliminar(trabajadores);
            _mensaje = aDTrabajadores.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public List<Trabajadores> ListarRegistros(String condicion) throws Exception {
        List<Trabajadores> resultado = new ArrayList();
        ADTrabajadores aDTrabajadores;
        try {
            aDTrabajadores = new ADTrabajadores();
            resultado = aDTrabajadores.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
}
