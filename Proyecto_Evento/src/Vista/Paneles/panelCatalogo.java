/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Modelo.HibernateUtil;
import Modelo.ModelSalon;
import Modelo.POJO.*;
import Vista.*;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class panelCatalogo extends javax.swing.JPanel {

    /**
     * Creates new form panelCatalogo
     */
    public panelCatalogo() {
        initComponents();
        CargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupRegistrar = new javax.swing.JPopupMenu();
        miCliente = new javax.swing.JMenuItem();
        miSalon = new javax.swing.JMenuItem();
        miEntidad = new javax.swing.JMenuItem();
        miServicios = new javax.swing.JMenuItem();
        miEmpresaM = new javax.swing.JMenuItem();
        miSupervisor = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        pButtonsTablas = new javax.swing.JPanel();
        btnAddRegistro = new javax.swing.JButton();
        panelEspacio2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxMostrar = new javax.swing.JComboBox<>();

        miCliente.setText("Cliente");
        miCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miClienteActionPerformed(evt);
            }
        });
        popupRegistrar.add(miCliente);

        miSalon.setText("Salón");
        miSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSalonActionPerformed(evt);
            }
        });
        popupRegistrar.add(miSalon);

        miEntidad.setText("Entidad Cliente");
        miEntidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEntidadActionPerformed(evt);
            }
        });
        popupRegistrar.add(miEntidad);

        miServicios.setText("Venta Boletos");
        miServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miServiciosActionPerformed(evt);
            }
        });
        popupRegistrar.add(miServicios);

        miEmpresaM.setText("Empresa de Mantenimiento");
        miEmpresaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmpresaMActionPerformed(evt);
            }
        });
        popupRegistrar.add(miEmpresaM);

        miSupervisor.setText("Supervisor");
        miSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSupervisorActionPerformed(evt);
            }
        });
        popupRegistrar.add(miSupervisor);

        setLayout(new java.awt.BorderLayout());

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tDatos);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pButtonsTablas.setBackground(new java.awt.Color(42, 42, 42));
        pButtonsTablas.setLayout(new javax.swing.BoxLayout(pButtonsTablas, javax.swing.BoxLayout.LINE_AXIS));

        btnAddRegistro.setBackground(new java.awt.Color(100, 221, 23));
        btnAddRegistro.setText("Agregar..");
        btnAddRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddRegistroMousePressed(evt);
            }
        });
        pButtonsTablas.add(btnAddRegistro);

        panelEspacio2.setBackground(new java.awt.Color(42, 42, 42));
        panelEspacio2.setMinimumSize(new java.awt.Dimension(10, 100));
        panelEspacio2.setPreferredSize(new java.awt.Dimension(10, 24));

        javax.swing.GroupLayout panelEspacio2Layout = new javax.swing.GroupLayout(panelEspacio2);
        panelEspacio2.setLayout(panelEspacio2Layout);
        panelEspacio2Layout.setHorizontalGroup(
            panelEspacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        panelEspacio2Layout.setVerticalGroup(
            panelEspacio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pButtonsTablas.add(panelEspacio2);

        jLabel1.setForeground(new java.awt.Color(220, 220, 220));
        jLabel1.setText("Mostrar: ");
        pButtonsTablas.add(jLabel1);

        cbxMostrar.setBackground(new java.awt.Color(57, 105, 138));
        cbxMostrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Salon", "Entidad", "Servicios", "Empresa Mantenimiento", "Supervisor" }));
        cbxMostrar.setMaximumSize(new java.awt.Dimension(300, 32767));
        cbxMostrar.setPreferredSize(new java.awt.Dimension(300, 20));
        cbxMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMostrarActionPerformed(evt);
            }
        });
        pButtonsTablas.add(cbxMostrar);

        add(pButtonsTablas, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddRegistroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddRegistroMousePressed
        // TODO add your handling code here:
        popupRegistrar.show(evt.getComponent(),
                3, //PosicionX
                evt.getComponent().getY() + evt.getComponent().getHeight() - 2); //PosicionY
    }//GEN-LAST:event_btnAddRegistroMousePressed

    private void miClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miClienteActionPerformed
        // TODO add your handling code here:
        Dialog_Cliente rc = new Dialog_Cliente((JFrame) this.getRootPane().getParent(), true);
        rc.setVisible(true);
    }//GEN-LAST:event_miClienteActionPerformed

    private void miSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSalonActionPerformed
        // TODO add your handling code here:
        Dialog_Salón rs = new Dialog_Salón((JFrame) this.getRootPane().getParent(), true);
        rs.setVisible(true);
    }//GEN-LAST:event_miSalonActionPerformed

    private void miEntidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEntidadActionPerformed
        // TODO add your handling code here:
        Dialog_Entidad re = new Dialog_Entidad((JFrame) this.getRootPane().getParent(), true);
        re.setVisible(true);
    }//GEN-LAST:event_miEntidadActionPerformed

    private void miServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miServiciosActionPerformed
        // TODO add your handling code here:
        Dialog_Servicio rvb = new Dialog_Servicio((JFrame) this.getRootPane().getParent(), true);
        rvb.setVisible(true);
    }//GEN-LAST:event_miServiciosActionPerformed

    private void miEmpresaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmpresaMActionPerformed
        // TODO add your handling code here:
        Dialog_Entidad re = new Dialog_Entidad((JFrame) this.getRootPane().getParent(), true);
        re.setVisible(true);
    }//GEN-LAST:event_miEmpresaMActionPerformed

    private void miSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSupervisorActionPerformed
        // TODO add your handling code here:
        Dialog_Supervisor rs = new Dialog_Supervisor((JFrame) this.getRootPane().getParent(), true);
        rs.setVisible(true);
    }//GEN-LAST:event_miSupervisorActionPerformed

    private void cbxMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMostrarActionPerformed
        // TODO Mostrar datos cuando cambie el ComboBox
        CargarDatos();
    }//GEN-LAST:event_cbxMostrarActionPerformed

    private void CargarDatos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria ctr;
        DefaultTableModel tModel = new DefaultTableModel();
        tDatos.setModel(tModel);
        switch (cbxMostrar.getSelectedIndex()) {
            case 0://Cliente
                String[] columnNames = new String[]{"NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO", "CEDULA", "FECHA NACIMIENTO"};
                tModel.setColumnIdentifiers(columnNames);

                ctr = session.createCriteria(Cliente.class);
                List<Cliente> clientes = ctr.list();

                clientes.forEach((c) -> {
                    tModel.addRow(new Object[]{c.getNombre(), c.getApellido(), c.getDireccion(), c.getTelefono(), c.getFechaNacimiento()});
                });

                break;
                
            case 1://Salon
                new ModelSalon(tDatos).cargarDatos();
                break;
            case 2:
                break;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRegistro;
    private javax.swing.JComboBox<String> cbxMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem miCliente;
    private javax.swing.JMenuItem miEmpresaM;
    private javax.swing.JMenuItem miEntidad;
    private javax.swing.JMenuItem miSalon;
    private javax.swing.JMenuItem miServicios;
    private javax.swing.JMenuItem miSupervisor;
    private javax.swing.JPanel pButtonsTablas;
    private javax.swing.JPanel panelEspacio2;
    private javax.swing.JPopupMenu popupRegistrar;
    private javax.swing.JTable tDatos;
    // End of variables declaration//GEN-END:variables

}
