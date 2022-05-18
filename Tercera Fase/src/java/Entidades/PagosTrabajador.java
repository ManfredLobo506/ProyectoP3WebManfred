/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class PagosTrabajador {

//Atributos
    public void setPago(double Pago) {
        this.Pago = Pago;
    }
    int IdPago;
    String IdTrabajador;
    Date desde;
    Date Hasta;
    int Total;
    int Porcentaje;
    double Pago;
//Constructores
    public PagosTrabajador(int IdPago, String IdTrabajador, Date desde, Date Hasta, int Total, int Porcentaje, double Pago) {
        this.IdPago = IdPago;
        this.IdTrabajador = IdTrabajador;
        this.desde = desde;
        this.Hasta = Hasta;
        this.Total = Total;
        this.Porcentaje = Porcentaje;
        this.Pago = Pago;
    }
    public PagosTrabajador() {
    }
//Getter and Setter  
    
     public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public String getIdTrabajador() {
        return IdTrabajador;
    }

    public void setIdTrabajador(String IdTrabajador) {
        this.IdTrabajador = IdTrabajador;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Date getHasta() {
        return Hasta;
    }

    public void setHasta(Date Hasta) {
        this.Hasta = Hasta;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public double getPago() {
        return Pago;
    }

}
