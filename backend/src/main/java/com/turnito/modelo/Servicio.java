package com.turnito.modelo;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.turnito.negocio.ServicioABM;
import com.turnito.negocio.UsuarioABM;

public class Servicio {
	private int id;
	private String nombre;
	private int duracion;
	private boolean estado;
	private LocalTime horario;
	private Set<Profesional> profesionales;

	public Servicio() {
		super();
	}

	public Servicio(String nombre, int duracion, boolean estado, LocalTime horario) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.estado = estado;
		this.horario = horario;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Set<Profesional> getProfesionales() {
		return profesionales;
	}

	protected void setProfesionales(Set<Profesional> profesionales) {
		this.profesionales = profesionales;
	}

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre= " + nombre + ", duracion=" + duracion + ", estado=" + estado
				+ ", horario=" + horario + ", profesionales=\n" + profesionales + "]";
	}

	public boolean agregar(Profesional profesional) throws Exception {
		ServicioABM abmServicio = new ServicioABM();
		if (profesional == null) {
			throw new Exception("El profesional no existe");
		}
		return abmServicio.agregarProfesional(id, profesional);
	}

	public boolean eliminar(Profesional profesional) throws Exception {
		ServicioABM abmServicio = new ServicioABM();
		if (profesional == null) {
			throw new Exception("El profesional no existe");
		}
		return abmServicio.eliminarProfesional(id,profesional);
	}


	public Servicio traerServicioYProfesionales(Servicio s) throws Exception{
		ServicioABM abmServicio = new ServicioABM();
		if (abmServicio.traer(s.getId()) == null || s == null) {
			throw new Exception("Servicio invalido");
		}
		return abmServicio.traerServicioYProfesionales(s.getId());
	}


	
	
}
