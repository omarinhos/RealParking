package vista;

import java.awt.Color;

public class VistaRoles extends javax.swing.JPanel {

    public VistaRoles() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel41 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRol = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("REGISTRO DE ROLES");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("_____________________________________________________________________________");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 720, 20));
        add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Ingresar un rol");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, 30));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 146, 160, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Estado:");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 156, 60, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, 30));

        btnModificar.setBackground(new java.awt.Color(0, 51, 102));
        btnModificar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 120, 30));

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblRoles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRoles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRoles.setFocusable(false);
        tblRoles.setGridColor(new java.awt.Color(0, 51, 102));
        tblRoles.setRowHeight(25);
        tblRoles.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblRoles.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblRoles.getTableHeader().setResizingAllowed(false);
        tblRoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblRoles);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 700, 330));

        btnNuevo.setBackground(new java.awt.Color(0, 51, 102));
        btnNuevo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMouseExited(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 120, 30));

        btnFiltrar.setBackground(new java.awt.Color(0, 51, 102));
        btnFiltrar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("FILTRAR");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 120, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("Rol:");
        add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 96, -1, 30));
        add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseEntered
        btnGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnNuevoMouseEntered

    private void btnNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseExited
        btnGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnNuevoMouseExited

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        btnGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        btnGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnFiltrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    public javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTable tblRoles;
    public javax.swing.JTextField txtFiltro;
    public javax.swing.JTextField txtRol;
    // End of variables declaration//GEN-END:variables
}
