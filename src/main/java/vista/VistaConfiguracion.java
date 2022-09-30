/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Color;

/**
 *
 * @author Lenovo
 */
public class VistaConfiguracion extends javax.swing.JPanel {

    /**
     * Creates new form VistaConfiguracion
     */
    public VistaConfiguracion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 120, -1));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel40;
    public javax.swing.JTextField txtEspacios;
    public javax.swing.JTextField txtNombreComercial;
    public javax.swing.JTextField txtRUC;
    public javax.swing.JTextField txtRazonSocial;
    public javax.swing.JTextField txtTarifa;
    // End of variables declaration//GEN-END:variables
}
