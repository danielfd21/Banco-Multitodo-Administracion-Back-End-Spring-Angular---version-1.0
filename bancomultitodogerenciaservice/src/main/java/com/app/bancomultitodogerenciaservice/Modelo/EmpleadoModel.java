/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author ferna
 */
@Entity
@Table(name="empleados")
public class EmpleadoModel { // selects 
    
    @Id
    @Column(name="cedula")
    public String cedula;
    
    @Column(name="nombre")
    public String nombre;
    
    @Column(name="apellidos")
    public String apellidos;
    
    @Column(name="correo")
    public String correo;
    
    @Column(name="fecha_de_nacimiento")
    public LocalDate fechaDeNacimiento;
    
    @Column(name="clave")
    public String clave;
    
    @ManyToOne // de muchos a uno  clave foranea
    @JoinColumn(name="Id_departamento")
    public DepartamentoModel idDepartamento;

    public EmpleadoModel(String cedula, String nombre, String apellidos, String correo, LocalDate fechaDeNacimiento, String clave, DepartamentoModel idDepartamento) {
        this.cedula = cedula;
        this.correo = correo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.clave = clave;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public EmpleadoModel(){
        
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getClave() {
        return clave;
    }

    public  DepartamentoModel getIdDepartamento() {
        return idDepartamento;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setIdDepartamento(DepartamentoModel idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
    
            
    
    
    
}
