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
import Modelo.POJO.Evento;
import Modelo.POJO.Mantenimiento;
import Modelo.POJO.Salon;
import Modelo.POJO.Servicio;
import Modelo.POJO.Supervisor;
import Modelo.POJO.Usuario;
import Modelo.POJO.VentaBoleto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ferna
 */
public class BackendInserts {

    public BackendInserts() {

    }

    public static void InsertarCliente(String Nombre, String Apellido, String Cedula, String FechaNac, String Direccion, String Telefono) throws ParseException {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse(FechaNac);

        Cliente c = new Cliente();
        c.setNombre(Nombre);
        c.setApellido(Apellido);
        c.setCedula(Cedula);
        c.setFechaNacimiento(fecha);
        c.setDireccion(Direccion);
        c.setTelefono(Telefono);
        s.save(c);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();
    }

    public static void InsertarEntidad(String Nombre, String Direccion, String Telefono, String RUC) {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        Entidad e = new Entidad();
        e.setNombre(Nombre);
        e.setDireccion(Direccion);
        e.setTelefono(Telefono);
        e.setRuc(RUC);
        s.save(e);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();

    }

    public static void InsertarMantenimiento(Salon Salon, Empresa Empresa, Supervisor Supervisor, String TipoMto, Float Costo) {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        Mantenimiento m = new Mantenimiento();
        m.setSalon(Salon);
        m.setEmpresa(Empresa);
        m.setSupervisor(Supervisor);
        m.setTipoMantenimiento(TipoMto);
        m.setCosto(Costo);
        s.save(m);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();
    }

    public static void InsertarSalon(String Nombre, int Capacidad, Float Precio) {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        Salon sl = new Salon();
        sl.setNombre(Nombre);
        sl.setCapacidad(Capacidad);
        sl.setPrecio(Precio);
        sl.setEstado(Boolean.TRUE);
        s.save(s);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();

    }

    public static void InsertarServicio(String Nombre, Float Precio) {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        Servicio sv = new Servicio();
        sv.setNombre(Nombre);
        sv.setPrecio(Precio);
        sv.setEstado(Boolean.TRUE);
        s.save(sv);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();

    }

    public static void InsertarSupervisor(String Nombre, String Apellido, String Cedula, String FechaNac, String Direccion, String Telefono) throws ParseException {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse(FechaNac);

        s.beginTransaction();
        Supervisor sp = new Supervisor();
        sp.setNombre(Nombre);
        sp.setApellido(Apellido);
        sp.setCedula(Cedula);
        sp.setFechaNacimiento(fecha);
        sp.setDireccion(Direccion);
        sp.setTelefono(Telefono);
        sp.setEstado(Boolean.TRUE);
        s.save(sp);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
        s.close();

    }

    public static void InsertarUsuario(String Usuario, String Contraseña) {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();

        s.beginTransaction();
        Usuario u = new Usuario();
        u.setNombreUsario(Usuario);
        u.setContrasena(Contraseña);
        s.save(u);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
        s.close();
    }

    public static void InsertarVtaBoleto(String Cedula, int CantidadPersonas, String Fecha, Evento Evento) throws ParseException {
        SessionFactory factor = HibernateUtil.getSessionFactory();
        Session s;
        s = factor.openSession();
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = formato.parse(Fecha);

        s.beginTransaction();
        VentaBoleto v = new VentaBoleto();
        v.setCedula(Cedula);
        v.setCantidadBoletos(CantidadPersonas);
        v.setFecha(fecha);
        v.setEvento(Evento);
        s.save(v);
        s.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Venta Exitosa");
        s.close();

    }
    

}
