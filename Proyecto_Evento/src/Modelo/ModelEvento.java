/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Evento;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class ModelEvento {

    private Session session;
    private Criteria ctr;
    private final DefaultTableModel tModel;
    private final List<Evento> eventos;
    private String[] colNames = {"ID", "NOMBRE EVENTO", "CLIENTE", "FECHA", "DURACION", "CAPACIDAD"};

    public ModelEvento() {

        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Evento.class);

        eventos = ctr.list();
        tModel.setColumnIdentifiers(colNames);
    }

    public ModelEvento(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Evento.class);

        eventos = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarParaVenta() {
        colNames = new String[]{"NOMBRE EVENTO", "FECHA", "DURACION", "CAPACIDAD", "PRECIO"};
        tModel.setColumnIdentifiers(colNames);
        eventos.forEach((e) -> {
            tModel.addRow(
                    new Object[]{e.getNombre(), e.getFechaEvento(), e.getDuracion(), e.getCantidadPersonas(), e.getPrecioBoleto()});
        });
    }

    public void cargarLista(JList<String> list) {
        DefaultListModel<String> lmodel = new DefaultListModel<>();
        list.setModel(lmodel);
        eventos.forEach((e) -> {
            lmodel.addElement(e.getNombre());
        });

    }

    public void cargarDatos() {
        eventos.forEach((e) -> {
            tModel.addRow(
                    new Object[]{e.getIdEvento(), e.getNombre(), (e.getCliente().getNombre() + "  " + e.getCliente().getApellido()),
                        e.getFechaEvento(), e.getDuracion(), e.getCantidadPersonas()});
        });
    }

    public Evento getUltimo() {
        return eventos.get(eventos.size() - 1);
    }

    public Evento getAt(int index) {
        return eventos.get(index);
    }

    public Evento getByID(int id) {
        session.beginTransaction();
        Evento e = session.get(Evento.class, id);
        session.getTransaction().commit();
        return e;
    }

    public void addEvento(Evento e) {
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
        session.close();
    }

    public void updateEvento(Evento e) {
        session.beginTransaction();
        session.update(e);
        session.getTransaction().commit();
    }
}
