package com.turnito.dao;

import com.turnito.modelo.Administrador;

import java.util.List;

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
            // Devuelve el ID generado automaticamente
            id = (int) session.save(administrador);  // El ID es generado automaticamente
            tx.commit();  // Confirmamos la transaccion
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();  // Cerramos la sesion
        }
        return id;  // Devolvemos el ID generado por Hibernate
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
    
    // Traemos segun el correo
    public Administrador traerPorCorreo(String email) {
        Administrador administrador = null;
        try {
            iniciaOperacion();
            administrador = (Administrador) session.createQuery("from Administrador a where a.email = :email")
                    .setParameter("email", email)  // Buscamos por correo
                    .uniqueResult();
        } finally {
            session.close();  // Cerramos la sesión
        }
        return administrador;  // Devolvemos el Administrador encontrado
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
    
    // BUSCAMOS SECTOR
    public List<Administrador> traerPorSector(String sector) {
        List<Administrador> administradores = null;
        try {
            iniciaOperacion();
            administradores = session.createQuery("from Administrador a where a.sector = :sector", Administrador.class)
                    .setParameter("sector", sector)
                    .list();
        } finally {
            session.close();
        }
        return administradores;
    }

    
 // TRAER TODOS LOS ADMINISTRADORES
    public List<Administrador> traer() {
        List<Administrador> administradores = null;
        try {
            iniciaOperacion();
            administradores = session.createQuery("from Administrador", Administrador.class).list(); // Consulta todos los administradores
        } finally {
            session.close();
        }
        return administradores; // Devuelve la lista de administradores
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
