/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.HibernateUtil;
import Modelo.POJO.Salon;
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
public class Dialog_Salón extends javax.swing.JDialog {
    
    public static boolean var = false;
    private Session s;
    private Salon sl;
    public int setID;

    /**
     * Creates new form Registrar_Salón
     */
    public Dialog_Salón(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();        
        setLocationRelativeTo(null);
        estadoBtn();

    }
    
    private void editar(){
            SessionFactory factor = HibernateUtil.getSessionFactory();
            s = factor.openSession();
            Criteria c = s.createCriteria(Salon.class).add(Restrictions.eq("idSalon", panelCatalogo.ID)); 
            for (Object salon : c.list()) {
             sl = (Salon) salon;
             this.txtNombreSalon.setText(sl.getNombre());
             this.txtCapacidad.setText(String.valueOf(sl.getCapacidad()));
             this.txtPrecio.setText(String.valueOf(sl.getPrecio()));

             
    }
    }
    
        private void nuevo(){
            BackendInserts.InsertarSalon(this.txtNombreSalon.getText(), Integer.parseInt(this.txtCapacidad.getText()), Float.parseFloat(this.txtPrecio.getText()));
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

        pInferior = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        pSuperior = new javax.swing.JPanel();
        pInfoG = new javax.swing.JPanel();
        lblNombreSalon = new javax.swing.JLabel();
        lblCapacidad = new javax.swing.JLabel();
        txtNombreSalon = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        pInfoE = new javax.swing.JPanel();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dialogo Salón");
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

        pInfoG.setBackground(new java.awt.Color(57, 60, 76));
        pInfoG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 12), new java.awt.Color(250, 250, 250))); // NOI18N
        pInfoG.setForeground(new java.awt.Color(255, 255, 255));
        pInfoG.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pInfoG.setPreferredSize(new java.awt.Dimension(444, 150));

        lblNombreSalon.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblNombreSalon.setForeground(new java.awt.Color(207, 207, 207));
        lblNombreSalon.setText("Nombre del Salón");

        lblCapacidad.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblCapacidad.setForeground(new java.awt.Color(207, 207, 207));
        lblCapacidad.setText("Capacidad");

        txtNombreSalon.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtCapacidad.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        javax.swing.GroupLayout pInfoGLayout = new javax.swing.GroupLayout(pInfoG);
        pInfoG.setLayout(pInfoGLayout);
        pInfoGLayout.setHorizontalGroup(
            pInfoGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfoGLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pInfoGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCapacidad)
                    .addGroup(pInfoGLayout.createSequentialGroup()
                        .addComponent(txtCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addGap(150, 150, 150))
                    .addComponent(lblNombreSalon)
                    .addComponent(txtNombreSalon, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        pInfoGLayout.setVerticalGroup(
            pInfoGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfoGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreSalon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCapacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pSuperior.add(pInfoG, java.awt.BorderLayout.CENTER);

        pInfoE.setBackground(new java.awt.Color(57, 60, 76));
        pInfoE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 1, 12), new java.awt.Color(250, 250, 250))); // NOI18N
        pInfoE.setForeground(new java.awt.Color(255, 255, 255));
        pInfoE.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pInfoE.setPreferredSize(new java.awt.Dimension(517, 200));

        lblPrecio.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(207, 207, 207));
        lblPrecio.setText("Precio");

        txtPrecio.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        javax.swing.GroupLayout pInfoELayout = new javax.swing.GroupLayout(pInfoE);
        pInfoE.setLayout(pInfoELayout);
        pInfoELayout.setHorizontalGroup(
            pInfoELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfoELayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pInfoELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pInfoELayout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addGap(200, 200, 200))
                    .addGroup(pInfoELayout.createSequentialGroup()
                        .addComponent(lblPrecio)
                        .addGap(69, 69, 69))))
        );
        pInfoELayout.setVerticalGroup(
            pInfoELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pInfoELayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pSuperior.add(pInfoE, java.awt.BorderLayout.PAGE_END);

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
            BackendUpdate.EditarSalon(String.valueOf(sl.getIdSalon()), this.txtNombreSalon.getText(), this.txtCapacidad.getText(), this.txtPrecio.getText(), true);
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
            java.util.logging.Logger.getLogger(Dialog_Salón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Salón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Salón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Salón.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dialog_Salón dialog = new Dialog_Salón(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblCapacidad;
    private javax.swing.JLabel lblNombreSalon;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JPanel pInferior;
    private javax.swing.JPanel pInfoE;
    private javax.swing.JPanel pInfoG;
    private javax.swing.JPanel pSuperior;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtNombreSalon;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
