package com.turnito.modelo;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.Set;

import com.turnito.negocio.ServicioABM;

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
		return "Servicio [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", estado=" + estado
				+ ", horario=" + horario + "]";
	}
	
	public boolean agregar(Profesional profesional) throws Exception {
		ServicioABM abm = new ServicioABM();
		return abm.agregarProfesional(id, profesional);
	}

	public boolean eliminar(Profesional profesional) {
		Profesional borrar = null;
		boolean eliminar = false;
		Iterator<Profesional> it = profesionales.iterator();
		while ((it.hasNext()) && (borrar == null)) {
			Profesional p = it.next();
			if (p.equals(profesional))
				borrar = p;
		}
		eliminar = profesionales.remove(borrar);
		return eliminar;
	}
	
	public boolean modificar(Profesional profesional) {
		//TODO
		return true;
	}

}
