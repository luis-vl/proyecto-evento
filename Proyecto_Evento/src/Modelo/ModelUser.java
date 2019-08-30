/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Usuario;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class ModelUser {

    private final Session session;
    private Criteria ctr;
    private final DefaultTableModel tModel;
    List<Usuario> lista;
    private final String[] colNames = {"USUARIO", "CONTRASEÑA", "ROL"};

    public ModelUser() {
        tModel = new DefaultTableModel();
        session = HibernateUtil.getSessionFactory().openSession();
        ctr = session.createCriteria(Usuario.class);

        lista = ctr.list();
    }

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
            tModel.addRow(new Object[]{s.getNombreUsario(), s.getContrasena(), s.getRol()});
        });
    }

    public void setRol(javax.swing.JComboBox cbx) {
        Query q = session.createQuery("select distinct u.rol from Usuario u");
        DefaultComboBoxModel<String> cbm = new DefaultComboBoxModel<>();
        List<String> users = q.list();
        for (String u : users) {
            cbm.addElement(u);
        }
        cbx.setModel(cbm);
    }

    public boolean existe(String u) {
        ctr = session.createCriteria(Usuario.class).add(Restrictions.eq("nombreUsario", u));
        return ctr.uniqueResult() != null;
    }

    public boolean verificar(Usuario u) {
        ctr = session.createCriteria(Usuario.class)
                .add(Restrictions.eq("nombreUsario", u.getNombreUsario()))
                .add(Restrictions.eq("contrasena", u.getContrasena()));
        return ctr.uniqueResult() != null;
    }

    public Usuario getUsuario(Usuario u) {
        Usuario user;
        ctr = session.createCriteria(Usuario.class)
                .add(Restrictions.eq("nombreUsario", u.getNombreUsario()))
                .add(Restrictions.eq("contrasena", u.getContrasena()));
        user = (Usuario) ctr.uniqueResult();
        return user;
    }

    public Usuario getAt(int index) {
        return lista.get(index);
    }

    public Usuario getByID(int id) {
        session.beginTransaction();
        Usuario u = session.get(Usuario.class, id);
        session.getTransaction().commit();
        return u;
    }

    public void updateUser(Usuario u) {
        session.beginTransaction();
        session.update(u);
        session.getTransaction().commit();
    }
}
