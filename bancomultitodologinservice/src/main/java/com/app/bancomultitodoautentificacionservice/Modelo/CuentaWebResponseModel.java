/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Modelo;

/**
 *
 * @author ferna
 */
public class CuentaWebResponseModel {
    
    
    private String departamento;
    
    private String token;

    public CuentaWebResponseModel(String departamento, String token) {
        this.departamento = departamento;
        this.token = token;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getToken() {
        return token;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setToken(String token) {
        this.token = token;
    }
    

   
    
}
