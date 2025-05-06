package com.turnito.dao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.turnito.modelo.Profesional;
import com.turnito.modelo.Servicio;


public class ServicioDAO {
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

	public int agregar(Servicio objeto) {
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
	
	public boolean agregarProfesional(Servicio servicio, Profesional profesional) {
	    try {
	        iniciaOperacion();
	        servicio.getProfesionales().add(profesional);  // agregás el profesional a la colección
	        session.update(servicio);                       // persistís la relación en la base
	        tx.commit();
	        return true;
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	        throw he;
	    } finally {
	        session.close();
	    }
	}
	

	public void actualizar(Servicio objeto) {
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

	public void eliminar(Servicio objeto) {
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

	public Servicio traer(int id) {
		Servicio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Servicio) session.get(Servicio.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Servicio traer(String nombre) {
		Servicio servicio = null;
		try {
			iniciaOperacion();
			servicio = (Servicio) session.createQuery("from Servicio s where s.nombre = :nombre")
					.setParameter("nombre", nombre)
					.uniqueResult();
		} finally {
			session.close();
		}
		return servicio;
	}
	
	public Servicio traer(String nombre, LocalTime horario) {
	    Servicio servicio = null;
	    try {
	        iniciaOperacion();
	        servicio = (Servicio) session
	            .createQuery("from Servicio s where s.nombre = :nombre and s.horario = :horario")
	            .setParameter("nombre", nombre)
	            .setParameter("horario", horario)
	            .uniqueResult();
	    } finally {
	        session.close();
	    }
	    return servicio;
	}


	public List<Servicio> traer() {
		List<Servicio> lista = new ArrayList<Servicio>();
		try {
			iniciaOperacion();
			Query<Servicio> query = session.createQuery("from Servicio s order by s.nombre asc",
					Servicio.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}
}
