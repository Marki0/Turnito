package com.turnito.dao;

import com.turnito.modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAO {
    public static Session session;
    private Transaction tx;
    private static UsuarioDAO instancia = null; // Patrón Singleton

    public UsuarioDAO() {
    }

    public static UsuarioDAO getInstance() {
        if (instancia == null)
            instancia = new UsuarioDAO();

        return instancia;
    }

    public void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException {
        if (tx != null) tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    // Traer Usuario por ID
    public Usuario traer(int id) {
        Usuario objeto = null;
        try {
        	iniciaOperacion();
        	objeto = (Usuario) session.createQuery("from Usuario u where u.id=:id")
        	.setParameter("id", id).uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }

    // Traer todos los usuarios
    public List<Usuario> traer() throws HibernateException {
        List<Usuario> lista = null;
        try {
            iniciaOperacion();
            lista = session.createQuery("from Usuario", Usuario.class).list();
        } finally {
            session.close();
        }
        return lista;
    }

    // Agregar usuario
    public int agregar(Usuario nuevo) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(nuevo).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    // Actualizar usuario
    public void actualizar(Usuario usuario) throws HibernateException {
        try {
            iniciaOperacion();
            session.update(usuario);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // Eliminar usuario
    public void eliminar(Usuario usuario) throws HibernateException {
        try {
            iniciaOperacion();
            session.delete(usuario);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    // Traer Usuario por DNI
    public Usuario traerPorDni(long dni) {
        Usuario objeto = null;
        try {
            iniciaOperacion();
            objeto = session.createQuery(
                            "from Usuario u where u.dni = :dni", Usuario.class)
                    .setParameter("dni", dni)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return objeto;
    }
}
