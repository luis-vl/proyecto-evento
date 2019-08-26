/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author luisv
 */
public class TablaModel extends AbstractTableModel{
    
    private List<Object[]> lista;
    private String[] columnNames;
    private Class c;

    public TablaModel(Class c) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query q = session.createQuery(
                    "select nombre,cliente,fechaEvento,duracion,cantidadPersonas from Evento", c);
            lista = q.list();
        }
    }
    
    public void setColumnNames(String[] str) {
        columnNames = str;
    }
    
    public void setDataList(List lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getRowAt(int rowIndex) {
        return lista.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return  lista.get(rowIndex)[columnIndex];
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    public void addRow(Object[] obj) {
        lista.add(obj);
        int row = lista.indexOf(obj);
        fireTableRowsInserted(row,row);
    }
    
}
