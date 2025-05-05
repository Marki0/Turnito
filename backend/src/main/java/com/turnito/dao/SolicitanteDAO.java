package com.turnito.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.turnito.modelo.Solicitante;

public class SolicitanteDAO {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(Solicitante objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public void actualizar(Solicitante objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public void eliminar(Solicitante objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
    }

    public Solicitante traer(int id) {
        Solicitante objeto = null;
        try {
            iniciaOperacion();
            objeto = (Solicitante) session.get(Solicitante.class, id);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Solicitante> traer() {
        List<Solicitante> lista = new ArrayList<Solicitante>();
        try {
            iniciaOperacion();
            Query<Solicitante> query = session.createQuery("from Solicitante s order by s.nombre asc",
                    Solicitante.class);
            lista = query.getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
}
