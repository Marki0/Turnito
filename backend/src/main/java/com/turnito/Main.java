package com.turnito;

import com.turnito.modelo.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")

                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            session.beginTransaction();
            System.out.println("Conexión a la base de datos establecida correctamente.");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
