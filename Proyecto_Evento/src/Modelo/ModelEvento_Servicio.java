/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.EventoServicio;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class ModelEvento_Servicio {

    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    private List<EventoServicio> lista;
    private String[] colNames = {"ID EVENTO", "ID SERVICIO", "PRECIO"};

    public ModelEvento_Servicio() {
        this.session = HibernateUtil.getSessionFactory().openSession();
        this.ctr = session.createCriteria(EventoServicio.class);
        this.tModel = new DefaultTableModel();
        this.lista = ctr.list();
    }

    public ModelEvento_Servicio(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(EventoServicio.class);

        lista = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        lista.forEach((s) -> {
            tModel.addRow(new Object[]{s.getEvento().getIdEvento(), s.getServicio().getIdServicio(), s.getPrecio()});
        });
    }

    public void getContratados() {
        Query q = session.createQuery("select e.nombre,s.nombre,es.precio from EventoServicio es\n"
                + "inner join es.evento e\n"
                + "inner join es.servicio s");
        List<Object[]> list = q.list();
        colNames = new String[]{"EVENTO","SERVICIO","PRECIO"};
        tModel.setColumnIdentifiers(colNames);
        for(Object[] s:list){
            tModel.addRow(new Object[]{s[0],s[1],s[2]});
        }
    }

    public void addEvt_Servicio(EventoServicio es) {
        session.beginTransaction();
        session.save(es);
        session.getTransaction().commit();
    }

    public void updateEvt_Servicio(EventoServicio es) {
        session.beginTransaction();
        session.update(es);
        session.getTransaction().commit();
    }

}
