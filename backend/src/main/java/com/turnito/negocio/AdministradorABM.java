package com.turnito.negocio;

import com.turnito.dao.AdministradorDAO;
import com.turnito.modelo.Administrador;

import java.util.List;

public class AdministradorABM extends UsuarioABM {
    private AdministradorDAO daoAdministrador = AdministradorDAO.getInstance();

    public Administrador traer(int id) {
        return daoAdministrador.traer(id);
    }



    public int agregar(String nombre, String email, String telefono, long dni, String sector) throws Exception {
        if (traerPorDni(dni) != null) {
            throw new Exception("Ya existe un usuario con ese DNI");
        }

        Administrador nuevo = new Administrador();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setTelefono(telefono);
        nuevo.setDni(dni);
        nuevo.setSector(sector);

        return daoAdministrador.agregar(nuevo);
    }

    public void eliminar(int id) throws Exception {
        Administrador administrador = daoAdministrador.traer(id);
        if (administrador == null) {
            throw new Exception("Administrador no encontrado");
        }
        daoAdministrador.eliminar(administrador);
    }
}
