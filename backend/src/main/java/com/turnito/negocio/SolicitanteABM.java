package com.turnito.negocio;

import com.turnito.dao.SolicitanteDAO;
import com.turnito.modelo.Solicitante;

import java.util.List;

public class SolicitanteABM extends UsuarioABM {
    private SolicitanteDAO daoSolicitante = SolicitanteDAO.getInstance();

    public Solicitante traer(int id) {
        return daoSolicitante.traer(id);
    }



    public int agregar(String nombre, String email, String telefono, long dni, String motivo) throws Exception {
        if (traerPorDni(dni) != null) {
            throw new Exception("Ya existe un usuario con ese DNI ");
        }

        Solicitante nuevo = new Solicitante();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setTelefono(telefono);
        nuevo.setDni(dni);
        nuevo.setMotivo(motivo);

        return daoSolicitante.agregar(nuevo);
    }

    public void eliminar(int id) throws Exception {
        Solicitante solicitante = daoSolicitante.traer(id);
        if (solicitante == null) {
            throw new Exception("Solicitante no encontrado");
        }
        daoSolicitante.eliminar(solicitante);
    }
}
