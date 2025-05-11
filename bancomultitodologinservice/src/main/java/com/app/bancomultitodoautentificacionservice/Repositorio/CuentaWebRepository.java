/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodoautentificacionservice.Repositorio;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ferna
 */
@Repository
public interface  CuentaWebRepository extends JpaRepository<EmpleadosModel, Long>{
    
    EmpleadosModel findByCedulaAndClave(String cedula, String clave);
    EmpleadosModel findByCedula(String cedula);
    
}
