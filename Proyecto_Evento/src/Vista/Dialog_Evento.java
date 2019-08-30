/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import Modelo.POJO.*;
import java.awt.CardLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import org.hibernate.Session;

/**
 *
 * @author luisv
 */
public class Dialog_Evento extends javax.swing.JDialog {

    private final CardLayout clayout;
    private Session session;
    private final ModelSalon salon;
    private final ModelServicio servicio;
    private Cliente cliente;
    private Evento evento;
    private ModelEvento_Servicio evtServicio;
    private ModelEvento mEvento;
    private boolean isEdit = false;

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

        salon = new ModelSalon(tSalon);
        salon.cargarDatos();
        servicio = new ModelServicio(tServicios);
        servicio.cargarDatos();

        evtServicio = new ModelEvento_Servicio();
        mEvento = new ModelEvento();
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
        setCampos(getEvento());
        tServicios.setEnabled(false);
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private void setPorcentaje(JSpinner spinner) {
        float val = (float) spinner.getValue();
        float porcentaje = 100 - val;

        if (spinner == spCliente) {
            spTeatro.getModel().setValue(porcentaje);
        } else {
            spCliente.getModel().setValue(porcentaje);
        }
    }

    public Evento getEvento() {
        return evento;
    }

    private Salon getSalon() {
        return salon.getAt(tSalon.getSelectedRow());
    }

    private Cliente getCliente() {
        return cliente;
    }

    private Date getFechaEvt() throws ParseException {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
            String dateInString = txtFecha.getText() + " "
                    + cbxHora.getSelectedItem().toString() + ":"
                    + cbxMinutos.getSelectedItem().toString() + ":00";
            date = sdf.parse(dateInString);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        return date;
    }

    private void setFechaEvt(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = sdf.format(date);
        txtFecha.setText(dateInString);
        cbxHora.setSelectedItem(date.getHours());
        cbxMinutos.setSelectedItem(date.getMinutes());
        
    }

    private Evento getDatosEvento() throws ParseException {
        Evento e = new Evento();
        e.setNombre(txtNombreEvt.getText());
        e.setCliente(getCliente());
        e.setFechaEvento(getFechaEvt());
        e.setDuracion((Integer) spDuracion.getValue());
        e.setCantidadPersonas((Integer) spCantPersonas.getValue());
        e.setSalon(getSalon());
        e.setPrecioBoleto((Float) spPrecio.getValue());
        e.setPorcentCliente((Float) spCliente.getValue() / 100);
        e.setPorcentTeatro((Float) spTeatro.getValue() / 100);
        e.setFechaRegistro(new Date());
        e.setPrecioSalon(getSalon().getPrecio());

        return e;
    }
    
    private Evento getEditEvento(Evento e) throws ParseException {
        e.setNombre(txtNombreEvt.getText());
        e.setCliente(getCliente());
        e.setFechaEvento(getFechaEvt());
        e.setDuracion((Integer) spDuracion.getValue());
        e.setCantidadPersonas((Integer) spCantPersonas.getValue());
        e.setSalon(getSalon());
        e.setPrecioBoleto((Float) spPrecio.getValue());
        e.setPorcentCliente((Float) spCliente.getValue() / 100);
        e.setPorcentTeatro((Float) spTeatro.getValue() / 100);
        e.setFechaRegistro(new Date());
        e.setPrecioSalon(getSalon().getPrecio());

        return e;
    }

    private void setCampos(Evento e) {
        txtNombreEvt.setText(e.getNombre());
        txtCliente.setText(e.getCliente().getNombre() + " " + e.getCliente().getApellido());
        setFechaEvt(e.getFechaEvento());
        spDuracion.setValue(e.getDuracion());
        spCantPersonas.setValue(e.getCantidadPersonas());
        spPrecio.setValue(e.getPrecioBoleto());
        spCliente.setValue(e.getPorcentCliente() * 100);
        spTeatro.setValue(e.getPorcentTeatro() * 100);
        setCliente(e.getCliente());
    }

    private void setServicios() {
        int rows = tServicios.getSelectedRows().length;
        for (int i = 0; i < rows; i++) {
            EventoServicio es = new EventoServicio();
            es.setId(new EventoServicioId(getEvento().getIdEvento(), servicio.getAt(i).getIdServicio()));
            es.setEvento(getEvento());
            es.setServicio(servicio.getAt(i));
            es.setPrecio(servicio.getAt(i).getPrecio());
            es.setFechaRegistro(new Date());
            evtServicio.addEvt_Servicio(es);
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

        pCards = new javax.swing.JPanel();
        pNombreEvt = new javax.swing.JPanel();
        txtNombreEvt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pCliente = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnFindCliente = new javax.swing.JButton();
        pDatos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbxHora = new javax.swing.JComboBox<>();
        cbxMinutos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spDuracion = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spCantPersonas = new javax.swing.JSpinner();
        txtFecha = new javax.swing.JFormattedTextField();
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
        txtNombreEvt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEvtKeyTyped(evt);
            }
        });

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

        btnFindCliente.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnFindCliente.setText("Buscar Cliente");
        btnFindCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pClienteLayout = new javax.swing.GroupLayout(pCliente);
        pCliente.setLayout(pClienteLayout);
        pClienteLayout.setHorizontalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(txtCliente)
                .addGap(77, 77, 77))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFindCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        pClienteLayout.setVerticalGroup(
            pClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pClienteLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnFindCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pCards.add(pCliente, "card3");

        pDatos.setBackground(new java.awt.Color(57, 60, 76));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Datos del Evento");

        cbxHora.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbxHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cbxMinutos.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbxMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50" }));

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

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFecha.setText(new SimpleDateFormat("dd-MMM-yyyy").format(new Date()));
        txtFecha.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N

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
                            .addComponent(jLabel4)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(pDatosLayout.createSequentialGroup()
                        .addComponent(spDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spCantPersonas, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(257, Short.MAX_VALUE))
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
                .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha))
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
        spPrecio.setModel(new javax.swing.SpinnerNumberModel(10.0f, 1.0f, null, 1.0f));

        spCliente.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spCliente.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(5.0f)));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel13.setText("Porcentaje del cliente");

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel14.setText("Porcentaje del teatro");

        spTeatro.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spTeatro.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(5.0f)));

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
                if (tSalon.getSelectedRow() < 0) {
                    return;
                }
                if (isEdit()) {
                    mEvento.updateEvento(getEditEvento(mEvento.getByID(getEvento().getIdEvento())));
                } else {
                    mEvento.addEvento(getDatosEvento());
                    mEvento = new ModelEvento();
                    setEvento(mEvento.getUltimo());
                    setServicios();
                }
                Thread.sleep(500);
                JOptionPane.showMessageDialog(this, "Se guardó con Exito!!!");
                this.dispose();
            } catch (InterruptedException | ParseException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                Logger.getLogger(Dialog_Evento.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            btnAnterior.setText("Anterior");
            clayout.next(pCards);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnFindClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindClienteActionPerformed
        // TODO add your handling code here:
        Dialog_BuscarCliente bc = new Dialog_BuscarCliente(this, true);
        bc.setVisible(true);
        setCliente(bc.getCliente());
        txtCliente.setText(cliente.getNombre() + " " + cliente.getApellido());
    }//GEN-LAST:event_btnFindClienteActionPerformed

    private void txtNombreEvtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEvtKeyTyped
        // TODO add your handling code here:
            char c=evt.getKeyChar(); 
             
         
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
             JOptionPane.showMessageDialog(null, "Ingrese solo letras");
               
          } 
    }//GEN-LAST:event_txtNombreEvtKeyTyped

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
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbxHora;
    private javax.swing.JComboBox<String> cbxMinutos;
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
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNombreEvt;
    // End of variables declaration//GEN-END:variables
}
