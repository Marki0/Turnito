package com.turnito.negocio;

import com.turnito.dao.ProfesionalDAO;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;

import java.util.List;

public class ProfesionalABM extends UsuarioABM {
    private ProfesionalDAO daoProfesional = ProfesionalDAO.getInstance();

    public Profesional traer(int id) {
        return daoProfesional.traer(id);
    }

    public int agregar(String nombre, String email, String telefono, long dni, String matricula, String especialidad) throws Exception {
        if (traerPorDni(dni) != null) {
            throw new Exception("Ya existe un usuario con ese DNI ");
        }

        Profesional nuevo = new Profesional();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setTelefono(telefono);
        nuevo.setDni(dni);
        nuevo.setMatricula(matricula);
        nuevo.setEspecialidad(especialidad);

        return daoProfesional.agregar(nuevo);
    }

    public void eliminar(int id) throws Exception {
        Profesional profesional = daoProfesional.traer(id);
        if (profesional == null) {
            throw new Exception("Profesional no encontrado ");
        }
        daoProfesional.eliminar(profesional);
    }
    
	public void modificar(Profesional profesional) throws Exception {
		Profesional existente = (Profesional) dao.traerPorDni(profesional.getDni());

		if (existente == null) {
			throw new Exception("Profesional no encontrado");
		}

		existente.setEspecialidad(profesional.getEspecialidad());
		existente.setMatricula(profesional.getMatricula());
		

		dao.actualizar(existente);
	}
}
