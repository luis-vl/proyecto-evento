/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Empresa;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelEmpresa {
    private final Session session;
    private final Criteria ctr;
    List<Empresa> lista;

    public ModelEmpresa() {
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Empresa.class);

        lista = ctr.list();
    }
    
    public Empresa getAt(int index) {
        return lista.get(index);
    }
    
    public void cargarLista(JList<String> list) {
        DefaultListModel<String> lmodel = new DefaultListModel<>();
        list.setModel(lmodel);
        lista.forEach((e) -> {
            lmodel.addElement(e.getNombre());
        });

    }
    
    public Empresa getByID(int id) {
        session.beginTransaction();
        Empresa e = session.get(Empresa.class, id);
        session.getTransaction().commit();
        return e;
    }
    
    public void updateEvento(Empresa e) {
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
    }
}
