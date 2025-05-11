/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author ferna
 */

@Entity
@Table(name="departamento")
public class DepartamentoModel {
    
    @Id
    @Column(name = "Id_departamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idDepartamento;
    
    
    @Column(name = "Nombre")
    public String nombre;
    
    
    @OneToOne // uno a uno clave foranea
    @JoinColumn(name = "Cedula")
    public JefeDepartamentoModel cedula;
    
    

    public DepartamentoModel(int idDepartamento, String nombre, JefeDepartamentoModel cedula) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public DepartamentoModel(){
        
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public JefeDepartamentoModel getCedula() {
        return cedula;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(JefeDepartamentoModel cedula) {
        this.cedula = cedula;
    }
    
    
    
    
}
