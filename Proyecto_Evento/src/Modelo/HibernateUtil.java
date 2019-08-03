/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author luisv
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            Configuration config = new Configuration().configure();
            config.setProperty("hibernate.connection.username", "Luisdb");
            config.setProperty("hibernate.connection.password", "Pass/1024");
            SessionFactory factor = config.buildSessionFactory();
            sessionFactory = factor;
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }
    
    public static SessionFactory buildSessionFactory(){
        return sessionFactory;
    }
}
