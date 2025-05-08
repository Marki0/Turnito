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

    	    System.out.println("Se agregó la actividad con ID: " + abm.agregar(new Profesional("Gabriela Salinas", "gabi.salinas@mail.com", "1123456789", 14567890L, "MAT-001", "Dermatología")));
    	    System.out.println("Se agregó la actividad con ID: " + abm.agregar(new Profesional("Luciano Méndez", "luciano.m@mail.com", "1134567890", 21789456L, "MAT-002", "Atención al Vecino")));
    	    System.out.println("Se agregó la actividad con ID: " + abm.agregar(new Profesional("Carla Lopez", "carla.lopez@mail.com", "1145678901", 30981234L, "MAT-003", "Asesoría Jurídica")));
    	    System.out.println("Se agregó la actividad con ID: " + abm.agregar(new Profesional("Nicolás Ortega", "nico.ortega@mail.com", "1156789012", 38123456L, "MAT-004", "Fisioterapia")));
    	    System.out.println("Se agregó la actividad con ID: " + abm.agregar(new Profesional("Valeria Torres", "val.torres@mail.com", "1167890123", 42995678L, "MAT-005", "Trámites Documentales")));

    	    // Profesional duplicado (DNI ya existente)
    	    abm.agregar(new Profesional("Gabriela", "Salinas", "gabi.dup@mail.com", 14567890L, "MAT-006", "Dermatologia"));

    	} catch (Exception e) {
    	    System.out.println(e.getMessage());
    	}

    	// Mostrar profesionales cargados
    	System.out.println(abm.traer());

    	// Modificar un profesional existente
    	try {
    	    Profesional p = (Profesional) abm.traerPorDni(21789456L);
    	    p.setEspecialidad("Atencion Integral");
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
    	System.out.println("Lista de usuarios: ");
    	System.out.println(abm.traer());


    }
}
