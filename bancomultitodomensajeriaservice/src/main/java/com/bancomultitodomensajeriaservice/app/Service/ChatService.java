/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Service;

import com.bancomultitodomensajeriaservice.app.Model.ChatModel;
import com.bancomultitodomensajeriaservice.app.Model.MensajeModel;
import com.bancomultitodomensajeriaservice.app.Repository.ChatRepository;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ferna
 */
public class ChatService {
    
    
    @Autowired
    ChatRepository repo_chat;
    
    
    @Transactional
    public void   CrearMensaje(MensajeModel mensaje){
        
      String id_remitente = mensaje.getRemitente().getId_usuario();
      String id_receptor = mensaje.getReceptor().getId_usuario();
        
        
      ChatModel chat = repo_chat.findByRemitenteANDReceptor(id_remitente, id_receptor);
        
      if(chat != null){
          
          
        chat.getMensaje().add(mensaje);  
        repo_chat.save(chat);
          
          
      }else{
          
          List<MensajeModel> lista_mensaje = new ArrayList<>();  
          lista_mensaje.add(mensaje);
          ChatModel nuevo_chat = new ChatModel();
          nuevo_chat.setMensaje(lista_mensaje);
          
          
          
      }
        
    }
    
    
    
}
