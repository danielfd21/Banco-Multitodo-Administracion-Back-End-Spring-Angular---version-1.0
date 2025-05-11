/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Controlador;

import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
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

    
    
    
    @PostMapping("")
    public ResponseEntity<String> PostLoguear(@RequestBody EmpleadosModel empleado){
 
        String usu = empleado.getCedula();
        String cla = empleado.getClave();
        
        if(usu != null && cla != null ){
            
            boolean verificar_credenciales = autentificacion_service.Verificar_Credenciales(usu, cla);
            
            if(verificar_credenciales == true){
                
                int id = autentificacion_service.GetId_Empleado(usu);
                
                String dep = autentificacion_service.getdepartamento(id, usu);
                
                switch (dep) {
                    
                    case "Contabilidad": return ResponseEntity.status(HttpStatus.OK).body("Contabilidad"); 
                    case "Gerencia": return ResponseEntity.status(HttpStatus.OK).body("Gerencia"); 
                    case "Asistencia al cliente":return ResponseEntity.status(HttpStatus.OK).body("Asistencia al cliente");
                    default:  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("departamento inexistente");
                        
                       
                }
                
                
                
                
                
              
                
                
            }else{
                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Las credenciales son incorrectas");
                
            }
            
            
            
            
            
            
            
        }else{
         
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario o contraseña no pueden estar vacíos.");
            
        }
        
        
        
         
        
    }
    
    
  
    
    
    
}
