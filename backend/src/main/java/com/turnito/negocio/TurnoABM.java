package com.turnito.negocio;

import com.turnito.dao.TurnoDAO;
import com.turnito.modelo.Turno;
import com.turnito.modelo.Profesional;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TurnoABM {
    TurnoDAO dao = new TurnoDAO();

    public Turno traer(int id) {
        return dao.traer(id);
    }

    public List<Turno> traer() {
        return dao.traer();
    }

    public int agregar(LocalDate fecha, LocalTime hora, boolean estado, String direccion,
                       Profesional profesional, Servicio servicio, Solicitante solicitante) throws Exception {

        // Validación: no permitir turno duplicado en misma fecha/hora para mismo profesional
        Turno existente = dao.traerPorFechaHoraYProfesional(fecha, hora, profesional);
        if (existente != null) {
            throw new Exception("Ya existe un turno para este profesional en esa fecha y hora");
        }

        return dao.agregar(new Turno(fecha, hora, estado, direccion, profesional, servicio, solicitante));
    }

    public void modificar(Turno turno) throws Exception {
        Turno existente = dao.traer(turno.getId());

        if (existente == null) {
            throw new Exception("Turno no encontrado");
        }

        Turno duplicado = dao.traerPorFechaHoraYProfesional(turno.getFecha(), turno.getHora(), turno.getProfesional());
        if (duplicado != null && duplicado.getId() != turno.getId()) {
            throw new Exception("Ya existe otro turno con ese profesional en esa fecha y hora");
        }

        existente.setFecha(turno.getFecha());
        existente.setHora(turno.getHora());
        existente.setEstado(turno.isEstado());
        existente.setDireccion(turno.getDireccion());
        existente.setProfesional(turno.getProfesional());
        existente.setServicio(turno.getServicio());
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
