package com.app.bancomultitodoautentificacionservice;

import com.app.bancomultitodoautentificacionservice.Modelo.DepartamentoModel;
import com.app.bancomultitodoautentificacionservice.Modelo.EmpleadosModel;
import com.app.bancomultitodoautentificacionservice.Repositorio.CuentaWebRepository;
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
       CuentaWebRepository _CuentaWebRepository;

       @InjectMocks
       AutentificacionService _AutentificacionService;
       
       
       @Test
       public void VerificarCredenciales(){
           
           DepartamentoModel departamento = new DepartamentoModel();
           departamento.setIdDepartamento(1);
           departamento.setNombre("Gerencia");
           departamento.setCedula("1234567890");
           
           EmpleadosModel empleado = new EmpleadosModel();
           empleado.setCedula("2345678901");
           empleado.setNombre("Daniel Alfredo");
           empleado.setApellidos("Fernandez Moreira");
           empleado.setCorreo("Fernandez@gmail.com");
           empleado.setClave("fernandez123");
           empleado.setDepartamento(departamento);
           
           when(_CuentaWebRepository.findByCedulaAndClave("2345678901", "fernandez123")).thenReturn(empleado);
           
           String resultado = _AutentificacionService.Verificar_Credenciales("2345678901", "fernandez123");
           
           Assertions.assertEquals("Gerencia",resultado);
       }
       
    
     
}


