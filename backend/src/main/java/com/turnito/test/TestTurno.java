package com.turnito.test;

import com.turnito.modelo.Turno;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Servicio;
import com.turnito.negocio.TurnoABM;
import com.turnito.negocio.ProfesionalABM;
import com.turnito.negocio.ServicioABM;
import com.turnito.negocio.UsuarioABM;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestTurno {

    public static void main(String[] args) {
        TurnoABM abmTurno = new TurnoABM();
        UsuarioABM abmUsuario = new UsuarioABM();
        ServicioABM abmServicio = new ServicioABM();
        ProfesionalABM abmProfesional = new ProfesionalABM();

        try {
            // Crear un profesional (Usuario)
            Profesional profesional = new Profesional("Carlos", "2345", "1234567890", 123456L, "F123", "Cardiologo");
            abmUsuario.agregar(profesional);
            System.out.println("Profesional agregado: " + profesional);

            // Crear un solicitante (Usuario)
            Solicitante solicitante = new Solicitante("María", "5432", "maria@example.com", 654321L,"Consulta medica");
            abmUsuario.agregar(solicitante);
            System.out.println("Solicitante agregado: " + solicitante);

            // Crear un servicio
            String nombreServicio = "Cardiología";
            int duracion = 30;
            boolean estado = true;
            LocalTime hora = LocalTime.of(10, 30);
            abmServicio.agregar(nombreServicio, duracion, estado, hora);
            System.out.println("Servicio agregado: " + nombreServicio);

            // Crear un turno y asociar profesional, servicio y solicitante
            int turnoId = abmTurno.agregar(
                    LocalDate.now(),
                    LocalTime.of(10, 30),
                    true,
                    abmServicio.traer(nombreServicio),
                    profesional,
                    solicitante

            );

            // Mostrar el turno creado
            Turno turno = abmTurno.traer(turnoId);
            System.out.println("\n=== Turno creado con Profesional, Servicio y Solicitante ===");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();  // 👈 (opcional) para ver la traza si falla
        }
    }
}
