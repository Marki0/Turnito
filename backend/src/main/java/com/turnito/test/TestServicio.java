package com.turnito.test;

import java.time.LocalTime;

import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;
import com.turnito.negocio.ServicioABM;
import com.turnito.negocio.UsuarioABM;

public class TestServicio {

	public static void main(String[] args) {
		ServicioABM abmServicio = new ServicioABM();
		UsuarioABM abmUsuario = new UsuarioABM();
		try {
			// Intento agregar 5 servicios
			System.out.println("Intengo agregar Servicios: ");
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Vacunación", 10, true, LocalTime.of(15, 0)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Atención al Cliente ", 10, true, LocalTime.of(9, 0)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Renovación de DNI", 20, false, LocalTime.of(10, 30)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Consulta Médica General", 30, true, LocalTime.of(11, 45)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Asesoría Legal", 45, true, LocalTime.of(13, 15)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Vacunación", 5, false, LocalTime.of(14, 0)));
			System.out.println("Se agregó la actividad con ID: "
					+ abmServicio.agregar("Vacunación", 5, false, LocalTime.of(14, 0)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Intento modificar un servicio
		try {
			Servicio s = abmServicio.traer("Atencion al cliente");
			s.setDuracion(8);
			s.setEstado(false);
			abmServicio.modificar(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//Intento modificar a un duplicado
		
		try {
			Servicio s = abmServicio.traer("Atencion al cliente");
			s.setNombre("Renovación de DNI");
			s.setHorario(LocalTime.of(10, 30));
			abmServicio.modificar(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Intento eliminar un servicio
		try {
			System.out.println("Intento eliminar servicio: ");
			abmServicio.eliminar(abmServicio.traer("Asesoria Legal", LocalTime.of(13, 15)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Intengo agregar un profesional al servicio
		
		try {
			System.out.println("Intento agregar profesional al servicio");
			System.out.println("Agregar profesional al servicio: " + abmServicio.traer("Vacunación",LocalTime.of(15, 0)).agregar((Profesional) abmUsuario.traerPorDni(11111)));
			System.out.println("Agregar profesional al servicio: " + abmServicio.traer("Vacunación",LocalTime.of(15, 0)).agregar((Profesional) abmUsuario.traerPorDni(631321)));
			System.out.println("Agregar profesional al servicio: " + abmServicio.traer("Vacunación",LocalTime.of(15, 0)).agregar((Profesional) abmUsuario.traerPorDni(631321)));
			System.out.println("Agregar profesional al servicio: " + abmServicio.traer("Vacunación",LocalTime.of(15, 0)).agregar((Profesional) abmUsuario.traerPorDni(1111111)));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Intento eliminar un profesional al servicio
		try {
			System.out.println("Intento eliminar el profesional del servicio: " + abmServicio.traer("Vacunacion", LocalTime.of(15, 0)).eliminar((Profesional) abmUsuario.traerPorDni(11111)));
			System.out.println("Intento eliminar el profesional del servicio: " + abmServicio.traer("Vacunacion", LocalTime.of(15, 0)).eliminar((Profesional) abmUsuario.traerPorDni(11111)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Traigo todos los Profesionales de un servicio
		
		try {
			System.out.println("Profesionales por servicio: ");
			System.out.println(abmServicio.traer("Vacunación",LocalTime.of(15, 0)).traerServicioYProfesionales(abmServicio.traer("Vacunación",LocalTime.of(15, 0))));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
