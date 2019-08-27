/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.POJO.Evento;
import Modelo.POJO.VentaBoleto;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class ModelVentaBoleto {

    private final Session session;
    private Criteria ctr;
    private final DefaultTableModel tModel;
    private final List<VentaBoleto> lista;
    private final String[] colNames = {"CEDULA", "CANTIDAD", "EVENTO"};

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
                    new Object[]{e.getCedula(), e.getCantidadBoletos(), e.getEvento().getNombre()});
        });
    }

    public double getVentasEvento(int id) {
        double ventas = 0;

        Query q = session.createQuery("select sum(e.precioBoleto*v.cantidadBoletos) from VentaBoleto v\n"
                + "inner join v.evento e\n"
                + "where e.idEvento=" +id);
        if (q.uniqueResult() != null) {
            ventas = (double) q.uniqueResult();
        }
        return ventas;
    }

    public long getSumByEvento(int id) {
        long sum = 0;
        session.beginTransaction();
        ctr = session.createCriteria(VentaBoleto.class).add(Restrictions.eq("evento.idEvento", id));
        ctr.setProjection(Projections.sum("cantidadBoletos"));
        if (ctr.uniqueResult() != null) {
            sum = (Long) ctr.uniqueResult();
        }
        session.getTransaction().commit();
        return sum;
    }

    public VentaBoleto getUltimo() {
        return lista.get(lista.size() - 1);
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
