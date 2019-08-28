/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Usuario;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class ModelUser {
    private final Session session;
    private final Criteria ctr;
    private final DefaultTableModel tModel;
    List<Usuario> lista;
    private final String[] colNames = {"USUARIO","CONTRASEÑA","ROL"};

    public ModelUser(javax.swing.JTable tabla) {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Usuario.class);

        lista = ctr.list();

        tabla.setModel(tModel);
        tModel.setColumnIdentifiers(colNames);
    }

    public void cargarDatos() {
        lista.forEach((s) -> {
            tModel.addRow(new Object[]{s.getNombreUsario(),s.getContrasena(),s.getRol()});
        });
    }
    
    public Usuario getAt(int index) {
        return lista.get(index);
    }
}
