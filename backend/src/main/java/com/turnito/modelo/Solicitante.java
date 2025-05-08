package com.turnito.modelo;

public class Solicitante extends Usuario {
    private String motivo;

    public Solicitante() {}

    public Solicitante(String nombre, String email, String telefono, long dni, String motivo) {
        super(nombre, email, telefono, dni);
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "motivo='" + motivo + '\'' +
                '}';
    }

    // Getters y setters
}
