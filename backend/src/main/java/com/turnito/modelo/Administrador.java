package com.turnito.modelo;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ADMINISTRADOR")
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
}
