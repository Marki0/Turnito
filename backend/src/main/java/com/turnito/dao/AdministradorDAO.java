package com.turnito.dao;

import com.turnito.modelo.Administrador;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class AdministradorDAO {
	
	private Session session;
    private Transaction tx;

    // Inicia la operacion y obtiene la sesion
    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    // Maneja las excepciones y revierte la transaccion si es necesario
    private void manejaExcepcion(HibernateException he) {
        if (tx != null) {
            tx.rollback();  // Revertir la transaccion en caso de error
        }
        throw new RuntimeException("Error en la operación de Hibernate", he);
    }
    
    // AGREGAR ADMIN
    public int agregar(Administrador administrador) {
    	int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(administrador).toString());  // En caso de que no exista lo guardamos
            tx.commit();  // Confirmamos la transaccion
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();  // Cerramos la sesion
        }
        return id;  // Devolvemos el ID del Administrador insertado
    }
    
    // TRAER ADMIN POR ID
    public Administrador traer(int id) {
    	Administrador administrador = null;
        try {
            iniciaOperacion();
            administrador = (Administrador) session.get(Administrador.class, id);  // Buscamos por ID
        } finally {
            session.close();  // Cerramos la sesion
        }
        return administrador;  // Devolvemos el objeto encontrado
    }
    
    // TRAEMOS ADMIN POR NOMBRE 
    public Administrador traer(String nombre) {
        Administrador administrador = null;
        try {
            iniciaOperacion();
            administrador = (Administrador) session.createQuery("from Administrador a where a.nombre = :nombre")
                    .setParameter("nombre", nombre)  // Buscamos por nombre
                    .uniqueResult();
        } finally {
            session.close();  // Cerramos la sesion
        }
        return administrador;  // Devolvemos el Administrador encontrado
    }
    
    // BUSCAMOS POR NOMBRE Y SECTOR
    public Administrador traer(String nombre, String sector) {
        Administrador administrador = null;
        try {
            iniciaOperacion();
            administrador = (Administrador) session.createQuery("from Administrador a where a.nombre = :nombre and a.sector = :sector")
                    .setParameter("nombre", nombre)
                    .setParameter("sector", sector)  // Buscamos por nombre y sector
                    .uniqueResult();
        } finally {
            session.close();  // Cerramos la sesion
        }
        return administrador;  // Devolvemos el Administrador encontrado
    }
    
    // Metodo para actualizar admin
    public void actualizar(Administrador administrador) {
        try {
            iniciaOperacion();
            session.update(administrador);  // Actualizamos el objeto
            tx.commit();  // Confirmamos la transaccion
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();  // Cerramos la sesion
        }
    }
    
    // Metodo para borrar admin
    public void eliminar(Administrador administrador) {
        try {
            iniciaOperacion();
            session.delete(administrador);  // Eliminamos el objeto
            tx.commit();  // Confirmamos la transaccion
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();  // Cerramos la sesion
        }
    }
}
