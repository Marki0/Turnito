package com.turnito.modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private long Dni;

	public Usuario() {
		// Constructor vacío necesario para Hibernate
	}
	public Usuario(int id, String nombre, String email, String telefono, long dni) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		Dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public long getDni() {
		return Dni;
	}

	public void setDni(long dni) {
		Dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
