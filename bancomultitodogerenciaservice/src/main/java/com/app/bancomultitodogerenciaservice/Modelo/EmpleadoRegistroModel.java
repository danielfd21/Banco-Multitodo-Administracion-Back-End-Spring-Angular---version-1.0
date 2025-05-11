/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

/**
 *
 * @author ferna
 */

public class EmpleadoRegistroModel { // inserts y updates 
    
   
    public String cedula;
    
    public String nombres;
    
    public String apellidos;
    
    public String correo;
    
    public LocalDate fechaDeNacimiento;
    
    public String departamento;

    public EmpleadoRegistroModel(String cedula, String nombres, String apellidos, String correo, LocalDate fechaDeNacimiento, String departamento) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.departamento = departamento;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
    
}
