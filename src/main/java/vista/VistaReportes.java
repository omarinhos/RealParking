package vista;

import java.awt.Color;

public class VistaReportes extends javax.swing.JPanel {

    public VistaReportes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        cmbUsuarios = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblIngresos = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jDateDesde = new com.toedter.calendar.JDateChooser();
        jDateHasta = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        lblVehiculos = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Desde:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        btnExportar.setBackground(new java.awt.Color(0, 51, 102));
        btnExportar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnExportar.setForeground(new java.awt.Color(255, 255, 255));
        btnExportar.setText("EXPORTAR ");
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExportarMouseExited(evt);
            }
        });
        add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 120, 30));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("__________________________________________________________________________________");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Usuario:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

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
        add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 120, 30));

        cmbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Omar", "Paolo", "Arturo" }));
        add(cmbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 150, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Hasta:");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("REPORTES DE VENTAS");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 40));

        lblIngresos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIngresos.setForeground(new java.awt.Color(102, 102, 102));
        lblIngresos.setText("--");
        add(lblIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 40, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Total de ingresos   : S/");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 290, 20));
        add(jDateDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 150, 30));
        add(jDateHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 150, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Total de vehiculos :  ");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 190, 20));

        lblVehiculos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblVehiculos.setForeground(new java.awt.Color(102, 102, 102));
        lblVehiculos.setText("--");
        add(lblVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 40, 20));

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblVentas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblVentas.setFocusable(false);
        tblVentas.setGridColor(new java.awt.Color(0, 51, 102));
        tblVentas.setRowHeight(25);
        tblVentas.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblVentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblVentas.getTableHeader().setResizingAllowed(false);
        tblVentas.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblVentas);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 700, 330));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseEntered
        btnExportar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnExportarMouseEntered

    private void btnExportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseExited
        btnExportar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnExportarMouseExited

    private void btnMostrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseEntered
        btnMostrar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnMostrarMouseEntered

    private void btnMostrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseExited
        btnMostrar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnMostrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportar;
    public javax.swing.JButton btnMostrar;
    public javax.swing.JComboBox<String> cmbUsuarios;
    public com.toedter.calendar.JDateChooser jDateDesde;
    public com.toedter.calendar.JDateChooser jDateHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel lblIngresos;
    public javax.swing.JLabel lblVehiculos;
    public javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
