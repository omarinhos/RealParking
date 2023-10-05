package vista;

import java.awt.Color;

public class VistaUsuarios extends javax.swing.JPanel {
   
    public VistaUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel18 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jLabel27 = new javax.swing.JLabel();
        txtPassRe = new javax.swing.JPasswordField();
        btnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        cmbCargo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nombre Completo:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 230, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Estado:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, 30));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Ingresar DNI");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, 30));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 230, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 130, 30));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("____________________________________________________________________________________________");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 730, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("REGISTRO DE USUARIOS");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Contraseña:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));
        add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 230, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Repetir contraseña:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));
        add(txtPassRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 230, 30));

        btnModificar.setBackground(new java.awt.Color(0, 51, 102));
        btnModificar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 130, 30));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblUsuarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblUsuarios.setFocusable(false);
        tblUsuarios.setGridColor(new java.awt.Color(0, 51, 102));
        tblUsuarios.setRowHeight(25);
        tblUsuarios.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblUsuarios.getTableHeader().setResizingAllowed(false);
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblUsuarios);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 700, 230));

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Digitador", "Cajero", "Prueba", "Abogado" }));
        add(cmbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 230, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Cargo: ");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        btnNuevo.setBackground(new java.awt.Color(0, 51, 102));
        btnNuevo.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO");
        btnNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoMouseExited(evt);
            }
        });
        add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 130, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Dni:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, 30));
        add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 160, 30));

        btnFiltrar.setBackground(new java.awt.Color(0, 51, 102));
        btnFiltrar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("FILTRAR");
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 130, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        btnGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        btnGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        btnModificar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        btnModificar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseEntered
        btnModificar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnNuevoMouseEntered

    private void btnNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoMouseExited
        btnModificar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnNuevoMouseExited

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        btnModificar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        btnModificar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnFiltrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JComboBox<String> cmbCargo;
    public javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblUsuarios;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtFiltro;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JPasswordField txtPassRe;
    // End of variables declaration//GEN-END:variables
}
