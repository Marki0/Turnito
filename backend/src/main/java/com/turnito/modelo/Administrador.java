package com.turnito.modelo;

public class Administrador extends Usuario {
    private String sector;

    public Administrador() {}

    @Override
    public String toString() {
        return "Administrador{" +
                "sector='" + sector + '\'' +
                '}';
    }

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
