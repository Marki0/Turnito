package com.turnito.dao;

import com.turnito.modelo.Solicitante;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SolicitanteDAO {
    private static Session session;
    private Transaction tx;
    private static SolicitanteDAO instancia = null; // Singleton

    public SolicitanteDAO() {
    }

    public static SolicitanteDAO getInstance() {
        if (instancia == null)
            instancia = new SolicitanteDAO();
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

    public Solicitante traer(int id) {
        Solicitante objeto = null;
        try {
            iniciaOperacion();
            objeto = session.get(Solicitante.class, id);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Solicitante> traer() {
        List<Solicitante> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Solicitante", Solicitante.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public int agregar(Solicitante nuevo) {
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

    public void actualizar(Solicitante objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
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
            throw he;
        } finally {
            session.close();
        }
    }
}
