/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADDetalleFact;
import AccesoDatos.ADFactura;
import Entidades.DetalleFactura;
import Entidades.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LNDetallefact {
    //Atributo

    private String _mensaje;

    public String getMensaje() {
        return _mensaje;
    }
/*
    public int InsertaroModificar(DetalleFactura detalleFactura) throws Exception {

        int id = 0;
        ADDetalleFact aDDetalleFact;
        try {
            aDDetalleFact = new ADDetalleFact();
            id = aDDetalleFact.InsertaroModificar(detalleFactura);
            _mensaje = aDDetalleFact.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return id;
    }*/
    
     public List<DetalleFactura> ListarRegistros(String condicion) throws Exception {
        List<DetalleFactura> resultado = new ArrayList();
        ADDetalleFact aDDetalleFact;
        try {
            aDDetalleFact = new ADDetalleFact();
            resultado = aDDetalleFact.ListarRegistros(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }
         public int Eliminar(DetalleFactura Entidad) throws Exception{
        int resultado = 0;
        try{
            ADDetalleFact DA= new ADDetalleFact();
            
            resultado = DA.Eliminar(Entidad);
            _mensaje = DA.getMensaje();
        }catch(Exception ex){
            resultado = -1;
            throw ex;
        }
        
        return resultado;
    }

}
