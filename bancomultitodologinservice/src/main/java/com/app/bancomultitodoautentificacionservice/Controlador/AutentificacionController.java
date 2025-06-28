/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Controlador;

import com.app.bancomultitodoautentificacionservice.Modelo.CuentaWebResponseModel;
import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import com.app.bancomultitodoautentificacionservice.Security.JwtUtil;
import com.app.bancomultitodoautentificacionservice.Servicios.AutentificacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ferna
 */
@CrossOrigin(origins = "http://localhost:4200") // url de la dirección de angular
@RequestMapping("/autentificacion")
@RestController
public class AutentificacionController {
    
    @Autowired
    AutentificacionService autentificacion_service;
    
    @Autowired
    JwtUtil jwutil;

  
    
    
    @PostMapping("/login")
    public ResponseEntity<?> PostLoguear(@RequestParam String usu, @RequestParam String cla){
 
        
        String departamento = "";
        
        if(usu != null && cla != null ){
            
           departamento  = autentificacion_service.Verificar_Credenciales(usu, cla);
            
            if(!departamento.equals("Credenciales incorrectas")){
                
                String token = jwutil.GenerarToken(usu);
                
                
                
                CuentaWebResponseModel cuenta = new CuentaWebResponseModel(departamento, token);
                
                switch (departamento) {
                    
                    case "Contabilidad": return ResponseEntity.status(HttpStatus.OK).body(cuenta); 
                    case "Gerencia": return ResponseEntity.status(HttpStatus.OK).body(cuenta); 
                    default: return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Por el momento su departamento no cuenta con un area de trabajo, estaremos trabajando en ello proximamente Gracias!");
                        
                       
                }
                
                
                
                
                
              
                
                
            }else{
                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(departamento);
                
            }
            
            
            
            
            
            
            
        }else{
         
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario o contraseña no pueden estar vacíos.");
            
        }
        
        
        
         
        
    }
    
    
  
    
    
    
}
