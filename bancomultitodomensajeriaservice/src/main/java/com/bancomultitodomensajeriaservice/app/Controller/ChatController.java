/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Controller;

import com.bancomultitodomensajeriaservice.app.Model.ChatModel;
import com.bancomultitodomensajeriaservice.app.Model.MensajeModel;
import com.bancomultitodomensajeriaservice.app.Repository.ChatRepository;
import com.bancomultitodomensajeriaservice.app.Service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author ferna
 */

@Controller
public class ChatController {
    
   
    
    @Autowired
    private ChatService ser_chat;
    
    @Autowired
    private SimpMessagingTemplate simp;
    
    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public MensajeModel MessageGuardarMensaje(MensajeModel mensaje){
        
       
        if(mensaje.getMensaje() != null && !mensaje.getMensaje().trim().isEmpty()){
            
            ser_chat.CrearMensaje(mensaje);
            
            
        }else{
            
            throw new IllegalArgumentException("El mensaje no puede estsr vacio");
            
            
        }
        
       
        return mensaje;
        
    }
    
    
    
    
  
    
    
    
}
