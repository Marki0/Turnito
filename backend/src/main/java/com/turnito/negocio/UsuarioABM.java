package com.turnito.negocio;

import com.turnito.dao.UsuarioDAO;
import com.turnito.modelo.Usuario;
import com.turnito.modelo.Administrador;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;

import java.util.List;

public class UsuarioABM {
	UsuarioDAO dao = new UsuarioDAO();

	public Usuario traer(int id) {
		return dao.traer(id);
	}

	public Usuario traerPorDni(long dni) throws Exception{
		return dao.traerPorDni(dni);
	}

	public List<Usuario> traer() {
		return dao.traer();
	}

	// Método actualizado para manejar los atributos específicos de cada tipo de
	// usuario
	public int agregar(Usuario usuario) throws Exception {
		if (traerPorDni(usuario.getDni()) != null) {
			throw new Exception("Ya existe un usuario");
		}
		return dao.agregar(usuario);
	}
	
	public void modificar(Usuario usuario) throws Exception {
		Usuario existente = dao.traerPorDni(usuario.getDni());

		if (existente == null) {
			throw new Exception("Usuario invalido");
		}
		
		existente.setEmail(usuario.getEmail());
		existente.setNombre(usuario.getNombre());
		existente.setTelefono(usuario.getTelefono());

		dao.actualizar(existente);
	}

	public void eliminar(Usuario usuario) throws Exception {
		if (usuario == null) {
			throw new Exception("Usuario invalido");
		};
		dao.eliminar(usuario);
	}
}
