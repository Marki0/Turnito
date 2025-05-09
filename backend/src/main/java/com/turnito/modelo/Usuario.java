package com.turnito.modelo;

import java.util.Objects;

public abstract class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String telefono;
	private long dni;

	// Getters y setters

	public Usuario() {}

	public Usuario(String nombre, String email, String telefono, long dni) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre= " + nombre + ", email=" + email + ", telefono=" + telefono + ", dni="
				+ dni + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return dni == other.dni;
	}

	
	// Métodos comunes
	
}
