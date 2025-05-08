package com.turnito.dao;

import com.turnito.modelo.Administrador;
<<<<<<< HEAD

import java.util.List;

=======
>>>>>>> f531b9040f1ed23ee11bca5ca6644bbbf515b0ef
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

<<<<<<< HEAD


public class AdministradorDAO {
	
	private Session session;
    private Transaction tx;

    // Inicia la operacion y obtiene la sesion
    private void iniciaOperacion() {
=======
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
>>>>>>> f531b9040f1ed23ee11bca5ca6644bbbf515b0ef
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> f531b9040f1ed23ee11bca5ca6644bbbf515b0ef
        }
    }
}
