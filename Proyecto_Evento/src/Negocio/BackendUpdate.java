/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.HibernateUtil;
import Modelo.POJO.Cliente;
import Modelo.POJO.Empresa;
import Modelo.POJO.Entidad;
import Modelo.POJO.Salon;
import Modelo.POJO.Servicio;
import Modelo.POJO.Supervisor;
import Modelo.POJO.Usuario;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ferna
 */
public class BackendUpdate {
    
    public BackendUpdate(){
        
    }
    
    public static void EditarCliente(String ID, String Direccion, String Telefono){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        
        s.beginTransaction();
        Cliente c = (Cliente) s.get(Cliente.class, id);
        c.setDireccion(Direccion);
        c.setTelefono(Telefono);
        s.update(c);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro actualizado");
    
    }
    
    public static void EditarEntidad(String ID, String Direccion, String Telefono){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        
        s.beginTransaction();
        Entidad e = (Entidad) s.get(Entidad.class, id);
        e.setDireccion(Direccion);
        e.setTelefono(Telefono);
        s.update(e);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro actualizado");

        
    }
    
    public static void EditarEmpresa(String ID, String Direccion, String Telefono){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        
        s.beginTransaction();
        Empresa e = (Empresa) s.get(Empresa.class, id);
        e.setDireccion(Direccion);
        e.setTelefono(Telefono);
        s.update(e);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
    }
    
    public static void EditarServicio(String ID, String Nombre, String Precio, Boolean Estado){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        Float precio = Float.parseFloat(Precio);
        
        s.beginTransaction();        
        Servicio sv = (Servicio) s.get(Servicio.class, id);
        sv.setNombre(Nombre);
        sv.setPrecio(precio);
        sv.setEstado(Estado);
        s.update(sv);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro Actualizado");

        
    }
    
    public static void EditarSalon(String ID, String Nombre, String Capacidad, String Precio, Boolean Estado){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        int capacidad = Integer.parseInt(Capacidad);
        Float precio = Float.parseFloat(Precio);
        
        s.beginTransaction();
        Salon sl = (Salon) s.get(Salon.class, id);
        sl.setNombre(Nombre);
        sl.setCapacidad(capacidad);
        sl.setPrecio(precio);
        sl.setEstado(Estado);
        s.update(sl);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro Actualizado");
        
    }
    
    public static void EditarSupervisor(String ID, String Direccion, String Telefono, Boolean Estado){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        
        s.beginTransaction();
        Supervisor sv  = (Supervisor) s.get(Supervisor.class, id);
        sv.setDireccion(Direccion);
        sv.setTelefono(Telefono);
        sv.setEstado(Estado);
        s.update(sv);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro actualizado");
    
    }
    
    public static void EditarUsuario(String ID, String Usuario, String Contraseña, String Rol){
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        int id = Integer.parseInt(ID);
        
        s.beginTransaction();
        Usuario u = (Usuario) s.get(Usuario.class, id);
        u.setNombreUsario(Usuario);
        u.setContrasena(Contraseña);
        u.setRol(Rol);
        s.update(u);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "El Usuario se actualizo de forma exitosa");

        
    }
    
    
    
}
