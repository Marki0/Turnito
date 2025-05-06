package com.turnito.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;

@Entity
public class Turno {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean estado;
    private String direccion;

    // Relacionados como objetos
    private Profesional profesional;
    private Servicio servicio;
    private Solicitante solicitante;

    public Turno() {
        // Constructor vacío necesario para Hibernate
    }

    public Turno(LocalDate fecha, LocalTime hora, boolean estado, String direccion,
                 Profesional profesional, Servicio servicio, Solicitante solicitante) {

        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.direccion = direccion;
        this.profesional = profesional;
        this.servicio = servicio;
        this.solicitante = solicitante;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado=" + estado +
                ", direccion='" + direccion + '\'' +
                ", profesional=" + profesional +
                ", servicio=" + servicio +
                ", solicitante=" + solicitante +
                '}';
    }
}
