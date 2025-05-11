/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author ferna
 */

@Entity
@Table(name="jefe_departamento")
public class JefeDepartamentoModel {
    
    
    @Id
    @Column(name="Cedula")
    public String cedula;
    
    @Column(name="Nombres")
    public String nombres;
    
    @Column(name="Apellidos")
    public String apellidos;
    
    @Column(name="Correo")
    public String correo;
    
    @Column(name="Fecha_de_nacimiento")
    public LocalDate fechaDeNacimiento;

    public JefeDepartamentoModel(String cedula, String nombres, String apellidos, String correos, LocalDate fechaDeNacimiento) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correos;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    
    public JefeDepartamentoModel(){
        
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

    public String getCorreos() {
        return correo;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
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

    public void setCorreos(String correos) {
        this.correo = correos;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    
    

}