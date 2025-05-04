package com.turnito.negocio;

import java.util.List;
import com.turnito.dao.AdministradorDAO;
import com.turnito.modelo.Administrador;

public class AdministradorABM {
	private AdministradorDAO dao = new AdministradorDAO();

	public Administrador traer(int id) {
		return dao.traer(id);
	}

	// Traer por nombre
    public Administrador traer(String nombre) {
        return dao.traer(nombre);
    }

    // Traer por correo
    public Administrador traerPorCorreo(String email) {
        return dao.traerPorCorreo(email);
    }

    // Traer por nombre y sector
    public List<Administrador> traerPorSector(String sector) {
        return dao.traerPorSector(sector);
    }

	public List<Administrador> traer() {
		return dao.traer();
	}
	// Agregamos un admin
	public int agregar(String nombre, String email, String telefono, long dni, String sector) throws Exception {
		if (traer(email) != null) {
			throw new Exception("Ya existe un administrador con ese email.");
		}
		Administrador admin = new Administrador(nombre, email, telefono, dni, sector);
		return dao.agregar(admin);
	}

	// Modificar un Administrador existente
    public void modificar(Administrador admin) throws Exception {
        // Verificar si el administrador existe
        Administrador existente = dao.traer(admin.getId());
        if (existente == null) {
            throw new Exception("Administrador no encontrado con ID: " + admin.getId());
        }

        // Verificar si ya existe otro administrador con el mismo email
        Administrador duplicado = dao.traer(admin.getEmail());
        if (duplicado != null && duplicado.getId() != admin.getId()) {
            throw new Exception("Ya existe otro administrador con ese email.");
        }

        // Actualizar los datos del administrador
        existente.setNombre(admin.getNombre());
        existente.setEmail(admin.getEmail());
        existente.setTelefono(admin.getTelefono());
        existente.setDni(admin.getDni());
        existente.setSector(admin.getSector());

        dao.actualizar(existente);  // Actualizar en la base de datos
    }

	public void eliminar(int id) throws Exception {
		Administrador admin = dao.traer(id);
		if (admin == null) {
			throw new Exception("Administrador no encontrado.");
		}
		dao.eliminar(admin);
	}
}
