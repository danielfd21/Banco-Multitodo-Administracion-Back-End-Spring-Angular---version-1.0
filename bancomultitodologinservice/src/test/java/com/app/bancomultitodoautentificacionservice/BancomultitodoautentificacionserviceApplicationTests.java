package com.app.bancomultitodoautentificacionservice;

import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import com.app.bancomultitodoautentificacionservice.Repositorio.CuentaWebRepository;
import com.app.bancomultitodoautentificacionservice.Repositorio.DepartamentoRepository;
import com.app.bancomultitodoautentificacionservice.Servicios.AutentificacionService;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
class BancomultitodoautentificacionserviceApplicationTests {
    
  

    
        @Mock
        CuentaWebRepository repo_cue_web;
        
        @Mock
        DepartamentoRepository repo_dep;
        
        
        
        @InjectMocks
        AutentificacionService aut_ser;
        
        
    
	@Test
	void contextLoads() {
	}
        
        
        
        @Test
        void Test_VerificarCredenciales(){
            
            String cedula = "023456789";
            String clave = "s4Wk_nxIX1B67jJ5";
            
        
            
            EmpleadosModel prueba_empleado = new EmpleadosModel();
            prueba_empleado.setCedula(cedula);
            prueba_empleado.setClave(clave);
            
            when(repo_cue_web.findByCedulaAndClave(cedula, clave)).thenReturn(prueba_empleado);
            
            boolean resultado = aut_ser.Verificar_Credenciales(cedula, clave);
            
            assertTrue(resultado);
            
            
        }
        
        @Test
        void Test_Get_ID_Empleado(){
            
            String cedula = "1234567891";
            
             
            EmpleadosModel prueba_empleado = new EmpleadosModel();
            
            prueba_empleado.setCedula(cedula);
            prueba_empleado.setIdDepartamento(4);
            
            
            
            when(repo_cue_web.findByCedula(cedula)).thenReturn(prueba_empleado);
            
            int id = aut_ser.GetId_Empleado(cedula);
            
            Assertions.assertEquals(4,id);
            
            
            
        }
        
        
        
        @Test
        void Test_Get_Departamento(){
            
            
            String cedula = "";
            int id_departamento = 4;
            String nombre_departamento = "Contabilidad";
            
            
            EmpleadosModel prueba_empleado = new EmpleadosModel();
            DepartamentoModel departamento = new DepartamentoModel();
            
            prueba_empleado.setCedula(cedula);
            prueba_empleado.setIdDepartamento(4);
            
            departamento.setIdDepartamento(id_departamento);
            departamento.setNombre(nombre_departamento);
            
            
            when(repo_cue_web.findByCedula(cedula)).thenReturn(prueba_empleado);
            when(repo_dep.findByIdDepartamento(id_departamento)).thenReturn(departamento);
            
            String nombre_departamento_recibido = aut_ser.getdepartamento(id_departamento, cedula);
            
            Assertions.assertEquals("Contabilidad", nombre_departamento_recibido);
            
        }
     
}


