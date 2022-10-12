package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import recursos.TextPrompt;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        TextPrompt txtUserTP = new TextPrompt("Ingrese su Dni", txtUser);
        TextPrompt txtPassTP = new TextPrompt("Ingrese su Contraseña", txtPass);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JLabel();
        btnMin = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btniniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setText("x");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 50, 35));

        btnMin.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        btnMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMin.setText("-");
        btnMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMin.setOpaque(true);
        btnMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinMouseExited(evt);
            }
        });
        getContentPane().add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 50, 35));

        header.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        header.setEnabled(false);
        header.setOpaque(true);
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 35));

        jPanel1.setBackground(new java.awt.Color(3, 24, 77));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon((new ImageIcon("src/main/java/images/LogoRealParking.png")));
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 70, 420, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 360, 413));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 290, 10));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 300, 20));

        jLabel2.setBackground(new java.awt.Color(51, 0, 153));
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Gestión de parqueo vehicular");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 260, 40));

        jLabel8.setBackground(new java.awt.Color(51, 0, 153));
        jLabel8.setFont(new java.awt.Font("Yu Gothic", 1, 45)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 153));
        jLabel8.setText("INICIAR SESION");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtUser.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtUser.setBorder(null);
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 300, 35));

        txtPass.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtPass.setBorder(null);
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 300, 35));

        btniniciar.setBackground(new java.awt.Color(3, 24, 77));
        btniniciar.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        btniniciar.setForeground(new java.awt.Color(255, 255, 255));
        btniniciar.setText("INGRESAR");
        btniniciar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 153), 1, true));
        btniniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btniniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btniniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btniniciarMouseExited(evt);
            }
        });
        jPanel2.add(btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 170, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 35, 420, 413));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headerMouseDragged
    int xx, xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void btnMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinMouseClicked

    private void btnMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseEntered
        btnMin.setBackground(new Color(230, 230, 230));
    }//GEN-LAST:event_btnMinMouseEntered

    private void btnMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseExited
        btnMin.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnMinMouseExited

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(new Color(139, 0, 0));
        btnCerrar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(242, 242, 242));
        btnCerrar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btniniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btniniciarMouseEntered
        btniniciar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btniniciarMouseEntered

    private void btniniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btniniciarMouseExited
        btniniciar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btniniciarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnCerrar;
    public javax.swing.JLabel btnMin;
    public javax.swing.JButton btniniciar;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
