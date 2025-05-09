package com.turnito.negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.turnito.dao.TurnoDAO;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Turno;

public class TurnoABM {
    TurnoDAO dao = new TurnoDAO();

    public Turno traer(int id) {
        return dao.traer(id);
    }

    public List<Turno> traer() {
        return dao.traer();
    }

    public List<Turno> traerPorSolicitante(Solicitante solicitante) {
        return dao.traerPorSolicitante(solicitante);
    }

    public int agregar(LocalDate fecha, LocalTime hora, boolean estado, Servicio servicio, Profesional profesional, Solicitante solicitante) throws Exception {
        // Ejemplo de regla: no permitir turno duplicado para el mismo solicitante, fecha y hora
        List<Turno> existentes = dao.traerPorSolicitante(solicitante);
        for (Turno t : existentes) {
            if (t.getFecha().equals(fecha) && t.getHora().equals(hora)) {
                throw new Exception("Ya existe un turno para ese solicitante en la fecha y hora indicada ");
            }
        }

        Turno nuevo = new Turno(fecha, hora, estado, servicio, profesional, solicitante);
        return dao.agregar(nuevo);
    }

    public void modificar(Turno turno) throws Exception {
        Turno existente = dao.traer(turno.getId());

        if (existente == null) {
            throw new Exception("Turno no encontrado");
        }

        existente.setFecha(turno.getFecha());
        existente.setHora(turno.getHora());
        existente.setEstado(turno.isEstado());
        existente.setServicio(turno.getServicio());
        existente.setProfesional(turno.getProfesional());
        existente.setSolicitante(turno.getSolicitante());

        dao.actualizar(existente);
    }

    public void eliminar(int id) throws Exception {
        Turno turno = dao.traer(id);
        if (turno == null) {
            throw new Exception("Turno no encontrado");
        }
        dao.eliminar(turno);
    }
}
