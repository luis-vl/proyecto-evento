/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Salon;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
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
    private final String[] colNames = {"NOMBRE","CAPACIDAD","PRECIO"};

    public ModelSalon() {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Salon.class);

        salones = ctr.list();
    }
    
    public ModelSalon(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Salon.class);

        salones = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }
    
    public void cargarComboBox(JComboBox cbx){
        DefaultComboBoxModel cbxModel = new DefaultComboBoxModel();
        cbx.setModel(cbxModel);
        salones.forEach((s)->{
            cbxModel.addElement(s.getNombre());
        });
    }

    public void cargarDatos() {
        salones.forEach((s) -> {
            tModel.addRow(new Object[]{s.getNombre(),s.getCapacidad(),s.getPrecio()});
        });
    }
    
    public Salon getAt(int index) {
        return salones.get(index);
    }

}
