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
}
