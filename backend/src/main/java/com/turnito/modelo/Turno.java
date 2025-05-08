package com.turnito.modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate fecha;
    private LocalTime hora;
    private boolean estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idServicio")
    private Servicio servicio;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesional_id") // columna FK en tu tabla turnos
    private Profesional profesional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solicitante_id") // columna FK en tu tabla turnos
    private Solicitante solicitante;

    public Turno() {}

    public Turno(LocalDate fecha, LocalTime hora, boolean estado, Servicio servicio, Profesional profesional, Solicitante solicitante) {
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.servicio = servicio;
        this.profesional = profesional;
        this.solicitante = solicitante;
    }


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

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
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
                ", servicio=" + servicio +
                ", profesional=" + profesional +
                ", solicitante=" + solicitante +
                '}';
    }

}
