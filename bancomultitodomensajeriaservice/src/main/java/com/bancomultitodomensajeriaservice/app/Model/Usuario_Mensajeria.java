/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ferna
 */


@Document(collation = "Usuario")
public class Usuario_Mensajeria {
 
    @Id
    private String Id_usuario;
    
    private String nombreUsuario;

    public Usuario_Mensajeria(String Id_usuario, String nombreUsuario) {
        this.Id_usuario = Id_usuario;
        this.nombreUsuario = nombreUsuario;
    }

    public String getId_usuario() {
        return Id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setId_usuario(String Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

   
    
    
    
}
