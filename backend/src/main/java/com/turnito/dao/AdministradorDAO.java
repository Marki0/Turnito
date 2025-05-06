package com.turnito.dao;

import com.turnito.modelo.Administrador;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdministradorDAO {
    private static Session session;
    private Transaction tx;
    private static AdministradorDAO instancia = null; // Singleton

    public AdministradorDAO() {
    }

    public static AdministradorDAO getInstance() {
        if (instancia == null)
            instancia = new AdministradorDAO();
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

    public Administrador traer(int id) {
        Administrador objeto = null;
        try {
            iniciaOperacion();
            objeto = session.get(Administrador.class, id);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Administrador> traer() {
        List<Administrador> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Administrador", Administrador.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public int agregar(Administrador nuevo) {
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

    public void actualizar(Administrador objeto) {
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

    public void eliminar(Administrador objeto) {
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
