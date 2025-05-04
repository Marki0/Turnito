package com.turnito.modelo;

import java.util.Iterator;
import java.util.Set;

public class Profesional extends Usuario{
    private String especialidad;
    private String matricula;
    private Set<Servicio> servicios;
	
    public Profesional() {}

	public Profesional(String nombre, String email, String telefono, long dni, String especialidad, String matricula) {
		super(nombre, email, telefono, dni);
		this.especialidad = especialidad;
		this.matricula = matricula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	protected void setProfesionales(Set<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	@Override
	public String toString() {
		return "Profesional [especialidad=" + especialidad + ", matricula=" + matricula + "]";
	}
    
	public boolean agregar(Servicio servicio) {
		boolean agregar = false;
		if (!(servicios.contains(servicio))) {
			agregar = servicios.add(servicio);
		}
		return agregar;
	}

	public boolean eliminar(Servicio servicio) {
		Servicio borrar = null;
		boolean eliminar = false;
		Iterator<Servicio> it = servicios.iterator();
		while ((it.hasNext()) && (borrar == null)) {
			Servicio s = it.next();
			if (s.equals(servicio))
				borrar = s;
		}
		eliminar = servicios.remove(borrar);
		return eliminar;
	}
	
	public boolean modificar(Servicio servicio) {
		//TODO
		return true;
	}
	
    

    
    
}
