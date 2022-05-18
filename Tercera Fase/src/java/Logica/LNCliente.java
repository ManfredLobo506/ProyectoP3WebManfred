/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADClientes;
import Entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LNCliente {

    //Atributo
    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }

    public int InsertaroModificar(Cliente cliente) throws Exception {

        int total = 0;
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            total = adcliente.InsertaroModificar(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public int Eliminar(Cliente cliente) throws Exception {
        int total = 0;
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            total = adcliente.Eliminar(cliente);
            _mensaje = adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return total;
    }

    public List<Cliente> ListarRegistros(String condicion) throws Exception {
        List<Cliente> resultado = new ArrayList();
        ADClientes adcliente;
        try {
            adcliente = new ADClientes();
            resultado = adcliente.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
}
