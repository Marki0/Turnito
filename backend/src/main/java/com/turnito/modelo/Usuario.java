package com.turnito.modelo;
import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String nombre;
    private String email;
    private String telefono;
    private long Dni;
    
	public Usuario() {
		super();
	}
	public Usuario(String nombre, String email, String telefono, long dni) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		Dni = dni;
	}
	public int getId() {
		return Id;
	}
	protected void setId(int id) {
		Id = id;
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
		return Dni;
	}
	public void setDni(long dni) {
		Dni = dni;
	}
	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", Dni="
				+ Dni + "]";
	}
    
    
}
