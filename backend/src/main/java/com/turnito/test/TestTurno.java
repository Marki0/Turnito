package com.turnito.test;

import com.turnito.modelo.Turno;
import com.turnito.negocio.ServicioABM;
import com.turnito.negocio.TurnoABM;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestTurno {


    public static void main(String[] args) {
        // Crear una instancia de Turno

        TurnoABM abm = new TurnoABM();
        try {
            abm.agregar( LocalDate.now(), LocalTime.now(), true, "123 Main St", null, null, null);
            abm.agregar( LocalDate.now(), LocalTime.now(), true, "123 Main St", null, null, null);
            abm.agregar( LocalDate.now(), LocalTime.now(), true, "123 Main St", null, null, null);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}
