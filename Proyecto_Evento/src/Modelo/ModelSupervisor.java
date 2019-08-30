/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Supervisor;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelSupervisor {
    private final Session session;
    private final Criteria ctr;
    List<Supervisor> lista;

    public ModelSupervisor() {
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Supervisor.class);

        lista = ctr.list();
    }
    
    public Supervisor getAt(int index) {
        return lista.get(index);
    }
    
    public void cargarLista(JList<String> list) {
        DefaultListModel<String> lmodel = new DefaultListModel<>();
        list.setModel(lmodel);
        lista.forEach((e) -> {
            lmodel.addElement(e.getNombre()+" "+e.getApellido());
        });

    }
    
    public Supervisor getByID(int id) {
        session.beginTransaction();
        Supervisor e = session.get(Supervisor.class, id);
        session.getTransaction().commit();
        return e;
    }
    
    public void updateEvento(Supervisor e) {
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
    }
}
