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
            // Agregar Profesional
            Profesional profesional = new Profesional("Carlos", "2345", "1234567890", 123456L, "F123", "Cardiologo");
            abmUsuario.agregar(profesional);
            System.out.println("Profesional agregado: " + profesional);

            // Agregar Solicitante
            Solicitante solicitante = new Solicitante("María", "5432", "maria@example.com", 654321L, "Consulta médica");
            abmUsuario.agregar(solicitante);
            System.out.println("Solicitante agregado: " + solicitante);

            // Agregar Servicio
            String nombreServicio = "Cardiología";
            int duracion = 30;
            boolean estado = true;
            LocalTime hora = LocalTime.of(10, 30);
            abmServicio.agregar(nombreServicio, duracion, estado, hora);
            System.out.println("Servicio agregado: " + nombreServicio);

            // Traer Servicio para asociar
            Servicio servicio = abmServicio.traer(nombreServicio);

            // Agregar Turno
            int turnoId = abmTurno.agregar(
                    LocalDate.now(),
                    LocalTime.of(10, 30),
                    true,
                    servicio,
                    profesional,
                    solicitante
            );
            System.out.println("\nTurno agregado con ID: " + turnoId);

            // Mostrar Turno creado
            Turno turno = abmTurno.traer(turnoId);


            // Modificar Turno (cambio de horario)
            System.out.println("\nModificando turno...");
            turno.setHora(LocalTime.of(11, 0));
            abmTurno.modificar(turno);
            System.out.println("Turno modificado: " + abmTurno.traer(turnoId));

            // Intentar eliminar Turno
            System.out.println("\nEliminando turno...");
            abmTurno.eliminar(turno.getId());
            System.out.println("Turno eliminado con éxito");

            // Intentar traer el turno eliminado (debería fallar o devolver null)
            System.out.println("\nBuscando turno eliminado...");
            Turno turnoEliminado = abmTurno.traer(turnoId);
            System.out.println("Resultado: " + turnoEliminado);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();  // Opcional: para depuración
        }
    }
}
