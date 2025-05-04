package com.turnito.test;

import java.time.LocalTime;

import com.turnito.modelo.Servicio;
import com.turnito.negocio.ServicioABM;

public class TestServicio {

	public static void main(String[] args) {
		ServicioABM abm = new ServicioABM();
		try {
			abm.eliminar(2);
			abm.agregar("Cardiologia", 30, true, LocalTime.of(10, 30));
			abm.agregar("Pediatria", 45, true, LocalTime.of(12, 00));
			abm.agregar("Pediatria", 45, true, LocalTime.of(13, 15));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Servicio s = abm.traer("Cardiologia");
			s.setEstado(false);
			abm.modificar(s);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(abm.traer());
		
		
	}

}
