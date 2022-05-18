/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Admin
 */
public class Trabajadores extends Personas {
    
  

    public Trabajadores(String Id, String Nombre, String NumeroTelefonico, String CorreoElectronico, String Residencia, int Existe) {
        super(Id, Nombre, NumeroTelefonico, CorreoElectronico, Residencia, Existe);
    }
    public Trabajadores() {
        Id="";
       Nombre="";
       NumeroTelefonico="";
       CorreoElectronico="";
       Residencia="";
    }
}
