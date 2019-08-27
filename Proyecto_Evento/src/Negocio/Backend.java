/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ferna
 */
public class Backend {
    
    
    public Backend(){
    
        
    }
    
    
        public static void salonesDisponibles(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
         table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Salon", "Capacidad", "Precio"};
        modelo.setColumnIdentifiers(columnNames);
        
        try{
        Query consulta;
        
        consulta = s.createSQLQuery("select distinct s.id_salon, s.nombre, s.capacidad, s.precio from teatro.salon s\n" +
                                    "inner join teatro.evento e\n" +
                                    "on s.id_salon != e.id_salon\n" +
                                    "where estado = 1");
        
        List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);
        }  
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
        public static void ConsultarEntidad(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Nombre", "RUC", "Dirección", "Teléfono"};
        modelo.setColumnIdentifiers(columnNames);
        
        try{
        Query consulta;
        
        consulta = s.createQuery("Select e.idEntidad, e.nombre, e.ruc, e.direccion, e.telefono\n" +
                                 "from Entidad e");
        
        List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);
        }  
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
      public static void ConsultaSupervisor(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Nombre", "Apellido", "Cédula", "Dirección", "Teléfono", "Fecha Nacimiento"};
        modelo.setColumnIdentifiers(columnNames);
        try{
        Query consulta;
        
        consulta = s.createQuery("Select s.idSupervisor, s.nombre, s.apellido, s.cedula, s.direccion, s.telefono, s.fechaNacimiento\n" +
                                 "from Supervisor s\n" +
                                 "where s.estado = 1");
        
        java.util.List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);
        }  
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
      
      public static void ConsultaServicio(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Nombre", "Precio"};
        modelo.setColumnIdentifiers(columnNames);
        
        try{
        Query consulta;
        
        consulta = s.createQuery("Select s.idServicio, s.nombre, s.precio\n" +
                                 "from Servicio s\n" +
                                 "where s.estado = 1");
        
        java.util.List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);
        }  
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
        public static void ConsultaMantenimiento(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        try{
        Query consulta;
        
        consulta = s.createSQLQuery("select \n" +
                                    "sl.nombre as NombreSalon, e.nombre as NombreEmpresa, \n" +
                                    "s.nombre as NombreSupervisor, m.tipo_mantenimiento, \n" +
                                    "m.costo, m.fecha_registro\n" +
                                    "from teatro.mantenimiento m\n" +
                                    "inner join teatro.empresa e\n" +
                                    "on m.id_empresa = e.id_empresa\n" +
                                    "inner join teatro.supervisor s\n" +
                                    "on m.id_supervisor = s.id_supervisor\n" +
                                    "inner join teatro.salon sl\n" +
                                    "on m.id_salon = sl.id_salon\n" +
                                    "group by \n" +
                                    "NombreSalon, NombreEmpresa, \n" +
                                    "NombreSupervisor, m.tipo_mantenimiento, \n" +
                                    "m.costo, m.fecha_registro");
        
        List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"Salon", "Empresa", "Supervisor", "Tipo mantenimiento", "Costo", "Fecha Registro"};
        modelo.setColumnIdentifiers(columnNames);
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);        
        }
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
      public static void ConsultaCliente(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        try{
        Query consulta;
        
        consulta = s.createQuery("Select c.idCliente, c.nombre, c.apellido, c.cedula, c.direccion, c.telefono, c.fechaNacimiento\n" +
                                 "from Cliente c");
        
        List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Nombre", "Apellido", "Cédula", "Dirección", "Teléfono", "Fecha Nacimiento"};
        modelo.setColumnIdentifiers(columnNames);
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);        
        }
        
        
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
      
      public static void ConsultarEmpresa(JTable table){
        SessionFactory factor;
        factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        DefaultTableModel modelo = new DefaultTableModel();
        
        try{
        Query consulta;
        
        consulta = s.createQuery("Select e.idEmpresa, e.nombre, e.direccion, e.telefono from Empresa e");
        
        List lista_consulta;
        lista_consulta = consulta.list();
        
        Iterator i = lista_consulta.iterator();
        table.setModel(modelo);
        
        String[] columnNames = new String[]{"ID", "Nombre", "Dirección", "Teléfono"};
        modelo.setColumnIdentifiers(columnNames);
        
        while(i.hasNext()){
            Object[] ob = (Object[]) i.next();
            modelo.addRow(ob);        
        }
        
        s.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
      }
        
}
