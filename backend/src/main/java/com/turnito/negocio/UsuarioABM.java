package com.turnito.negocio;

import com.turnito.dao.UsuarioDAO;
import com.turnito.modelo.Usuario;
import com.turnito.modelo.Administrador;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Profesional;

import java.util.List;

public class UsuarioABM {
    UsuarioDAO dao = new UsuarioDAO();

    public Usuario traer(int id) {
        return dao.traer(id);
    }

    public Usuario traerPorDni(long dni) {
        return dao.traerPorDni(dni);
    }

    public List<Usuario> traer() {
        return dao.traer();
    }

    // Método actualizado para manejar los atributos específicos de cada tipo de usuario
    public int agregar(String tipoUsuario, String nombre, String email, String telefono, long dni, String parametroExtra1, String parametroExtra2) throws Exception {
        Usuario usuario;

        switch (tipoUsuario.toUpperCase()) {
            case "ADMINISTRADOR":
                usuario = new Administrador(nombre, email, telefono, dni, parametroExtra1); // sector
                break;
            case "SOLICITANTE":
                usuario = new Solicitante(nombre, email, telefono, dni, parametroExtra1); // motivo
                break;
            case "PROFESIONAL":
                usuario = new Profesional(nombre, email, telefono, dni, parametroExtra1, parametroExtra2); // matricula, especialidad
                break;
            default:
                throw new Exception("Tipo de usuario no válido");
        }

        return dao.agregar(usuario);
    }


    public void eliminar(int id) throws Exception {
        Usuario usuario = dao.traer(id);
        if (usuario == null) {
            throw new Exception("Usuario no encontrado");
        }
        dao.eliminar(usuario);
    }
}
