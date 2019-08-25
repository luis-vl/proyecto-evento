/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.POJO.*;
import java.awt.CardLayout;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author luisv
 */
public class Dialog_Evento extends javax.swing.JDialog {

    private final CardLayout clayout;

    /**
     * Creates new form DialogEvento
     *
     * @param parent
     * @param modal
     */
    public Dialog_Evento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        clayout = (CardLayout) pCards.getLayout();

        spCliente.addChangeListener((ChangeEvent e) -> {
            setPorcentaje((JSpinner) e.getSource());
        });
        spTeatro.addChangeListener((ChangeEvent e) -> {
            setPorcentaje((JSpinner) e.getSource());
        });
    }

    private void setPorcentaje(JSpinner spinner) {
        Integer val = (Integer) spinner.getValue();
        Integer porcentaje = 100 - val;

        if (spinner == spCliente) {
            spTeatro.getModel().setValue(porcentaje);
        } else {
            spCliente.getModel().setValue(porcentaje);
        }
    }
    
    private void setSalon() {
        System.out.println("Salon: "+tSalon.getSelectedRow());
        
    }
    
    private void setServicio() {
        System.out.println("Servicio: " + Arrays.toString(tServicios.getSelectedRows()));
    }

    private void getCampos() {
        Evento evento = new Evento();
        evento.setNombre(txtNombreEvt.getText());
        evento.setCliente(cliente);
        evento.setFechaEvento(getFechaEvt());
        evento.setDuracion((Integer) spDuracion.getValue());
        evento.setCantidadPersonas((Integer) spCantPersonas.getValue());
        evento.setSalon(salon);
        evento.setPrecioBoleto((Float) spPrecio.getValue());
        evento.setPorcentCliente((Float) spCliente.getValue()/100);
        evento.setPorcentTeatro((Float) spTeatro.getValue()/100);
        evento.setFechaRegistro(new Date());
        
        EventoServicio es = new EventoServicio();
        es.setEvento(evento);
        es.setServicio(servicio);
        es.setPrecio(servicio.getPrecio());
        es.setFechaRegistro(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pCards = new javax.swing.JPanel();
        pNombreEvt = new javax.swing.JPanel();
        txtNombreEvt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnNewCliente = new javax.swing.JButton();
        btnFindCliente = new javax.swing.JButton();
        pDatos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxHora = new javax.swing.JComboBox<>();
        cbxMinutos = new javax.swing.JComboBox<>();
        cbxPeriodo = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spDuracion = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spCantPersonas = new javax.swing.JSpinner();
        pSalon = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tSalon = new javax.swing.JTable();
        pBoleto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        spCliente = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        spTeatro = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pServicios = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tServicios = new javax.swing.JTable();
        pButtons = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pCards.setLayout(new java.awt.CardLayout());

        pNombreEvt.setBackground(new java.awt.Color(57, 60, 76));

        txtNombreEvt.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nombre del Evento");

        javax.swing.GroupLayout pNombreEvtLayout = new javax.swing.GroupLayout(pNombreEvt);
        pNombreEvt.setLayout(pNombreEvtLayout);
        pNombreEvtLayout.setHorizontalGroup(
            pNombreEvtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(pNombreEvtLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(txtNombreEvt)
                .addGap(82, 82, 82))
        );
        pNombreEvtLayout.setVerticalGroup(
            pNombreEvtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pNombreEvtLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtNombreEvt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pCards.add(pNombreEvt, "card2");

        pCliente.setBackground(new java.awt.Color(57, 60, 76));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese los Datos del Cliente");

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        txtCliente.setText("Pepe José Luna");

        btnNewCliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnNewCliente.setText("Nuevo Cliente");

        btnFindCliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnFindCliente.setText("Buscar Cliente");

        javax.swing.GroupLayout pClienteLayout = new javax.swing.GroupLayout(pCliente);
        pCliente.setLayout(pClienteLayout);
        pClienteLayout.setHorizontalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pClienteLayout.createSequentialGroup()
                        .addComponent(btnNewCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(144, 144, 144)
                        .addComponent(btnFindCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                    .addComponent(txtCliente))
                .addGap(77, 77, 77))
        );
        pClienteLayout.setVerticalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pCards.add(pCliente, "card3");

        pDatos.setBackground(new java.awt.Color(57, 60, 76));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Datos del Evento");

        cbxHora.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        cbxMinutos.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbxMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50" }));

        cbxPeriodo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbxPeriodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));

        jTextField3.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jTextField3.setText("10/02/2019");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel4.setText("Fecha");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setText("Hora");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel6.setText("Minutos");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setText("Duración");

        spDuracion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spDuracion.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel8.setText("horas");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel9.setText("Cantidad de personas");

        spCantPersonas.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spCantPersonas.setModel(new javax.swing.SpinnerNumberModel(10, 5, null, 10));

        javax.swing.GroupLayout pDatosLayout = new javax.swing.GroupLayout(pDatos);
        pDatos.setLayout(pDatosLayout);
        pDatosLayout.setHorizontalGroup(
            pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pDatosLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(pDatosLayout.createSequentialGroup()
                        .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDatosLayout.createSequentialGroup()
                                .addComponent(cbxMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)))
                    .addGroup(pDatosLayout.createSequentialGroup()
                        .addComponent(spDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spCantPersonas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        pDatosLayout.setVerticalGroup(
            pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDatosLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spCantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pCards.add(pDatos, "card4");

        pSalon.setBackground(new java.awt.Color(57, 60, 76));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Seleccione el Salón");

        tSalon.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tSalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOMBRE", "CAPACIDAD", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tSalon.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tSalon);

        javax.swing.GroupLayout pSalonLayout = new javax.swing.GroupLayout(pSalon);
        pSalon.setLayout(pSalonLayout);
        pSalonLayout.setHorizontalGroup(
            pSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pSalonLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        pSalonLayout.setVerticalGroup(
            pSalonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSalonLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        pCards.add(pSalon, "card5");

        pBoleto.setBackground(new java.awt.Color(57, 60, 76));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Boleto");

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel12.setText("Precio del boleto");

        spPrecio.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));

        spCliente.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spCliente.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setText("Porcentaje del cliente");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setText("Porcentaje del teatro");

        spTeatro.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spTeatro.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel15.setText("%");

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jLabel16.setText("%");

        javax.swing.GroupLayout pBoletoLayout = new javax.swing.GroupLayout(pBoleto);
        pBoleto.setLayout(pBoletoLayout);
        pBoletoLayout.setHorizontalGroup(
            pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBoletoLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(spCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93))
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(spTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pBoletoLayout.setVerticalGroup(
            pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBoletoLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(pBoletoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spTeatro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(0, 179, Short.MAX_VALUE))
        );

        pCards.add(pBoleto, "card6");

        pServicios.setBackground(new java.awt.Color(57, 60, 76));

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Servicios (opcional)");

        tServicios.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        tServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "NOMBRE SERVICIO", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tServicios.setPreferredSize(new java.awt.Dimension(500, 64));
        tServicios.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(tServicios);

        javax.swing.GroupLayout pServiciosLayout = new javax.swing.GroupLayout(pServicios);
        pServicios.setLayout(pServiciosLayout);
        pServiciosLayout.setHorizontalGroup(
            pServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pServiciosLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(94, 94, 94))
        );
        pServiciosLayout.setVerticalGroup(
            pServiciosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pServiciosLayout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        pCards.add(pServicios, "card7");

        getContentPane().add(pCards, java.awt.BorderLayout.CENTER);

        pButtons.setLayout(new java.awt.GridLayout(1, 0));

        btnAnterior.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        btnAnterior.setText("Cancelar");
        btnAnterior.setPreferredSize(new java.awt.Dimension(0, 50));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pButtons.add(btnAnterior);

        btnSiguiente.setBackground(new java.awt.Color(100, 221, 23));
        btnSiguiente.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        btnSiguiente.setText("Siguente");
        btnSiguiente.setPreferredSize(new java.awt.Dimension(0, 50));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pButtons.add(btnSiguiente);

        getContentPane().add(pButtons, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        if (btnAnterior.getText().equals("Cancelar")) {
            this.dispose();
        }
        if (pCliente.isShowing()) {
            btnAnterior.setText("Cancelar");
        }
        if (!pNombreEvt.isShowing()) {
            clayout.previous(pCards);
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        if (pServicios.isShowing()) {
            try {
                setSalon();
                setServicio();
                Thread.sleep(1000);
                JOptionPane.showMessageDialog(this, "Se guardó con Exito!!!");
                this.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dialog_Evento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            btnAnterior.setText("Anterior");
            clayout.next(pCards);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(Dialog_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog_Evento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Dialog_Evento dialog = new Dialog_Evento(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnFindCliente;
    private javax.swing.JButton btnNewCliente;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxHora;
    private javax.swing.JComboBox<String> cbxMinutos;
    private javax.swing.JComboBox<String> cbxPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pBoleto;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pCards;
    private javax.swing.JPanel pCliente;
    private javax.swing.JPanel pDatos;
    private javax.swing.JPanel pNombreEvt;
    private javax.swing.JPanel pSalon;
    private javax.swing.JPanel pServicios;
    private javax.swing.JSpinner spCantPersonas;
    private javax.swing.JSpinner spCliente;
    private javax.swing.JSpinner spDuracion;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JSpinner spTeatro;
    private javax.swing.JTable tSalon;
    private javax.swing.JTable tServicios;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtNombreEvt;
    // End of variables declaration//GEN-END:variables
}
