/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Servicios;

import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import com.app.bancomultitodoautentificacionservice.Repositorio.CuentaWebRepository;
import com.app.bancomultitodoautentificacionservice.Repositorio.DepartamentoRepository;
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
    
    @Autowired
    private DepartamentoRepository repo_dep;
    
    
    public boolean Verificar_Credenciales(String usuario, String clave){
        
        boolean acceso = false;
        
        EmpleadosModel empleados = repo_cue_web.findByCedulaAndClave(usuario, clave);
        
       
        if(empleados != null){
            
            acceso = true;

            
        }
        
        
        
        
        
        
        
        return acceso;
        
        
        
        
    }
    
    
    public int GetId_Empleado(String cedula){
        
        int id = 0;
        
        
        EmpleadosModel empleado = repo_cue_web.findByCedula(cedula);
        
        if(empleado != null){
            
            id = empleado.getIdDepartamento();
        }
        
        return id;
        
    }
    
    
    public String getdepartamento(int Id_departamento, String cedula){
        
        String departamento = "";
        
        
        EmpleadosModel empleado = repo_cue_web.findByCedula(cedula);
        
        if(empleado != null){
            
            DepartamentoModel departamentos = repo_dep.findByIdDepartamento(Id_departamento);
            
            departamento = departamentos.getNombre();
            
        }
        
        
        
        
        return departamento;
        
    }
    
    
   
    
 
    
    
    
    
}
