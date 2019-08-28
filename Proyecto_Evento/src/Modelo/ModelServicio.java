/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Servicio;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelServicio {
    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    List<Servicio> servicios;
    private final String[] colNames = {"NOMBRE","PRECIO"};

    public ModelServicio(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Servicio.class);

        servicios = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        servicios.forEach((s) -> {
            tModel.addRow(new Object[]{s.getNombre(),s.getPrecio()});
        });
    }
    
    public Servicio getAt(int index) {
        return servicios.get(index);
    }
}
