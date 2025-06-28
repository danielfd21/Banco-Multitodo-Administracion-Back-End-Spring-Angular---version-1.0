/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Servicios;

import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import com.app.bancomultitodoautentificacionservice.Repositorio.CuentaWebRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */
@Service
public class AutentificacionService {
    
    
    @Autowired
    private CuentaWebRepository repo_cue_web;
    

    
    
    public String Verificar_Credenciales(String usuario, String clave){
        
       String departamento = "";
        
        EmpleadosModel empleados = repo_cue_web.findByCedulaAndClave(usuario, clave);
        
       
        if(empleados != null){
            
           departamento = empleados.getDepartamento().getNombre();

            
        }else{
            
            return "Credenciales incorrectas";
        }
        
        
        
        
        
        
        
        return departamento;
        
        
        
        
    }
    
    
  
    
    

    
    
    
    
}
