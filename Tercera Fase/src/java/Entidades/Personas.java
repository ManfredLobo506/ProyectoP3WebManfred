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
public class Personas {
    
//Atributos
    
    String Id;
    String Nombre;
    String NumeroTelefonico;
    String CorreoElectronico;
    String Residencia;
    int Existe;

  
//Constructor
    public Personas(String Id, String Nombre, String NumeroTelefonico, String CorreoElectronico, String Residencia, int Existe) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.NumeroTelefonico = NumeroTelefonico;
        this.CorreoElectronico = CorreoElectronico;
        this.Residencia = Residencia;
        this.Existe = Existe;
    }
    public Personas() {
    }
//Getter and Setter

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNumeroTelefonico() {
        return NumeroTelefonico;
    }

    public void setNumeroTelefonico(String NumeroTelefonico) {
        this.NumeroTelefonico = NumeroTelefonico;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getResidencia() {
        return Residencia;
    }

    public void setResidencia(String Residencia) {
        this.Residencia = Residencia;
    }

    public int isExiste() {
        return Existe;
    }

    public void setExiste(int Existe) {
        this.Existe = Existe;
    }    
}
