package com.turnito.negocio;

import com.turnito.dao.ServicioDAO;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;

import java.time.LocalTime;
import java.util.List;

public class ServicioABM {
	ServicioDAO dao = new ServicioDAO();

	public Servicio traer(int id) {
		return dao.traer(id);
	}

	public Servicio traer(String nombre) {
		return dao.traer(nombre);
	}

	public Servicio traer(String nombre, LocalTime horario){
		return dao.traer(nombre, horario);
	}

	public List<Servicio> traer() {
		return dao.traer();
	}

	public int agregar(String nombre, int duracion, boolean estado, LocalTime horario) throws Exception {
		if (traer(nombre, horario) != null) {
			throw new Exception("El servicio ya existe en ese horario");
		}

		return dao.agregar(new Servicio(nombre, duracion, estado, horario));
	}

	public void modificar(Servicio servicio) throws Exception {
		Servicio existente = dao.traer(servicio.getId());

		if (existente == null) {
			throw new Exception("Servicio no encontrado");
		}

		Servicio duplicado = dao.traer(servicio.getNombre(), servicio.getHorario());
		if (duplicado != null && duplicado.getId() != servicio.getId()) {
			throw new Exception("Ya existe otro servicio con ese nombre y horario");
		}
		existente.setNombre(servicio.getNombre());
		existente.setDuracion(servicio.getDuracion());
		existente.setEstado(servicio.isEstado());
		existente.setHorario(servicio.getHorario());

		dao.actualizar(existente);
	}

	public void eliminar(Servicio s) throws Exception {
		if (s == null) {
			throw new Exception("Servicio no encontrado");
		}

		dao.eliminar(s);
	}
	
	public boolean agregarProfesional(int id,Profesional profesional)throws Exception {
		Servicio s = dao.traer(id);
		if ((s.getProfesionales().contains(profesional))) {
			throw new Exception("El profesional ya existe en el servicio");
		}
		return dao.agregarProfesional(s, profesional);
	}
	
	public boolean eliminarProfesional(int id, Profesional profesional) throws Exception {
		Servicio s = dao.traer(id);
		if(!s.getProfesionales().contains(profesional)) {
			throw new Exception("El profesional a eliminar no existe en el servicio");
		}
		
		return dao.eliminarProfesional(s, profesional);
	}

	public Servicio traerServicioYProfesionales(int id) {
		return dao.traerServicioYProfesionales(id);
	}
}
