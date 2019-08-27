/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Paneles;

import Modelo.*;
import Vista.*;
import javax.swing.JFrame;

/**
 *
 * @author luisv
 */
public class panelEventos extends javax.swing.JPanel {
    

    /**
     * Creates new form panelEventos
     */
    public panelEventos() {
        initComponents();
        new ModelEvento(tEventos).cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tEventos = new javax.swing.JTable();
        pBotonesEvento = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        cbFiltro = new javax.swing.JComboBox<>();
        panelEspacio1 = new javax.swing.JPanel();
        txtBuscarEvento = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEditEvento = new javax.swing.JButton();
        btnBorrarEvento = new javax.swing.JButton();
        pDetallleEvento = new javax.swing.JPanel();
        pBoletos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblTotalVentas = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pVendidos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblVendidos = new javax.swing.JLabel();
        pPendientes = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPendientes = new javax.swing.JLabel();
        pPrecios = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPrecSalon = new javax.swing.JTextField();
        txtPorTeatro = new javax.swing.JTextField();
        txtPorCliente = new javax.swing.JTextField();
        txtPrecBoleto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tEventos.setBackground(new java.awt.Color(56, 60, 76));
        tEventos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tEventos.setForeground(new java.awt.Color(240, 240, 240));
        tEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Cliente", "Salón", "Inicio", "Finaliza", "# de Personas"
            }
        ));
        jScrollPane1.setViewportView(tEventos);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pBotonesEvento.setBackground(new java.awt.Color(42, 42, 42));
        pBotonesEvento.setLayout(new javax.swing.BoxLayout(pBotonesEvento, javax.swing.BoxLayout.X_AXIS));

        btnAgregar.setBackground(new java.awt.Color(100, 221, 23));
        btnAgregar.setText("Agregar");
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pBotonesEvento.add(btnAgregar);

        cbFiltro.setBackground(new java.awt.Color(57, 105, 138));
        cbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar por..", "Nombre", "Cliente", "Fecha", "Duracion", "Cantidad" }));
        cbFiltro.setMaximumSize(new java.awt.Dimension(200, 32767));
        cbFiltro.setPreferredSize(new java.awt.Dimension(200, 20));
        pBotonesEvento.add(cbFiltro);

        panelEspacio1.setBackground(new java.awt.Color(42, 42, 42));
        panelEspacio1.setMinimumSize(new java.awt.Dimension(10, 100));
        panelEspacio1.setPreferredSize(new java.awt.Dimension(10, 24));

        javax.swing.GroupLayout panelEspacio1Layout = new javax.swing.GroupLayout(panelEspacio1);
        panelEspacio1.setLayout(panelEspacio1Layout);
        panelEspacio1Layout.setHorizontalGroup(
            panelEspacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        panelEspacio1Layout.setVerticalGroup(
            panelEspacio1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pBotonesEvento.add(panelEspacio1);

        txtBuscarEvento.setText("Buscar...");
        txtBuscarEvento.setMaximumSize(new java.awt.Dimension(350, 2147483647));
        txtBuscarEvento.setPreferredSize(new java.awt.Dimension(350, 20));
        pBotonesEvento.add(txtBuscarEvento);

        btnBuscar.setBackground(new java.awt.Color(57, 105, 138));
        btnBuscar.setText("Buscar");
        pBotonesEvento.add(btnBuscar);

        btnEditEvento.setBackground(new java.awt.Color(57, 105, 138));
        btnEditEvento.setText("Editar");
        btnEditEvento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnEditEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEventoActionPerformed(evt);
            }
        });
        pBotonesEvento.add(btnEditEvento);

        btnBorrarEvento.setBackground(new java.awt.Color(57, 105, 138));
        btnBorrarEvento.setText("Borrar");
        btnBorrarEvento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pBotonesEvento.add(btnBorrarEvento);

        add(pBotonesEvento, java.awt.BorderLayout.NORTH);

        pDetallleEvento.setBackground(new java.awt.Color(42, 42, 42));
        pDetallleEvento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 12), new java.awt.Color(250, 250, 250))); // NOI18N
        pDetallleEvento.setPreferredSize(new java.awt.Dimension(300, 401));
        pDetallleEvento.setLayout(new javax.swing.BoxLayout(pDetallleEvento, javax.swing.BoxLayout.PAGE_AXIS));

        pBoletos.setBackground(new java.awt.Color(42, 42, 42));
        pBoletos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Boletos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans", 0, 11), new java.awt.Color(250, 250, 250))); // NOI18N
        pBoletos.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        pBoletos.setMinimumSize(new java.awt.Dimension(10, 200));
        pBoletos.setPreferredSize(new java.awt.Dimension(0, 200));
        pBoletos.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(42, 42, 42));
        jPanel4.setPreferredSize(new java.awt.Dimension(276, 60));

        jLabel6.setFont(new java.awt.Font("HP Simplified", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(250, 250, 250));
        jLabel6.setText("Total Ventas:");

        lblTotalVentas.setFont(new java.awt.Font("HP Simplified", 1, 20)); // NOI18N
        lblTotalVentas.setForeground(new java.awt.Color(250, 250, 250));
        lblTotalVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalVentas.setText("$ 00.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalVentas)
                .addContainerGap())
        );

        pBoletos.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(56, 60, 76));
        jPanel6.setMaximumSize(new java.awt.Dimension(65534, 80));
        jPanel6.setPreferredSize(new java.awt.Dimension(276, 80));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        pVendidos.setBackground(new java.awt.Color(56, 60, 76));

        jLabel2.setFont(new java.awt.Font("HP Simplified", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vendidos");

        lblVendidos.setFont(new java.awt.Font("HP Simplified", 0, 20)); // NOI18N
        lblVendidos.setForeground(new java.awt.Color(250, 250, 250));
        lblVendidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVendidos.setText("0");

        javax.swing.GroupLayout pVendidosLayout = new javax.swing.GroupLayout(pVendidos);
        pVendidos.setLayout(pVendidosLayout);
        pVendidosLayout.setHorizontalGroup(
            pVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        pVendidosLayout.setVerticalGroup(
            pVendidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVendidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(pVendidos);

        pPendientes.setBackground(new java.awt.Color(56, 60, 76));

        jLabel4.setFont(new java.awt.Font("HP Simplified", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(250, 250, 250));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pendientes");

        lblPendientes.setFont(new java.awt.Font("HP Simplified", 0, 20)); // NOI18N
        lblPendientes.setForeground(new java.awt.Color(250, 250, 250));
        lblPendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendientes.setText("0");

        javax.swing.GroupLayout pPendientesLayout = new javax.swing.GroupLayout(pPendientes);
        pPendientes.setLayout(pPendientesLayout);
        pPendientesLayout.setHorizontalGroup(
            pPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        pPendientesLayout.setVerticalGroup(
            pPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPendientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(pPendientes);

        pBoletos.add(jPanel6, java.awt.BorderLayout.CENTER);

        pDetallleEvento.add(pBoletos);

        pPrecios.setBackground(new java.awt.Color(42, 42, 42));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(250, 250, 250));
        jLabel8.setText("Precio del Boleto");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 250, 250));
        jLabel9.setText("Porcentaje del Cliente");

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 250, 250));
        jLabel10.setText("Porcentaje del Teatro");

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(250, 250, 250));
        jLabel11.setText("Precio del Salón");

        txtPrecSalon.setEditable(false);
        txtPrecSalon.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtPorTeatro.setEditable(false);
        txtPorTeatro.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtPorCliente.setEditable(false);
        txtPorCliente.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtPrecBoleto.setEditable(false);
        txtPrecBoleto.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(100, 221, 23));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("VENDER BOLETO");

        javax.swing.GroupLayout pPreciosLayout = new javax.swing.GroupLayout(pPrecios);
        pPrecios.setLayout(pPreciosLayout);
        pPreciosLayout.setHorizontalGroup(
            pPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecBoleto)
                    .addGroup(pPreciosLayout.createSequentialGroup()
                        .addGroup(pPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPorCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPorTeatro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPrecSalon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pPreciosLayout.setVerticalGroup(
            pPreciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPreciosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPorTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pDetallleEvento.add(pPrecios);

        add(pDetallleEvento, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        Dialog_Evento de = new Dialog_Evento((JFrame) this.getRootPane().getParent(), true);
        de.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEventoActionPerformed
        // TODO add your handling code here:
        if(tEventos.getSelectedRow() < 0) return;
        Dialog_Evento de = new Dialog_Evento((JFrame) this.getRootPane().getParent(), true);
        de.setVisible(true);
    }//GEN-LAST:event_btnEditEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrarEvento;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditEvento;
    private javax.swing.JComboBox<String> cbFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPendientes;
    private javax.swing.JLabel lblTotalVentas;
    private javax.swing.JLabel lblVendidos;
    private javax.swing.JPanel pBoletos;
    private javax.swing.JPanel pBotonesEvento;
    private javax.swing.JPanel pDetallleEvento;
    private javax.swing.JPanel pPendientes;
    private javax.swing.JPanel pPrecios;
    private javax.swing.JPanel pVendidos;
    private javax.swing.JPanel panelEspacio1;
    private javax.swing.JTable tEventos;
    private javax.swing.JTextField txtBuscarEvento;
    private javax.swing.JTextField txtPorCliente;
    private javax.swing.JTextField txtPorTeatro;
    private javax.swing.JTextField txtPrecBoleto;
    private javax.swing.JTextField txtPrecSalon;
    // End of variables declaration//GEN-END:variables
}
