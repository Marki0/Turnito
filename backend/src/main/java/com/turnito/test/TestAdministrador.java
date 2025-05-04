package com.turnito.test;

import java.util.List;

import com.turnito.modelo.Administrador;
import com.turnito.negocio.AdministradorABM;

public class TestAdministrador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdministradorABM abm = new AdministradorABM();
		
		try {
			// Agregamos los administradores
			abm.agregar("Juan Pérez", "juan.perez@mail.com", "123456789", 12345678L, "Ventas");
            abm.agregar("Ana Gómez", "ana.gomez@mail.com", "987654321", 87654321L, "Atención al Cliente");
		}catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		
		 try {
	            // Traer Administrador por ID (usando el correo como ejemplo)
	            Administrador admin = abm.traer("juan.perez@mail.com");
	            System.out.println("Administrador encontrado: " + admin);

	            // Modificar un Administrador
	            admin.setSector("Marketing");
	            abm.modificar(admin);
	            System.out.println("Administrador modificado: " + admin);

	    } catch (Exception e) {
	            System.out.println(e.getMessage());
	    }
		 
		 // TRAEMOS POR ID=1
		 try {
			 	
	            Administrador admin = abm.traer(1);
	            System.out.println("ID" + admin);
	        } catch (Exception e) {
	            System.out.println("Usuario no encontrado" + e.getMessage());
	        }
		 
		// TRAER POR NOMBRE
	    try {
	            Administrador admin = abm.traer("Ana Gómez");
	            System.out.println("Traido por nombre: " + admin);
	    } catch (Exception e) {
	            System.out.println("Usuario no encontrado " + e.getMessage());
	    }
	    
	    //TRAEMOS POR SECTOR 
	    try {
	    	List<Administrador> admin = abm.traerPorSector("Ventas");
	    	System.out.println("Administradores encontrados por sector: "+ admin);
	    }catch (Exception e) {
            System.out.println("Usuario no encontrado " + e.getMessage());
	    }
	    
	    // MODIFICAMOS ADMINISTRADOR
        try {
            Administrador admin = abm.traerPorCorreo("juan.perez@mail.com");
            admin.setTelefono("5893311");
            admin.setSector("Marketing");
            abm.modificar(admin);
            System.out.println("Administrador modificado: " + admin);
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
        }
        
        // Eliminar administrador
        try {
            Administrador admin = abm.traerPorCorreo("juan.perez@mail.com");
            abm.eliminar(admin.getId());
            System.out.println("Administrador eliminado: " + admin);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
        
        // Traer todos
        try {
            List<Administrador> todos = abm.traer();
            System.out.println("Todos los administradores:");
            for (Administrador a : todos) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println("Error al traer todos: " + e.getMessage());
        }

	        
	    
	}

}
