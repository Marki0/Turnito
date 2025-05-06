package com.turnito.test;

import com.turnito.modelo.Usuario;
import com.turnito.modelo.Administrador;
import com.turnito.modelo.Solicitante;
import com.turnito.modelo.Profesional;
import com.turnito.negocio.UsuarioABM;

public class TestUsuario {
    public static void main(String[] args) {
            UsuarioABM abm = new UsuarioABM();

            try {
				abm.agregar(new Profesional("Jose","6787","22222",222222L,"AGASDK","Pediatra"));
				System.out.println(abm.traer());
			} catch (Exception e) {
				// TODO: handle exception
			}

    }
}
