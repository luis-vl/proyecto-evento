/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author fernando
 */
public class Registrar_Cliente extends javax.swing.JDialog {

    /**
     * Creates new form Registrar_Cliente
     */
    public Registrar_Cliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pInferior = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        pSuperior = new javax.swing.JPanel();
        pDatosUsuario = new javax.swing.JPanel();
        txtPrimerNombre = new javax.swing.JTextField();
        txtSegundoNombre = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JFormattedTextField();
        pControlador = new javax.swing.JPanel();
        pFoto2 = new javax.swing.JPanel();
        btnAgregarFoto = new javax.swing.JButton();
        btnEliminarFoto = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pInferior.setBackground(new java.awt.Color(42, 42, 42));
        pInferior.setPreferredSize(new java.awt.Dimension(445, 50));
        pInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancelar.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pInferior.add(btnCancelar);

        btnOK.setFont(new java.awt.Font("HP Simplified", 0, 18)); // NOI18N
        btnOK.setText("OK");
        btnOK.setPreferredSize(new java.awt.Dimension(100, 40));
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        pInferior.add(btnOK);

        getContentPane().add(pInferior, java.awt.BorderLayout.PAGE_END);

        pSuperior.setBackground(new java.awt.Color(42, 42, 42));
        pSuperior.setLayout(new java.awt.BorderLayout());

        pDatosUsuario.setBackground(new java.awt.Color(57, 60, 76));
        pDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 12), new java.awt.Color(250, 250, 250))); // NOI18N
        pDatosUsuario.setForeground(new java.awt.Color(255, 255, 255));

        txtPrimerNombre.setText("Primer Nombre");

        txtSegundoNombre.setText("Segundo Nombre");

        txtPrimerApellido.setText("Primer Apellido");

        txtSegundoApellido.setText("Segundo Apellido");
        txtSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegundoApellidoActionPerformed(evt);
            }
        });

        txtDireccion.setText("Dirección");

        txtTelefono.setText("Teléfono");

        txtCorreo.setText("Correo");

        javax.swing.GroupLayout pDatosUsuarioLayout = new javax.swing.GroupLayout(pDatosUsuario);
        pDatosUsuario.setLayout(pDatosUsuarioLayout);
        pDatosUsuarioLayout.setHorizontalGroup(
            pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrimerNombre)
                    .addComponent(txtSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(txtPrimerApellido)
                    .addComponent(txtSegundoApellido)
                    .addComponent(txtDireccion)
                    .addComponent(txtTelefono)
                    .addComponent(txtCorreo))
                .addContainerGap())
        );
        pDatosUsuarioLayout.setVerticalGroup(
            pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosUsuarioLayout.createSequentialGroup()
                .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        pSuperior.add(pDatosUsuario, java.awt.BorderLayout.CENTER);

        pControlador.setBackground(new java.awt.Color(57, 60, 76));
        pControlador.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pFoto2.setBackground(java.awt.SystemColor.activeCaptionBorder);

        javax.swing.GroupLayout pFoto2Layout = new javax.swing.GroupLayout(pFoto2);
        pFoto2.setLayout(pFoto2Layout);
        pFoto2Layout.setHorizontalGroup(
            pFoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pFoto2Layout.setVerticalGroup(
            pFoto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        btnAgregarFoto.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnAgregarFoto.setText("Agregar Foto");

        btnEliminarFoto.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnEliminarFoto.setText("Eliminar Foto");

        btnRegistrarCliente.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        btnRegistrarCliente.setText("Registrar Cliente");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pControladorLayout = new javax.swing.GroupLayout(pControlador);
        pControlador.setLayout(pControladorLayout);
        pControladorLayout.setHorizontalGroup(
            pControladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControladorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pControladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pFoto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pControladorLayout.setVerticalGroup(
            pControladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pControladorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pFoto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarFoto)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarFoto)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarCliente)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pSuperior.add(pControlador, java.awt.BorderLayout.LINE_END);

        getContentPane().add(pSuperior, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        // TODO add your handling code here:
        //        this.dispose();
        //        Login l = new Login();
        //        l.setVisible(true);
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void txtSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundoApellidoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrar_Cliente dialog = new Registrar_Cliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFoto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarFoto;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JPanel pControlador;
    private javax.swing.JPanel pDatosUsuario;
    private javax.swing.JPanel pFoto2;
    private javax.swing.JPanel pInferior;
    private javax.swing.JPanel pSuperior;
    private javax.swing.JFormattedTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
