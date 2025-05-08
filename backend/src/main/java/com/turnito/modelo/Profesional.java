package com.turnito.modelo;

import java.util.Set;

public class Profesional extends Usuario {
	private String matricula;
	private String especialidad;
	private Set<Servicio> servicios;

	public Profesional() {}

	public Profesional(String nombre, String email, String telefono, long dni, String matricula, String especialidad) {
		super(nombre, email, telefono, dni);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Profesional [matricula=" + matricula + ", especialidad=" + especialidad + "]";
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	protected void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	// Getters y setters
}
