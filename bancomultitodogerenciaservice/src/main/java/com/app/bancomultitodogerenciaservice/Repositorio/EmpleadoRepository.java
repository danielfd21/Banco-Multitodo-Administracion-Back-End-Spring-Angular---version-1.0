/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Repositorio;

import com.app.bancomultitodogerenciaservice.Modelo.EmpleadoModel;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ferna
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoModel, Long>  {
    
    
    EmpleadoModel findByCedula(String cedula);
    EmpleadoModel findByCorreo(String correo);
    
    
    @EntityGraph(attributePaths = {"idDepartamento","idDepartamento.cedula"}) List<EmpleadoModel> findAll();
    
    @Query("SELECT e FROM EmpleadoModel e WHERE e.apellidos LIKE %:apellidos%") 
    List<EmpleadoModel> FiltrarApellidos(@Param("apellidos") String apellidos);
    
    @Query("SELECT e FROM EmpleadoModel e WHERE e.cedula LIKE %:cedula%")
    List<EmpleadoModel> FiltrarCedula(@Param("cedula") String cedula);
    
    
}
