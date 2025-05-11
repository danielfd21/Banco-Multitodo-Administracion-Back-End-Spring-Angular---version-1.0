/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ferna
 */

@Entity
@Table(name="empleados")
public class EmpleadosModel {
       
       @Id
       @Column(name = "cedula")
       public String cedula;
       
       @Column(name = "nombre")
       public String nombre;
       
       @Column(name = "apellidos")
       public String apellidos;
       
       @Column(name = "correo")
       public String correo;
       
       @Column(name = "fecha_de_nacimiento")
       public String fecha_de_nacimiento;
       
       @Column(name = "clave")
       public String clave;
       
       @Column(name = "Id_departamento")
       public int idDepartamento;

    public EmpleadosModel(String cedula, String nombre, String apellidos, String correo, String fecha_de_nacimiento, String clave, int idDepartamento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.clave = clave;
        this.idDepartamento = idDepartamento;
    }
    
    public EmpleadosModel(){
        
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

    public String getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public String getClave() {
        return clave;
    }

    public int getIdDepartamento() {
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

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    
       
       
       
    
}
