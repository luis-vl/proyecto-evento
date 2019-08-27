/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.VentaBoleto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelVentaBoleto {
    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    private final List<VentaBoleto> lista;
    private final String[] colNames = {"CEDULA","CANTIDAD","EVENTO"};

    public ModelVentaBoleto() {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(VentaBoleto.class);

        lista = ctr.list();
        tModel.setColumnIdentifiers(colNames);
    }
    
    public ModelVentaBoleto(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(VentaBoleto.class);

        lista = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        lista.forEach((e) -> {
            tModel.addRow(
                new Object[]{e.getCedula(),e.getCantidadBoletos(),e.getEvento().getNombre()});
        });
    }
    
    public VentaBoleto getUltimo(){
        return lista.get(lista.size()-1);
    }
    
    public VentaBoleto getAt(int index) {
        return lista.get(index);
    }
    
    public void addVenta(VentaBoleto v) {
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
}
