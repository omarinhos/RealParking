package vista;

import java.awt.Color;

public class VistaCaja extends javax.swing.JPanel {

    public VistaCaja() {
        initComponents();
        dlgVentas.setLocationRelativeTo(null);
        dlgIncidente.setLocationRelativeTo(null);
        btnGenerarPago.setEnabled(false);
        btnRegistrarIncidente.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgVentas = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblIngresos = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblVehículos = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        dlgIncidente = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        btnGenerarComprobanteDlg = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        lblTarifa = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnRegistrarIncidente = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnGenerarPago = new javax.swing.JButton();
        btnVentasDia = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTicket = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        dlgVentas.setTitle("Ventas del Día");
        dlgVentas.setModal(true);
        dlgVentas.setResizable(false);
        dlgVentas.setSize(new java.awt.Dimension(900, 600));
        dlgVentas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIngresos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblIngresos.setForeground(new java.awt.Color(51, 0, 153));
        lblIngresos.setText("--");
        jPanel1.add(lblIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 230, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 0, 153));
        jLabel20.setText("Total de Vehículos  :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 0, 153));
        jLabel21.setText("Total de Ingresos   :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 240, 30));

        lblVehículos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblVehículos.setForeground(new java.awt.Color(51, 0, 153));
        lblVehículos.setText("--");
        jPanel1.add(lblVehículos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 230, 20));

        jScrollPane7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblVentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblVentas.setFocusable(false);
        tblVentas.setGridColor(new java.awt.Color(0, 51, 102));
        tblVentas.setRowHeight(25);
        tblVentas.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblVentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblVentas.getTableHeader().setResizingAllowed(false);
        tblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tblVentas);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 840, 430));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, -1, -1));

        dlgVentas.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        dlgIncidente.setTitle("Registrar Incidente");
        dlgIncidente.setModal(true);
        dlgIncidente.setResizable(false);
        dlgIncidente.setSize(new java.awt.Dimension(500, 300));
        dlgIncidente.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarComprobanteDlg.setBackground(new java.awt.Color(0, 51, 102));
        btnGenerarComprobanteDlg.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGenerarComprobanteDlg.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarComprobanteDlg.setText("GENERAR COMPROBANTE");
        btnGenerarComprobanteDlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarComprobanteDlgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarComprobanteDlgMouseExited(evt);
            }
        });
        jPanel2.add(btnGenerarComprobanteDlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 153));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Pérdida de Ticket");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 90));
        jPanel2.add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 290, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("DNI:");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, -1));
        jPanel2.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 290, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Nombre Completo:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 140, -1));

        dlgIncidente.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 300));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTarifa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTarifa.setForeground(new java.awt.Color(102, 102, 102));
        lblTarifa.setText("-");
        add(lblTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 30, -1));
        add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 230, 30));

        btnMostrar.setBackground(new java.awt.Color(0, 51, 102));
        btnMostrar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMostrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMostrarMouseExited(evt);
            }
        });
        add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        btnRegistrarIncidente.setBackground(new java.awt.Color(0, 51, 102));
        btnRegistrarIncidente.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnRegistrarIncidente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarIncidente.setText("REGISTRAR INCIDENTE");
        btnRegistrarIncidente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarIncidenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarIncidenteMouseExited(evt);
            }
        });
        add(btnRegistrarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, 220, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CAJA");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        btnGenerarPago.setBackground(new java.awt.Color(0, 51, 102));
        btnGenerarPago.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGenerarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPago.setText("GENERAR PAGO");
        btnGenerarPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarPagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarPagoMouseExited(evt);
            }
        });
        add(btnGenerarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 590, 160, 30));

        btnVentasDia.setBackground(new java.awt.Color(0, 51, 102));
        btnVentasDia.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnVentasDia.setForeground(new java.awt.Color(255, 255, 255));
        btnVentasDia.setText("VENTAS DEL DIA");
        btnVentasDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasDiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasDiaMouseExited(evt);
            }
        });
        add(btnVentasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 160, 30));

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("________________________");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblTicket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblTicket.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblTicket.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTicket.setFocusable(false);
        tblTicket.setGridColor(new java.awt.Color(0, 51, 102));
        tblTicket.setRowHeight(25);
        tblTicket.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblTicket.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblTicket.getTableHeader().setResizingAllowed(false);
        tblTicket.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblTicket);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 700, 390));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, -1, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Buscar:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Tarifa : ");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseEntered
        btnMostrar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnMostrarMouseEntered

    private void btnMostrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseExited
        btnMostrar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnMostrarMouseExited

    private void btnRegistrarIncidenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarIncidenteMouseEntered
        btnRegistrarIncidente.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnRegistrarIncidenteMouseEntered

    private void btnRegistrarIncidenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarIncidenteMouseExited
        btnRegistrarIncidente.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnRegistrarIncidenteMouseExited

    private void btnGenerarPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseEntered
        btnGenerarPago.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGenerarPagoMouseEntered

    private void btnGenerarPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseExited
        btnGenerarPago.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGenerarPagoMouseExited

    private void btnVentasDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseEntered
        btnVentasDia.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnVentasDiaMouseEntered

    private void btnVentasDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseExited
        btnVentasDia.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnVentasDiaMouseExited

    private void btnGenerarComprobanteDlgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarComprobanteDlgMouseEntered
        btnVentasDia.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGenerarComprobanteDlgMouseEntered

    private void btnGenerarComprobanteDlgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarComprobanteDlgMouseExited
        btnVentasDia.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGenerarComprobanteDlgMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGenerarComprobanteDlg;
    public javax.swing.JButton btnGenerarPago;
    public javax.swing.JButton btnMostrar;
    public javax.swing.JButton btnRegistrarIncidente;
    public javax.swing.JButton btnVentasDia;
    public javax.swing.JDialog dlgIncidente;
    public javax.swing.JDialog dlgVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JLabel lblIngresos;
    public javax.swing.JLabel lblTarifa;
    public javax.swing.JLabel lblVehículos;
    public javax.swing.JTable tblTicket;
    public javax.swing.JTable tblVentas;
    public javax.swing.JTextField txtDNI;
    public javax.swing.JTextField txtNombreCompleto;
    public javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
