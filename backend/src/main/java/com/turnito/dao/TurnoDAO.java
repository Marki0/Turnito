package com.turnito.dao;

import com.turnito.modelo.Turno;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.turnito.modelo.Solicitante;

import java.util.List;

public class TurnoDAO {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        he.printStackTrace(); // Imprime el stack trace para depuración
        throw new HibernateException("ERROR en la capa de acceso a datos: " + he.getMessage(), he);
    }

    public Turno traer(int id) {
        Turno turno = null;
        try {
            iniciaOperacion();
            turno = session.get(Turno.class, id);
        } finally {
            session.close();
        }
        return turno;
    }

    public List<Turno> traer() {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno", Turno.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public int agregar(Turno turno) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(turno).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }
    public List<Turno> traerPorSolicitante(Solicitante solicitante) {
        List<Turno> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Turno t where t.solicitante = :solicitante", Turno.class)
                    .setParameter("solicitante", solicitante)
                    .list();
        } finally {
            session.close();
        }
        return lista;
    }
    public void actualizar(Turno turno) {
        try {
            iniciaOperacion();
            session.update(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Turno turno) {
        try {
            iniciaOperacion();
            session.delete(turno);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }
}