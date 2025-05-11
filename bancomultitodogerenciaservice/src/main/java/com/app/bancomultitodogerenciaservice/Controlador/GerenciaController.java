/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Controlador;

import com.app.bancomultitodogerenciaservice.Modelo.DepartamentoModel;
import com.app.bancomultitodogerenciaservice.Modelo.EmpleadoModel;
import com.app.bancomultitodogerenciaservice.Modelo.EmpleadoRegistroModel;
import com.app.bancomultitodogerenciaservice.Servicio.EmpleadoService;
import java.util.List;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ferna
 */
@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/gerencia")
public class GerenciaController {
    
    
    @Autowired
    EmpleadoService ser_emp;
    
    @PostMapping("/registrar-empleado")
    public ResponseEntity<String> PostRegistroEmpleado(@RequestBody EmpleadoRegistroModel empleado){
        
        String ced = empleado.getCedula();
        String nom = empleado.getNombres();
        String ape = empleado.getApellidos();
        String cor = empleado.getCorreo();
        LocalDate fec = empleado.getFechaDeNacimiento();
        String dep = empleado.getDepartamento();
        
        String cla = "";
        
        int id_dep = ser_emp.GetIdDepartamento(dep);
        
        
        if(!ced.isEmpty() || !nom.isEmpty() || !ape.isEmpty() || !cor.isEmpty() || fec != null ||  !dep.isEmpty()){
            
            String registrar_empleado = ser_emp.RegistrarEmpleados(ced, nom, ape, cor, fec, cla, id_dep);
            
            
            switch (registrar_empleado) {
                
                case "La cedula del empleado ya se encuentra previamente registrada": return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrar_empleado);
                
                case "El correo del empleado ya se encuentra previamente registrado": return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrar_empleado);
                    
                
                default: return ResponseEntity.status(HttpStatus.OK).body(registrar_empleado);
                
                
            }
            
            
            }else{
            
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los datos no pueden ser vacios");
        }
        
      
    }
      
    @PutMapping("/actualizar-clave-empleado")
    public ResponseEntity<String> PutActualizarClaveEmpleado(@RequestBody EmpleadoModel empleado){
      
        
        String ced = empleado.getCedula();
        
        
        
        
        
        String actualizar_clave_empleado = ser_emp.ActualizarClaveEmpleados(ced);
          
        
        switch (actualizar_clave_empleado) {
            
            case "La cedula del empleado no esta registrada": return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(actualizar_clave_empleado);
                
            default: return ResponseEntity.status(HttpStatus.OK).body(actualizar_clave_empleado);
                
        }
       
      
     }
    
    
    @PutMapping("/actualizar-empleados/{anteriorcedula}/{correoanterior}")
    public ResponseEntity<String> PutActualizarEmpleado(@RequestBody EmpleadoRegistroModel empleado, @PathVariable String anteriorcedula, @PathVariable String correoanterior){
        
        String ced = empleado.getCedula();
        String nom = empleado.getNombres();
        String ape = empleado.getApellidos();
        String cor = empleado.getCorreo();
        LocalDate fec = empleado.getFechaDeNacimiento();
        String dep = empleado.getDepartamento();
        
        int id_dep = ser_emp.GetIdDepartamento(dep);
        
       String actualizar_empleado = ser_emp.ActualizarEmpleados(ced, nom, ape, cor, fec, id_dep, anteriorcedula, correoanterior);
        
        System.out.println(actualizar_empleado);
        switch (actualizar_empleado) {
            
            case "La cedula que ingreso ya esta en uso": return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(actualizar_empleado);
            case "El correo que ingreso ya se encuentra en uso": return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(actualizar_empleado);
               
            default: return ResponseEntity.status(HttpStatus.OK).body(actualizar_empleado);
                
        }
        
        
        
    }
    
    @DeleteMapping("/eliminar-empleados/{cedula}")
    public ResponseEntity<String> DeleteEmpleado(@PathVariable String cedula){
        
        
        String eliminar_empleado = ser_emp.EliminarEmpleados(cedula);
        
        switch (eliminar_empleado) {
            case "El empleado no existe": return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eliminar_empleado);
            
                
            default: return ResponseEntity.status(HttpStatus.OK).body(eliminar_empleado);
                
        }
        
    }
    
 
    
    
      
    @GetMapping("/mostrar-empleados")
    public List<EmpleadoModel> MostrarEmpleado(){
        
        
        
        
        return ser_emp.ObtenerListaEmpleados();
        
        
        
        
    }
    
    @PostMapping("/filtrar-empleados-cedula")
    public List<EmpleadoModel> FiltrarEmpleadoCedula(@RequestBody EmpleadoModel empleado){
        
        String cedula = empleado.getCedula();
        
        System.out.println(cedula);
        
        System.out.println(ser_emp.ObtenerListaFiltradaEmpleadosCedula(cedula));
        
        return ser_emp.ObtenerListaFiltradaEmpleadosCedula(cedula);
        
        
        
    }
    
    @PostMapping("/filtrar-empleado-apellidos")
    public List<EmpleadoModel> FiltrarEmpleadoApellidos(@RequestBody EmpleadoModel empleado){
        
        
        String apellidos = empleado.getApellidos();
        
        return ser_emp.ObtenerListaFiltradaEmpleadosApellidos(apellidos);
        
    }
    
    
    
      @GetMapping("/departamentos")
        public List<String> MostrarDepartamentos(){
        
        
            List<String> lista_departamentos = ser_emp.GetDepartamentos();
        
        
            return lista_departamentos;
        
        }
    
        
    
}
