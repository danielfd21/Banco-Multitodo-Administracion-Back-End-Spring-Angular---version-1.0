/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Servicio;

import com.app.bancomultitodogerenciaservice.Modelo.DepartamentoModel;
import com.app.bancomultitodogerenciaservice.Modelo.EmpleadoModel;
import com.app.bancomultitodogerenciaservice.Repositorio.DepartamentoRepository;
import com.app.bancomultitodogerenciaservice.Repositorio.EmpleadoRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferna
 */

@Service
public class EmpleadoService {
    
    
    @Autowired
    EmpleadoRepository repo_emp;
    
    
    
    @Autowired
    DepartamentoRepository repo_dep;
            
    
    // Consultas encapsuladas
    
    public boolean Verificar_Cedula_Empleado(String cedula){
        
        boolean acceso = false;
        
        
        EmpleadoModel empleado = repo_emp.findByCedula(cedula);
        
        if(empleado != null){
            
            acceso = true;
        }
        
        
        return acceso;
    }
    
     public boolean Verificar_Correo_Empleado(String correo){
        
        boolean acceso = false;
        
        
        EmpleadoModel empleado = repo_emp.findByCorreo(correo);
        
        if(empleado != null){
            
            acceso = true;
        }
        
        
        return acceso;
    }
    
    
    public void InsertTablaEmpleados(String ced, String nom ,String ape, String cor, LocalDate fec, String cla, int id_dep){
        
        DepartamentoModel departamento = repo_dep.findByIdDepartamento(id_dep);
        
        
        EmpleadoModel Nuevo_empleado = new EmpleadoModel(ced, nom, ape, cor, fec, cla, departamento);
        
        repo_emp.save(Nuevo_empleado);
        
        
    }
    
    
    
    public void UpdateClaveEmpleados(String ced,String cla){
        
        
        
        EmpleadoModel empleado = repo_emp.findByCedula(ced);
        
          
            empleado.setClave(cla);
            
            repo_emp.save(empleado);
        
        
        
        
    }
    
    
    
    
    
    
    public void UpdateEmpleados(String ced, String nom ,String ape, String cor, LocalDate fec, int id_dep){
    
        
        DepartamentoModel departamento = new DepartamentoModel();
        departamento.setIdDepartamento(id_dep);
        
        EmpleadoModel empleado = repo_emp.findByCedula(ced);
        
        empleado.setCedula(ced);
        empleado.setNombre(nom);
        empleado.setApellidos(ape);
        empleado.setCorreo(cor);
        empleado.setFechaDeNacimiento(fec);
        empleado.setIdDepartamento(departamento);
        
        repo_emp.save(empleado);
        
    }
    
    
    public void UpdateEmpleadosCedula(String ced, String nom ,String ape, String cor, LocalDate fec, int id_dep, String ant_ced){
   
        DepartamentoModel departamento = new DepartamentoModel();
        departamento.setIdDepartamento(id_dep);
        
        EmpleadoModel empleado = repo_emp.findByCedula(ant_ced);
        
        empleado.setCedula(ced);
        empleado.setNombre(nom);
        empleado.setApellidos(ape);
        empleado.setCorreo(cor);
        empleado.setFechaDeNacimiento(fec);
        empleado.setIdDepartamento(departamento);
        
        repo_emp.save(empleado);
        
    }
    
    
    public void DeleteEmpleados(String cedula){
        
        EmpleadoModel empleado = repo_emp.findByCedula(cedula);
        
        repo_emp.delete(empleado);
        
    }
    
    
    // Transacciones encapsuladas para ser enviadas al controlador
    
    @Transactional // asincronica 
    public String RegistrarEmpleados(String ced, String nom ,String ape, String cor, LocalDate fec, String cla, int id_dep){
        
        String mensaje = "";
        
        
        
           
            boolean ver_ced_emp = Verificar_Cedula_Empleado(ced);
            
            if(ver_ced_emp == false){
                
                boolean ver_cor_emp = Verificar_Correo_Empleado(cor);
            
                if(ver_cor_emp == false){
                
                    InsertTablaEmpleados(ced, nom, ape, cor, fec, cla, id_dep);
            
                    mensaje = "Empleado Creado con exito";
                
                 }else{
                    
                    mensaje = "El correo del empleado ya se encuentra previamente registrado";
                
                }
            
                
                
                
            }else{
                mensaje = "La cedula del empleado ya se encuentra previamente registrada";
            }
        
        
        return mensaje;
        
    }
    
    @Transactional
    public String ActualizarClaveEmpleados(String ced){
        
        String mensaje = "";
        
        boolean ver_ced = Verificar_Cedula_Empleado(ced);
        
        if(ver_ced == true){
            
            
            String minusculas = "abcdefghijklmnopqrstuwxyz";
            String mayusculas = minusculas.toUpperCase();
            String numeros = "1234567890";
            String caracteres = "@#_-";
            
            String cadena = minusculas + mayusculas + numeros + caracteres;
            
            String min = "/^[a-z]+$/";
            String may = "/^[A-Z]+$/";
            String num = "/^[0-9]+$/";
            String car = "/^[@#_-]+$/";
            
            String min_may = "/^[a-zA-Z]+$/";
            String min_num = "/^[a-z0-9]+$/";
            String min_car = "/^[a-z@#_-]+$/";
            String may_num = "/^[A-Z0-9]+$/";
            String may_car = "/^[A-Z@#_-]+$/";
            String num_car = "/^[0-9@#_-]+$/";
            
            String min_may_num = "/^[a-zA-Z0-9]+$/";
            String min_may_car = "/^[a-zA-Z@#_-]+$/";
            String min_num_car = "/^[a-z0-9@#_-]+$/";
            String may_num_car = "/^[A-Z0-9@#_-]+$/";
            
            
            String clave_tem = "";
            String cla = "";
            
            Random aleatorio = new Random();
            
            boolean bandera = false;
            
            while(bandera == false){
                 
                for(int i = 0; i<16; i++){
                    
                    int pos = aleatorio.nextInt(cadena.length());
                    char digito = cadena.charAt(pos);
                    clave_tem += digito;
                    
                }
                
                if(clave_tem.matches(min) || clave_tem.matches(may) || clave_tem.matches(num) || clave_tem.matches(car) || clave_tem.matches(min_may) || clave_tem.matches(min_num) || clave_tem.matches(min_car) || clave_tem.matches(may_car) || clave_tem.matches(may_num) || clave_tem.matches(num_car) || clave_tem.matches(min_may_num) || clave_tem.matches(min_may_car) || clave_tem.matches(min_num_car) || clave_tem.matches(may_num_car)){
                    
                    clave_tem = "";
                    
                }else{
                    
                    cla = clave_tem; //@$#Adsa1123
                    bandera = true;
                }
                
            }  
            
            
           
            
            
            
            
            UpdateClaveEmpleados(ced, cla);
            
           
                
                mensaje = cla;
            
            
        }else{
            
            mensaje = "La cedula del empleado no esta registrada";
        }
        
        return mensaje;
    }
    
    
    @Transactional // asincronica 
    public String ActualizarEmpleados(String ced, String nom ,String ape, String cor, LocalDate fec, int id_dep, String ant_ced, String ant_cor){
       
        String mensaje = "";
        
        if(!ced.equals(ant_ced) && !cor.equals(ant_cor)){
            
            
            
             boolean ver_ced = Verificar_Cedula_Empleado(ced);
        
        if(ver_ced == false){
               
                
                
            
                boolean ver_cor = Verificar_Correo_Empleado(cor);
                
                if(ver_cor == false){
                    
                     UpdateEmpleados(ced, nom, ape, cor, fec, id_dep);
            
                    mensaje = "Empleado actualizado con exito";
                    
                }else{
                    
                    mensaje = "El correo que ingreso ya se encuentra en uso";
                }
                        
         
        }else{
            
            mensaje = "La cedula que ingreso ya esta en uso";
        }
       
            
            
        }else if(ced.equals(ant_ced) && !cor.equals(ant_cor)){
            
 
            
            boolean ver_cor = Verificar_Correo_Empleado(cor);
            
            if(ver_cor == false){
                
                 UpdateEmpleados(ced, nom, ape, cor, fec, id_dep);
            
                 mensaje = "Empleado actualizado con exito";
            }else{
                
                mensaje = "El correo que ingreso ya se encuentra en uso";
            }
            
            
            
        }else if(!ced.equals(ant_ced) && cor.equals(ant_cor)){
            
           
            
            boolean ver_ced = Verificar_Cedula_Empleado(ced);
            
            if(ver_ced == false){
                
                
                EmpleadoModel empleado = repo_emp.findByCedula(ant_ced);
                
                String cla = empleado.clave;
                
                EliminarEmpleados(ant_ced);
                
                
                
                
                
                RegistrarEmpleados(ced, nom, ape, cor, fec, cla, id_dep);
            
                mensaje = "Empleado actualizado con exito";
                
                
            }else{
                
                mensaje = "La cedula que ingreso ya esta en uso";
            }
            
            
        }else{
        
             UpdateEmpleados(ced, nom, ape, cor, fec, id_dep);
            
            mensaje = "Empleado actualizado con exito";
        }
        
        
        
        
       
        
        return mensaje;
    }
    
    
    public String EliminarEmpleados(String ced){
        
        String mensaje = "";
        
        boolean ver_ced = Verificar_Cedula_Empleado(ced);
        
        if(ver_ced == true){
            
            DeleteEmpleados(ced);
            
            mensaje = "Empleado eliminado con exito";
            
        }else{
            
            mensaje = "El empleado no existe";
        }
        
        
        
        return mensaje;
        
    }
    
    
    
    public List<EmpleadoModel> ObtenerListaEmpleados(){
        
        
        
        return repo_emp.findAll();
        
        
    }
    
    
    
    public List<EmpleadoModel> ObtenerListaFiltradaEmpleadosCedula(String cedula){
        
        
        
        
        return repo_emp.FiltrarCedula(cedula);
        
    }
    
    
    public List<EmpleadoModel> ObtenerListaFiltradaEmpleadosApellidos(String apellidos){
        
        
        return repo_emp.FiltrarApellidos(apellidos);
        
    }
    
     
    public List<String> GetDepartamentos(){
        
        List<String> lista_departamentos = repo_dep.GetAllDepartamentos();
        
        
        return lista_departamentos;
        
    }
    

   public int GetIdDepartamento(String nombre_dep){
       
       int id = 0;
       
       
       DepartamentoModel departamento = repo_dep.findByNombre(nombre_dep);
       
       if(departamento != null){
           
           id = departamento.getIdDepartamento();
           
       }
       
       
       
       return id;
       
   }
    
    
}




