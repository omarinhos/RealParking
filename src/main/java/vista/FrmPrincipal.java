package vista;

import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmPrincipal extends javax.swing.JFrame {

    Color colorEntrar = new Color(0, 35, 71);
    Color colorSalir = new Color(0, 51, 102);
    
    
    public FrmPrincipal() {
        initComponents();

    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        btnMin = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        nav = new javax.swing.JPanel();
        txtRolActual = new javax.swing.JLabel();
        userFoto = new javax.swing.JLabel();
        txtUserActual = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JLabel();
        btnCaja = new javax.swing.JLabel();
        btnReportes = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JLabel();
        btnRoles = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Real Parking");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 0, true));
        fondo.setPreferredSize(new java.awt.Dimension(950, 670));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setText("x");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setOpaque(true);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        fondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 40));

        btnMin.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        btnMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMin.setText("-");
        btnMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMin.setOpaque(true);
        btnMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinMouseExited(evt);
            }
        });
        fondo.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 50, 40));

        header.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
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
        fondo.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 40));

        nav.setBackground(new java.awt.Color(0, 51, 102));
        nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRolActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtRolActual.setForeground(new java.awt.Color(242, 242, 242));
        txtRolActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRolActual.setText("Administrador");
        nav.add(txtRolActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, -1));

        userFoto.setIcon(new ImageIcon("src/main/java/images/user.png"));
        nav.add(userFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 160));

        txtUserActual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUserActual.setForeground(new java.awt.Color(242, 242, 242));
        txtUserActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtUserActual.setText("Nombre");
        nav.add(txtUserActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, -1));

        btnRegistro.setBackground(new java.awt.Color(0, 51, 102));
        btnRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(245, 245, 245));
        btnRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistro.setText("Registro");
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.setOpaque(true);
        btnRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroMouseExited(evt);
            }
        });
        nav.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        btnCaja.setBackground(new java.awt.Color(0, 51, 102));
        btnCaja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCaja.setForeground(new java.awt.Color(245, 245, 245));
        btnCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCaja.setText("Caja");
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setOpaque(true);
        btnCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCajaMouseExited(evt);
            }
        });
        nav.add(btnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 220, 50));

        btnReportes.setBackground(new java.awt.Color(0, 51, 102));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(245, 245, 245));
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setOpaque(true);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        nav.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, 50));

        btnConfiguracion.setBackground(new java.awt.Color(0, 51, 102));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(245, 245, 245));
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.setOpaque(true);
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseExited(evt);
            }
        });
        nav.add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 220, 50));

        btnUsuarios.setBackground(new java.awt.Color(0, 51, 102));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(245, 245, 245));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setOpaque(true);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });
        nav.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 50));

        btnRoles.setBackground(new java.awt.Color(0, 51, 102));
        btnRoles.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRoles.setForeground(new java.awt.Color(245, 245, 245));
        btnRoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRoles.setText("Roles");
        btnRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRoles.setOpaque(true);
        btnRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRolesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRolesMouseExited(evt);
            }
        });
        nav.add(btnRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 220, 50));

        btnSalir.setBackground(new java.awt.Color(0, 51, 102));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(245, 245, 245));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("Cerrar Sesión");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setOpaque(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        nav.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 220, 50));

        fondo.add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 670));

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        fondo.add(contenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 740, 630));

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xx, xy;
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void btnMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseEntered
        btnMin.setBackground(new Color(230, 230, 230));
    }//GEN-LAST:event_btnMinMouseEntered

    private void btnMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseExited
        btnMin.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnMinMouseExited

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(new Color(139, 0, 0));
        btnCerrar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(242, 242, 242));
        btnCerrar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseEntered
        btnRegistro.setBackground(colorEntrar);
    }//GEN-LAST:event_btnRegistroMouseEntered

    private void btnRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseExited
        btnRegistro.setBackground(colorSalir);
    }//GEN-LAST:event_btnRegistroMouseExited

    private void btnCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseEntered
        btnCaja.setBackground(colorEntrar);
    }//GEN-LAST:event_btnCajaMouseEntered

    private void btnCajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseExited
        btnCaja.setBackground(colorSalir);
    }//GEN-LAST:event_btnCajaMouseExited

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBackground(colorEntrar);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBackground(colorSalir);
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnConfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseEntered
        btnConfiguracion.setBackground(colorEntrar);
    }//GEN-LAST:event_btnConfiguracionMouseEntered

    private void btnConfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseExited
        btnConfiguracion.setBackground(colorSalir);
    }//GEN-LAST:event_btnConfiguracionMouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(colorEntrar);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(colorSalir);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnRolesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseEntered
        btnRoles.setBackground(colorEntrar);
    }//GEN-LAST:event_btnRolesMouseEntered

    private void btnRolesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseExited
        btnRoles.setBackground(colorSalir);
    }//GEN-LAST:event_btnRolesMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(colorEntrar);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(colorSalir);
    }//GEN-LAST:event_btnSalirMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnCaja;
    public javax.swing.JLabel btnCerrar;
    public javax.swing.JLabel btnConfiguracion;
    public javax.swing.JLabel btnMin;
    public javax.swing.JLabel btnRegistro;
    public javax.swing.JLabel btnReportes;
    public javax.swing.JLabel btnRoles;
    public javax.swing.JLabel btnSalir;
    public javax.swing.JLabel btnUsuarios;
    public javax.swing.JPanel contenedor;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel header;
    private javax.swing.JPanel nav;
    public javax.swing.JLabel txtRolActual;
    public javax.swing.JLabel txtUserActual;
    public javax.swing.JLabel userFoto;
    // End of variables declaration//GEN-END:variables
}
