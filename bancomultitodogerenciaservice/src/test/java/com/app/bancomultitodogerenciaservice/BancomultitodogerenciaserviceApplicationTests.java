package com.app.bancomultitodogerenciaservice;

import com.app.bancomultitodogerenciaservice.Modelo.DepartamentoModel;
import com.app.bancomultitodogerenciaservice.Modelo.EmpleadoModel;
import com.app.bancomultitodogerenciaservice.Repositorio.DepartamentoRepository;
import com.app.bancomultitodogerenciaservice.Repositorio.EmpleadoRepository;
import com.app.bancomultitodogerenciaservice.Servicio.EmpleadoService;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@SpringBootTest
class BancomultitodogerenciaserviceApplicationTests {

	@Test
	void contextLoads() {
	}
        
        
        
        @Mock
        EmpleadoRepository repo_emp;
        
        @Mock
        DepartamentoRepository repo_dep;
        
        @InjectMocks
        EmpleadoService ser_emp;
        
       @Test
       void Tets_Verificar_Cedula_Empleado(){
           
           String cedula = "1234567890";
           
           EmpleadoModel prueba_empledado = new EmpleadoModel();
                   
           prueba_empledado.setCedula(cedula);
           
           when(repo_emp.findByCedula(cedula)).thenReturn(prueba_empledado);
           
           boolean resultado = ser_emp.Verificar_Cedula_Empleado("1234567890");
           
           Assertions.assertTrue(resultado);
           
           
       }
       
       @Test
       void Test_Insert_Tabla_Empleados(){
           
           String ced = "1234567890"; 
           String nom = "Luis Andres";
           String ape = "Miguel Bose";
           String cor = "MiguelBose@gmail.com"; 
           LocalDate fec = LocalDate.parse("2000-01-01");
           String cla = ""; 
           int id_dep = 5;
           
           String nom_dep = "Contabilidad";
           
           
           EmpleadoModel prueba_empleado = new EmpleadoModel();
           DepartamentoModel prueba_departamento = new DepartamentoModel();
           
           prueba_departamento.setIdDepartamento(id_dep);
           prueba_departamento.setNombre(nom_dep);
           
           when(repo_dep.findByIdDepartamento(id_dep)).thenReturn(prueba_departamento);
           
           
           prueba_empleado.setCedula(ced);
           prueba_empleado.setNombre(nom);
           prueba_empleado.setApellidos(ape);
           prueba_empleado.setCorreo(cor);
           prueba_empleado.setFechaDeNacimiento(fec);
           prueba_empleado.setClave(cla);
           prueba_empleado.setIdDepartamento(prueba_departamento);
           
           ser_emp.InsertTablaEmpleados(ced, nom, ape, cor, fec, cla, id_dep);
           
           ArgumentCaptor<EmpleadoModel> captor = ArgumentCaptor.forClass(EmpleadoModel.class);
           verify(repo_emp).save(captor.capture());
           
           EmpleadoModel empleadosave = captor.getValue();
           
           Assertions.assertEquals(ced,empleadosave.getCedula());
           Assertions.assertEquals(nom,empleadosave.getNombre());
           Assertions.assertEquals(ape,empleadosave.getApellidos());
           Assertions.assertEquals(cor,empleadosave.getCorreo());
           Assertions.assertEquals(fec,empleadosave.getFechaDeNacimiento());
           Assertions.assertEquals(cla,empleadosave.getClave());
           Assertions.assertEquals(prueba_departamento,empleadosave.getIdDepartamento());
           
           
       }

}
