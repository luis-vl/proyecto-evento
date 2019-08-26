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
    List<Evento> eventos;
    private final String[] colNames = {"NOMBRE","CAPACIDAD","PRECIO"};

    public ModelEvento(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Evento.class);

        eventos = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        eventos.forEach((e) -> {
            tModel.addRow(new Object[]{e.getNombre(),e.getCliente().getNombre(),e.getFechaEvento(),e.getDuracion(),e.getCantidadPersonas()});
        });
    }
}
