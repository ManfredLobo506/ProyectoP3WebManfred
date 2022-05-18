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
public class Usuarios {
//Atributos
    public void setPermisos(int Permisos) {
        this.Permisos = Permisos;
    }
    String UserName;
    int Id;
    String Password;
    Date FechaRegistro;
    int Permisos;

//Constructores

  public Usuarios(String UserName, int Id, String Password, Date FechaRegistro, int Permisos) {
        this.UserName = UserName;
        this.Id = Id;
        this.Password = Password;
        this.FechaRegistro = FechaRegistro;
        this.Permisos = Permisos;
    }    
  public Usuarios() {
    }    
  
//Getter and Setter  
     public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Date getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public int getPermisos() {
        return Permisos;
    }
}
