package com.turnito.dao;

import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProfesionalDAO {
    private static Session session;
    private Transaction tx;
    private static ProfesionalDAO instancia = null;

    public static ProfesionalDAO getInstance() {
        if (instancia == null)
            instancia = new ProfesionalDAO();
        return instancia;
    }

    protected void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en DAO Profesional", he);
    }

	public Profesional traer(int id) {
		Profesional objeto = null;
		try {
			iniciaOperacion();
			objeto = (Profesional) session.get(Profesional.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}

    public List<Profesional> traerTodos() {
        List<Profesional> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Profesional", Profesional.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    public int agregar(Profesional nuevo) {
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

    public void actualizar(Profesional profesional) {
        try {
            iniciaOperacion();
            session.update(profesional);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminar(Profesional profesional) {
        try {
            iniciaOperacion();
            session.delete(profesional);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}
