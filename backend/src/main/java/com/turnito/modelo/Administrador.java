package com.turnito.modelo;
import javax.persistence.*;

<<<<<<< HEAD
@Entity
@Table(name = "Administrador")
@PrimaryKeyJoinColumn(name = "ID")
public class Administrador extends Usuario {
    private String sector;

	public Administrador() {}
	public Administrador(String nombre, String email, String telefono, long dni, String sector) {
		super(nombre, email, telefono, dni);
		this.sector = sector;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	@Override
	public String toString() {
		return "Administrador [" + super.toString()+ "sector=" + sector + "]";
	}
	
=======
public class Administrador extends Usuario {
    private String sector;

    public Administrador() {}

    public Administrador(String nombre, String email, String telefono, long dni, String sector) {
        super(nombre, email, telefono, dni);
        this.sector = sector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Getters y setters
>>>>>>> f531b9040f1ed23ee11bca5ca6644bbbf515b0ef
}
