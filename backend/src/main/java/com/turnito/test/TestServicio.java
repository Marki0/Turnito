package com.turnito.test;

import java.time.LocalTime;

import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;
import com.turnito.negocio.ProfesionalABM;
import com.turnito.negocio.ServicioABM;
import com.turnito.negocio.UsuarioABM;

public class TestServicio {

	public static void main(String[] args) {
		ServicioABM abmServicio = new ServicioABM();
		UsuarioABM abmUsuario = new UsuarioABM();
		ProfesionalABM abmProfesional = new ProfesionalABM();
		try {
			System.out.println("Se agrego el usuario con ID: " + abmServicio.agregar("Cardiologia", 30, true, LocalTime.of(10, 30)));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servicio s = abmServicio.traer("Cardiologia");
			s.setEstado(false);
			abmServicio.modificar(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(abmServicio.traer());
		
        try {
			abmUsuario.agregar(new Profesional("Pepe","6231","3254321234",631321L,"H215SA","Medico Clinico"));
			System.out.println(abmServicio.traer());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
        try {
			Servicio s = abmServicio.traer("Cardiologia");
			System.out.println(s);
			Profesional p = abmProfesional.traer(abmUsuario.traerPorDni(631321L).getId());
			System.out.print(p);
			s.agregar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
