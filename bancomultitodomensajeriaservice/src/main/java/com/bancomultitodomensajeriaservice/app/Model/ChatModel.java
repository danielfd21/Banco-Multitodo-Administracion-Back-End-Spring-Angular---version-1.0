/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Model;


import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ferna
 */


@Document(collation = "chat")
public class ChatModel {
    
    @Id
    private ObjectId id_chat;
   
    private List<MensajeModel> mensaje;

    public ChatModel(ObjectId id_chat, List<MensajeModel> mensaje) {
        this.id_chat = id_chat;
        this.mensaje = mensaje;
    }
    
    public ChatModel(){
        
    }

    public ObjectId getId_chat() {
        return id_chat;
    }

    public List<MensajeModel> getMensaje() {
        return mensaje;
    }

    public void setId_chat(ObjectId id_chat) {
        this.id_chat = id_chat;
    }

    public void setMensaje(List<MensajeModel> mensaje) {
        this.mensaje = mensaje;
    }
    
   
    
    
    
}
