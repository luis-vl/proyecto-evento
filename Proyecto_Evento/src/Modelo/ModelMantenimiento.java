/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Mantenimiento;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelMantenimiento {
    private final Session session;
    private final Criteria ctr;
    List<Mantenimiento> lista;

    public ModelMantenimiento() {
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Mantenimiento.class);

        lista = ctr.list();
    }
    
    public Mantenimiento getAt(int index) {
        return lista.get(index);
    }
    
    public Mantenimiento getByID(int id) {
        session.beginTransaction();
        Mantenimiento e = session.get(Mantenimiento.class, id);
        session.getTransaction().commit();
        return e;
    }
    
    public void update(Mantenimiento e) {
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
    }
    
    public void add(Mantenimiento m) {
        session.beginTransaction();
        session.save(m);
        session.getTransaction().commit();
        session.close();
    }
}
