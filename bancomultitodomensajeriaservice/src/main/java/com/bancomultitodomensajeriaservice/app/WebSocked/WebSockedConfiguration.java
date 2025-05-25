/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancomultitodomensajeriaservice.app.WebSocked;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.graphql.reactive.GraphQlWebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.graphql.reactive.GraphQlWebFluxAutoConfiguration.WebSocketConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * @author ferna
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSockedConfiguration  implements  WebSocketMessageBrokerConfigurer{
    
   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry){
       registry.addEndpoint("/chat-websocket").setAllowedOrigins("*").withSockJS();
   }
   
   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry){
       registry.setApplicationDestinationPrefixes("/app");
       registry.enableSimpleBroker("/topic");
       
       
       
   }
}
