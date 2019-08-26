/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Salon;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelSalon {

    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    List<Salon> salones;
    private final JTable tabla;
    private final String[] colNames = {"NOMBRE","CAPACIDAD","PRECIO"};

    public ModelSalon(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Salon.class);

        salones = ctr.list();

        this.tabla = tabla;
        this.tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        salones.forEach((s) -> {
            tModel.addRow(new Object[]{s.getNombre(),s.getCapacidad(),s.getPrecio()});
        });
    }

}
