package vista;

import java.awt.Color;

public class VistaRegistro extends javax.swing.JPanel {

    public VistaRegistro() {
        initComponents();
        btnEliminar.setEnabled(false);
        btnRetirar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEspacios = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnRetirar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTicket = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEspacios.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblEspacios.setForeground(new java.awt.Color(51, 0, 153));
        lblEspacios.setText("120");
        add(lblEspacios, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 70, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa: ");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, -1, -1));
        add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 160, 30));

        btnIngresar.setBackground(new java.awt.Color(0, 51, 102));
        btnIngresar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresarMouseExited(evt);
            }
        });
        add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 110, 30));
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 160, 30));

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
        add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Buscar:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        btnRetirar.setBackground(new java.awt.Color(0, 51, 102));
        btnRetirar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnRetirar.setForeground(new java.awt.Color(255, 255, 255));
        btnRetirar.setText("RETIRAR VEHICULO");
        btnRetirar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetirarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetirarMouseExited(evt);
            }
        });
        add(btnRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, 180, 30));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("____________________________________________________________________________________________________________________________________________");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 700, 20));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("______________________________________________________________________________________________");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("INGRESO  DE VEHICULOS");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

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

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 700, 330));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 0, 153));
        jLabel17.setText("ESPACIOS LIBRES:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 20));

        btnEliminar.setBackground(new java.awt.Color(0, 51, 102));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR FILA");
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
        btnIngresar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnIngresarMouseEntered

    private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
        btnIngresar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnIngresarMouseExited

    private void btnMostrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseEntered
        btnMostrar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnMostrarMouseEntered

    private void btnMostrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarMouseExited
        btnMostrar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnMostrarMouseExited

    private void btnRetirarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetirarMouseEntered
        btnRetirar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnRetirarMouseEntered

    private void btnRetirarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetirarMouseExited
        btnRetirar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnRetirarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnIngresar;
    public javax.swing.JButton btnMostrar;
    public javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel lblEspacios;
    public javax.swing.JTable tblTicket;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
