package com.turnito.modelo;

public class Profesional extends Usuario {
	private String matricula;
	private String especialidad;

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
	
	// Getters y setters
}
