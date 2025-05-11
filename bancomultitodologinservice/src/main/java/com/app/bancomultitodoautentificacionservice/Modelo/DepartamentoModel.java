/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ferna
 */
@Entity
@Table(name="departamento")
public class DepartamentoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_departamento")
    public int idDepartamento;
    
    @Column(name = "Nombre")
    public String nombre;
    
    @Column(name = "Cedula")
    public String cedula;

    public DepartamentoModel(int idDepartamento, String Nombre, String Cedula) {
        this.idDepartamento = idDepartamento;
        this.nombre = Nombre;
        this.cedula = Cedula;
    }
    
    public DepartamentoModel(){
        
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    
    
    
}
