/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bancomultitodogerenciaservice.Repositorio;

import com.app.bancomultitodogerenciaservice.Modelo.DepartamentoModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ferna
 */
public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Integer>{
    
    
    DepartamentoModel findByIdDepartamento(int id); // ORM
    
    DepartamentoModel findByNombre(String nom_dep);
    
     @Query("SELECT d.nombre FROM DepartamentoModel d") // Hibernate 
       List<String> GetAllDepartamentos();
}
