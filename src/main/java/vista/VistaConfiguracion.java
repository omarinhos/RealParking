package vista;

import java.awt.Color;

public class VistaConfiguracion extends javax.swing.JPanel {

    public VistaConfiguracion() {
        initComponents();
        dlgContacto.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgContacto = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAsunto = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtRUC = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNombreComercial = new javax.swing.JTextField();
        txtTarifa = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtEspacios = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnContacto = new javax.swing.JButton();

        dlgContacto.setTitle("Contacto");
        dlgContacto.setBackground(new java.awt.Color(255, 255, 255));
        dlgContacto.setModal(true);
        dlgContacto.setResizable(false);
        dlgContacto.setSize(new java.awt.Dimension(400, 400));
        dlgContacto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Nombre");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("E-mail");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Mensaje");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("Asunto");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("CONTACTO");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, 30));

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        jScrollPane1.setViewportView(txtMensaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 240, -1));

        btnEnviar.setBackground(new java.awt.Color(0, 51, 102));
        btnEnviar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("ENVIAR");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnviarMouseExited(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 130, 30));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 240, 30));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 240, 30));

        txtAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAsuntoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 240, 30));

        dlgContacto.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("CONFIGURACIÓN DEL SISTEMA");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Razón Social :");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        txtRazonSocial.setEnabled(false);
        add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 160, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("r.u..c. :");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        txtRUC.setEnabled(false);
        add(txtRUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 160, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Nombre comercial :");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Tarfica unica:");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 20));

        txtNombreComercial.setEnabled(false);
        add(txtNombreComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 160, 30));

        txtTarifa.setEnabled(false);
        add(txtTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 160, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 120, -1));

        btnModificar.setBackground(new java.awt.Color(0, 51, 102));
        btnModificar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 120, -1));

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("____________________________________________________________________________________________________________________");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Espacios disponibles:");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 20));

        txtEspacios.setEnabled(false);
        add(txtEspacios, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 160, 30));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 620, -1, 20));

        btnContacto.setBackground(new java.awt.Color(0, 51, 102));
        btnContacto.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnContacto.setForeground(new java.awt.Color(255, 255, 255));
        btnContacto.setText("CONTACTO");
        btnContacto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContactoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContactoMouseExited(evt);
            }
        });
        btnContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactoActionPerformed(evt);
            }
        });
        add(btnContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 120, -1));
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

    private void btnContactoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContactoMouseEntered

    private void btnContactoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContactoMouseExited

    private void btnContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContactoActionPerformed

    private void btnEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseEntered
        btnGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnEnviarMouseEntered

    private void btnEnviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseExited
        btnGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnEnviarMouseExited

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAsuntoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnContacto;
    public javax.swing.JButton btnEnviar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    public javax.swing.JDialog dlgContacto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtAsunto;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtEspacios;
    public javax.swing.JTextArea txtMensaje;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNombreComercial;
    public javax.swing.JTextField txtRUC;
    public javax.swing.JTextField txtRazonSocial;
    public javax.swing.JTextField txtTarifa;
    // End of variables declaration//GEN-END:variables
}
