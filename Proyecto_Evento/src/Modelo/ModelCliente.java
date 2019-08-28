/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Cliente;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelCliente {
    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    private List<Cliente> clientes;
    private final String[] colNames = {"NOMBRES","APELLIDOS","CEDULA"};

    public ModelCliente(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Cliente.class);

        clientes = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        clientes = ctr.list();
        clientes.forEach((c) -> {
            tModel.addRow(
                new Object[]{c.getNombre(),c.getApellido(),c.getCedula()});
        });
    }
    
    public Cliente getAt(int index) {
        return clientes.get(index);
    }
    
    public void addCliente(Cliente c) {
        session.save(c);
    }
}
