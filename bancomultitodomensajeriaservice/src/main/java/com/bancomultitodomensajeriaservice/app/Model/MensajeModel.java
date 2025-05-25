/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Model;


import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ferna
 */


@Document(collection = "mensaje")
public class MensajeModel {
    
    
    @Id
    private ObjectId id_mensaje;
    
    private LocalDate fecha_de_envio;
    
    private LocalTime hora_de_envio;
    
    private String Mensaje;
    
    private Usuario_Mensajeria remitente;
    
    private Usuario_Mensajeria receptor;

    public MensajeModel(ObjectId id_mensaje, LocalDate fecha_de_envio, LocalTime hora_de_envio, String Mensaje, Usuario_Mensajeria remitente, Usuario_Mensajeria receptor) {
        this.id_mensaje = id_mensaje;
        this.fecha_de_envio = fecha_de_envio;
        this.hora_de_envio = hora_de_envio;
        this.Mensaje = Mensaje;
        this.remitente = remitente;
        this.receptor = receptor;
    }
    
    
    public MensajeModel(){
        
    }

    public ObjectId getId_mensaje() {
        return id_mensaje;
    }

    public LocalDate getFecha_de_envio() {
        return fecha_de_envio;
    }

    public LocalTime getHora_de_envio() {
        return hora_de_envio;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public Usuario_Mensajeria getRemitente() {
        return remitente;
    }

    public Usuario_Mensajeria getReceptor() {
        return receptor;
    }

    public void setId_mensaje(ObjectId id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public void setFecha_de_envio(LocalDate fecha_de_envio) {
        this.fecha_de_envio = fecha_de_envio;
    }

    public void setHora_de_envio(LocalTime hora_de_envio) {
        this.hora_de_envio = hora_de_envio;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public void setRemitente(Usuario_Mensajeria remitente) {
        this.remitente = remitente;
    }

    public void setReceptor(Usuario_Mensajeria receptor) {
        this.receptor = receptor;
    }
    
    
    
    
}
