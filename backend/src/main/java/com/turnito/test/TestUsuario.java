package com.turnito.test;

import com.turnito.modelo.Usuario;
import com.turnito.modelo.Administrador;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Profesional;
import com.turnito.negocio.UsuarioABM;

public class TestUsuario {
    public static void main(String[] args) {
        try {
            UsuarioABM abm = new UsuarioABM();

            // 1. Agregar un Administrador
            int idAdministrador = abm.agregar("ADMINISTRADOR", "Ana González", "ana@gmail.com", "1122334455", 12345678L, "IT", null);
            System.out.println("Administrador agregado con ID: " + idAdministrador);

            // 2. Agregar un Solicitante
            int idSolicitante = abm.agregar("SOLICITANTE", "Carlos García", "carlos@gmail.com", "2233445566", 87654321L, "Información sobre servicios", null);
            System.out.println("Solicitante agregado con ID: " + idSolicitante);

            // 3. Agregar un Profesional
            int idProfesional = abm.agregar("PROFESIONAL", "Dr. Luis Pérez", "luis@gmail.com", "3344556677", 99887766L, "12345", "Cardiología");
            System.out.println("Profesional agregado con ID: " + idProfesional);

            // 4. Traer Administrador por ID
            Usuario usuarioAdministrador = abm.traer(idAdministrador);
            if (usuarioAdministrador instanceof Administrador) {
                Administrador administrador = (Administrador) usuarioAdministrador;
                System.out.println("Administrador traído por ID: " + administrador.getNombre() + ", Sector: " + administrador.getSector());
            }

            // 5. Traer Solicitante por ID
            Usuario usuarioSolicitante = abm.traer(idSolicitante);
            if (usuarioSolicitante instanceof Solicitante) {
                Solicitante solicitante = (Solicitante) usuarioSolicitante;
                System.out.println("Solicitante traído por ID: " + solicitante.getNombre() + ", Motivo: " + solicitante.getMotivo());
            }

            // 6. Traer Profesional por ID
            Usuario usuarioProfesional = abm.traer(idProfesional);
            if (usuarioProfesional instanceof Profesional) {
                Profesional profesional = (Profesional) usuarioProfesional;
                System.out.println("Profesional traído por ID: " + profesional.getNombre() + ", Especialidad: " + profesional.getEspecialidad());
            }

            // 7. Traer usuario por DNI (Ejemplo para un Profesional)
            Usuario usuarioPorDni = abm.traerPorDni(99887766L);
            System.out.println("Usuario traído por DNI: " + usuarioPorDni.getNombre() + ", Email: " + usuarioPorDni.getEmail());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
