/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.HibernateUtil;
import Modelo.POJO.Entidad;
import Negocio.BackendInserts;
import Negocio.BackendUpdate;
import Vista.Paneles.panelCatalogo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fernando
 */
public class Dialog_Entidad extends javax.swing.JDialog {
    
    public static boolean var = false;
    private Session s;
    private Entidad e;
    public int setID;

    /**
     * Creates new form Registrar_Entidad
     */
    public Dialog_Entidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        setLocationRelativeTo(null);
        estadoBtn();

    }
    
        private void editar(){
            SessionFactory factor = HibernateUtil.getSessionFactory();
            s = factor.openSession();
            Criteria c = s.createCriteria(Entidad.class).add(Restrictions.eq("idEntidad", panelCatalogo.ID)); 
            for (Object entidad : c.list()) {
             e = (Entidad) entidad;
             this.txtPrimerNombre.setText(e.getNombre());
             this.txtRUC.setText(String.valueOf(e.getRuc()));
             this.txtPrimerNombre.setEditable(false);
             this.txtRUC.setEditable(false);
             
    }
    }
    
        private void nuevo(){
            BackendInserts.InsertarEntidad(this.txtPrimerNombre.getText(), this.txtDireccion.getText(), this.txtTelefono.getText(), this.txtRUC.getText());            
            var = false;
            this.dispose();
    }
    
    private void estadoBtn(){
        if(var == true){
            editar();
            

        }
        
        else if(var == false){
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pInferior = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        pSuperior = new javax.swing.JPanel();
        pDatosUsuario = new javax.swing.JPanel();
        txtPrimerNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtRUC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pInferior.setBackground(new java.awt.Color(42, 42, 42));
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

        btnOK.setBackground(new java.awt.Color(100, 221, 23));
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
        pDatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 12), new java.awt.Color(250, 250, 250))); // NOI18N
        pDatosUsuario.setForeground(new java.awt.Color(255, 255, 255));

        txtPrimerNombre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtRUC.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel2.setText("Direccion");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel3.setText("Telefono");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jLabel4.setText("RUC");

        javax.swing.GroupLayout pDatosUsuarioLayout = new javax.swing.GroupLayout(pDatosUsuario);
        pDatosUsuario.setLayout(pDatosUsuarioLayout);
        pDatosUsuarioLayout.setHorizontalGroup(
            pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosUsuarioLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrimerNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtRUC, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(50, 50, 50))
        );
        pDatosUsuarioLayout.setVerticalGroup(
            pDatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pSuperior.add(pDatosUsuario, java.awt.BorderLayout.CENTER);

        getContentPane().add(pSuperior, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if(var == true){
            s.close();
        }
        
        else{
            
        }
        var = false;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        
            if(var == true){
            BackendUpdate.EditarEntidad(String.valueOf(e.getIdEntidad()), this.txtDireccion.getText(), this.txtTelefono.getText());
            s.close();
            this.dispose();
        }
        
           else if(var == false){
               nuevo();
           }
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
            java.util.logging.Logger.getLogger(Dialog_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_Entidad dialog = new Dialog_Entidad(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pDatosUsuario;
    private javax.swing.JPanel pInferior;
    private javax.swing.JPanel pSuperior;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtRUC;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
