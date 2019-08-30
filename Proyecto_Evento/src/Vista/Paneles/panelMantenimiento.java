/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Modelo.ModelMantenimiento;
import Negocio.Backend;
import Vista.*;
import javax.swing.JFrame;

/**
 *
 * @author luisv
 */
public class panelMantenimiento extends javax.swing.JPanel {

    private ModelMantenimiento mant;
    
    /**
     * Creates new form panelMantenimiento
     */
    public panelMantenimiento() {
        initComponents();
        Backend.ConsultaMantenimiento(this.tMantenimiento);
        mant = new ModelMantenimiento();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tMantenimiento = new javax.swing.JTable();
        pButtonsMant = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Salon", "Empresa", "Supervisor", "Tipo Mantenimiento", "Costo"
            }
        ));
        tMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMantenimientoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tMantenimiento);

        add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pButtonsMant.setBackground(new java.awt.Color(42, 42, 42));
        pButtonsMant.setLayout(new javax.swing.BoxLayout(pButtonsMant, javax.swing.BoxLayout.LINE_AXIS));

        btnAgregar.setBackground(new java.awt.Color(100, 221, 23));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pButtonsMant.add(btnAgregar);

        jPanel7.setBackground(new java.awt.Color(42, 42, 42));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 24));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        pButtonsMant.add(jPanel7);

        btnEditar.setBackground(new java.awt.Color(57, 105, 138));
        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pButtonsMant.add(btnEditar);

        add(pButtonsMant, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        Dialog_Mantenimiento v = new Dialog_Mantenimiento((JFrame) this.getRootPane().getParent(), true);
        v.setVisible(true);
        Backend.ConsultaMantenimiento(this.tMantenimiento);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Dialog_Mantenimiento v = new Dialog_Mantenimiento((JFrame) this.getRootPane().getParent(), true);
        v.setMantenimiento(mant.getAt(tMantenimiento.getSelectedRow()));
        v.setCampos();
        v.setEdit(true);
        v.setVisible(true);
        Backend.ConsultaMantenimiento(this.tMantenimiento);
        btnEditar.setEnabled(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMantenimientoMouseClicked
        // TODO add your handling code here:
        if (tMantenimiento.getSelectedRow() > 0) btnEditar.setEnabled(true);
    }//GEN-LAST:event_tMantenimientoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pButtonsMant;
    private javax.swing.JTable tMantenimiento;
    // End of variables declaration//GEN-END:variables
}
