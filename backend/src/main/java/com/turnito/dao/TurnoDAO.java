package com.turnito.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.turnito.dao.HibernateUtil;
import com.turnito.modelo.Profesional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.turnito.modelo.Turno;

public class TurnoDAO {
    private static Session session;
    private Transaction tx;
    private static TurnoDAO instancia = null; // Patrón Singleton

    public TurnoDAO() {
    }

    public static TurnoDAO getInstance() {
        if (instancia == null)
            instancia = new TurnoDAO();
        return instancia;
    }

    protected void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    // Traer Turno por ID (con profesional, solicitante y servicio cargados)
    public Turno traer(int idTurno) {
        Turno objeto = null;
        try {
            iniciaOperacion();

            objeto = session.createQuery(
                            "from Turno t "
                                    + "join fetch t.profesional "
                                    + "join fetch t.solicitante "
                                    + "join fetch t.servicio "
                                    + "where t.Id = :idTurno", Turno.class)
                    .setParameter("idTurno", idTurno)
                    .uniqueResult();

        } finally {
            session.close();
        }
        return objeto;
    }

    // Traer todos los turnos (con relaciones cargadas)
    public List<Turno> traer() throws HibernateException {
        List<Turno> lista = null;
        try {
            iniciaOperacion();

            lista = session.createQuery(
                            "from Turno t "
                                    + "join fetch t.profesional "
                                    + "join fetch t.solicitante "
                                    + "join fetch t.servicio", Turno.class)
                    .list();

        } finally {
            session.close();
        }
        return lista;
    }

    // Actualizar turno
    public void actualizar(Turno turno) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // Eliminar turno
    public void eliminar(Turno turno) throws HibernateException {
        try {
            iniciaOperacion();
            session.delete(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public Turno traerPorFechaHoraYProfesional(LocalDate fecha, LocalTime hora, Profesional profesional) {
        Turno objeto = null;
        try {
            iniciaOperacion();
            objeto = session.createQuery(
                            "from Turno t "
                                    + "join fetch t.profesional "
                                    + "where t.fecha = :fecha and t.hora = :hora and t.profesional = :profesional", Turno.class)
                    .setParameter("fecha", fecha)
                    .setParameter("hora", hora)
                    .setParameter("profesional", profesional)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    public int agregar(Turno nuevo) {
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(nuevo);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }
}
