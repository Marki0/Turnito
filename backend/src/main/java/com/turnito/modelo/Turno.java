package com.turnito.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private int Id;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean estado;
    private String direccion;
    private int profesional_id;
    private int servicio_id;
    private int solicitante_id;


    public Turno(int id, LocalDate fecha, LocalTime hora, boolean estado, String direccion,int profesional_id,int servicio_id,int solicitante_id) {
        Id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.direccion = direccion;
        this.profesional_id = profesional_id;
        this.servicio_id = servicio_id;
        this.solicitante_id = solicitante_id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public int getProfesional_id() {
        return profesional_id;
    }

    public void setProfesional_id(int profesional_id) {
        this.profesional_id = profesional_id;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getSolicitante_id() {
        return solicitante_id;
    }

    public void setSolicitante_id(int solicitante_id) {
        this.solicitante_id = solicitante_id;
    }


}


