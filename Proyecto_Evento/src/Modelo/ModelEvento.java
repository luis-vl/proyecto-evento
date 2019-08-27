/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Evento;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelEvento {
    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    private List<Evento> eventos;
    private final String[] colNames = {"NOMBRE EVENTO","CLIENTE","FECHA","DURACION","CAPACIDAD"};

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

    public void cargarDatos() {
        eventos = ctr.list();
        eventos.forEach((e) -> {
            tModel.addRow(
                new Object[]{e.getNombre(),(e.getCliente().getNombre()+"  "+e.getCliente().getApellido()),e.getFechaEvento(),e.getDuracion(),e.getCantidadPersonas()});
        });
    }
    
    public Evento getUltimo(){
        return eventos.get(eventos.size());
    }
    
    public Evento getAt(int index) {
        return eventos.get(index);
    }
    
    public void addEvento(Evento e) {
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
    }
}
