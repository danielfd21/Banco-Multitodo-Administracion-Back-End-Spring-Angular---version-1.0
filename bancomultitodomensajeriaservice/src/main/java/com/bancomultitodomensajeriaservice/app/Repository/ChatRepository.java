/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.Repository;

import com.bancomultitodomensajeriaservice.app.Model.ChatModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ferna
 */

@Repository
public interface ChatRepository extends MongoRepository<ChatModel, ObjectId>{
    
    @Query("{mensaje.remitente.id_usuario: ?0, mensaje.receptor.id_usuario: ?1} ")
    ChatModel findByRemitenteANDReceptor(String id_remitente, String id_receptor);
    
}
