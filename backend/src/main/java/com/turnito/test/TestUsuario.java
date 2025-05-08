package com.turnito.test;

import com.turnito.modelo.Usuario;
import com.turnito.modelo.Administrador;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Profesional;
import com.turnito.negocio.UsuarioABM;

public class TestUsuario {
	public static void main(String[] args) {
		UsuarioABM abm = new UsuarioABM();

		try {
			System.out.println("Intento agregar Profesionales:");

			System.out.println("Se agregó el profesional con ID: " + abm.agregar(new Profesional("Gabriela Salinas", "gabi.salinas@mail.com", "1123456789", 14567890L, "MAT-001", "Dermatología")));
			System.out.println("Se agregó el profesional con ID: " + abm.agregar(new Profesional("Luciano Méndez", "luciano.m@mail.com", "1134567890", 21789456L, "MAT-002", "Atención al Vecino")));
			System.out.println("Se agregó el profesional con ID: " + abm.agregar(new Profesional("Carla Lopez", "carla.lopez@mail.com", "1145678901", 30981234L, "MAT-003", "Asesoría Jurídica")));

			// Agregar un solicitante
			System.out.println("Se agregó el solicitante con ID: " + abm.agregar(new Solicitante("Juan Pérez", "juan.perez@mail.com", "1178901234", 35890123L, "Consulta medica")));

			// Agregar un administrador
			System.out.println("Se agregó el administrador con ID: " + abm.agregar(new Administrador("Laura Gómez", "laura.gomez@mail.com", "1189012345", 40123456L,"Administracion")));

			// Profesional duplicado (DNI ya existente)
			abm.agregar(new Profesional("Gabriela", "Salinas", "gabi.dup@mail.com", 14567890L, "MAT-004", "Dermatologia"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Mostrar todos los usuarios cargados
		System.out.println("Lista inicial de usuarios:");
		System.out.println(abm.traer());

		// Modificar un profesional existente
		try {
			Profesional p = (Profesional) abm.traerPorDni(21789456L);
			p.setEspecialidad("Atención Integral");
			abm.modificar(p);
			System.out.println("Profesional modificado correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Modificar con matrícula duplicada
		try {
			Profesional p = (Profesional) abm.traerPorDni(30981234L);
			p.setMatricula("MAT-001");
			abm.modificar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Eliminar un profesional
		try {
			abm.eliminar(abm.traerPorDni(14567890L));
			System.out.println("Profesional eliminado correctamente.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Eliminar un profesional que no existe
		try {
			abm.eliminar(abm.traerPorDni(42135758L));
			System.out.println("Profesional eliminado correctamente.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Mostrar lista final
		System.out.println("Lista final de usuarios:");
		System.out.println(abm.traer());
	}
}
