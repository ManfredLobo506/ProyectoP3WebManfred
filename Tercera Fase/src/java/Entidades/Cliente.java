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
public class Cliente extends Personas{

    public Cliente(String Id, String Nombre, String NumeroTelefonico, String CorreoElectronico, String Residencia, int Existe) {
        super(Id, Nombre, NumeroTelefonico, CorreoElectronico, Residencia, Existe);
    }
     public Cliente() {
       Id="";
       Nombre="";
       NumeroTelefonico="";
       CorreoElectronico="";
       Residencia="";
    }
    
    
}
