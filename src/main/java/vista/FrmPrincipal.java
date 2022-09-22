package vista;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import controlador.RolDAO;
import controlador.UsuarioDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;
import modelo.Usuario;

public class FrmPrincipal extends javax.swing.JFrame {
    
    UsuarioDAO udao = new UsuarioDAO();
    RolDAO rdao = new RolDAO();
    
    List<Usuario> usuarios = new ArrayList<>();
    List<Rol> roles = new ArrayList<>();
    
    DefaultTableModel modeloUsuarios = new DefaultTableModel();
    DefaultTableModel modeloRoles = new DefaultTableModel();
    
    int idUsuario;
    int idRol;
    
    boolean permisoRegistro = true;
    boolean permisoCaja = true;
    boolean permisoReportes = true;
    boolean permisoConfiguracion = true;
    boolean permisoUsuarios = true;
    boolean permisoRoles = true;
    
    Color colorEntrar = new Color(0, 35, 71);
    Color colorSalir = new Color(0, 51, 102);
    
    public FrmPrincipal(Usuario user) {
        initComponents();
        
        iniciarTablas();
        actualizarTablaUsuarios();
        actualizarTablaRoles();
        
        llenarCombo();
        validarPermisos(user);
        
        JOptionPane.showMessageDialog(this, "Bienvenido "+user.getNombreCompleto());
        
        btnRegistro.setEnabled(permisoRegistro);
        btnCaja.setEnabled(permisoCaja);
        btnReportes.setEnabled(permisoReportes);
        btnConfiguracion.setEnabled(permisoConfiguracion);
        btnUsuarios.setEnabled(permisoUsuarios);
        btnRoles.setEnabled(permisoRoles);
        
        txtRolActual.setText(user.getRol().getDescripcion());
        txtUserActual.setText(user.getNombreCompleto());
        
    }
    
    private void llenarCombo() {
        cmbUCargo.removeAllItems();
        roles.forEach(rol -> cmbUCargo.addItem(rol.getDescripcion()));
       
    }
    
    private void validarPermisos(Usuario user) {
        switch (user.getRol().getDescripcion()) {
            case "Administrador" :
                ventanas.setSelectedIndex(3);
                permisoRegistro = false;
                permisoCaja = false;
                break;
            case "Digitador" :
                permisoCaja = false;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            case "Cajero" :
                ventanas.setSelectedIndex(1);
                permisoRegistro = false;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            default :
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
        }
    }
    
    private void iniciarTablas() {
        String tituloU[] = {"Id", "DNI", "Nombre", "Cargo", "Estado"};
        String tituloR[] = {"Id", "Rol", "Estado"};
        modeloUsuarios.setColumnIdentifiers(tituloU);
        modeloRoles.setColumnIdentifiers(tituloR);
        tblUsuarios.setModel(modeloUsuarios);
        tblRoles.setModel(modeloRoles);
    }
    
    private void eliminarTodasLasFilas(DefaultTableModel modelo) {
        int nRow = modelo.getRowCount();
        for (int i = nRow - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void actualizarTablaUsuarios() {
        usuarios = udao.getList();
        eliminarTodasLasFilas(modeloUsuarios);
        
        usuarios.forEach(usuario -> {
            modeloUsuarios.addRow(new Object[]{
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getNombreCompleto(),
                usuario.getRol().getDescripcion(),
                usuario.getEstado()
            });
        });
    }
    
    private void actualizarTablaRoles() {
        roles = rdao.getList();
        eliminarTodasLasFilas(modeloRoles);
        
        roles.forEach(rol -> {
            modeloRoles.addRow(new Object[]{
                rol.getId(),
                rol.getDescripcion(),
                rol.getEstado()
            });
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnMin = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        nav = new javax.swing.JPanel();
        txtRolActual = new javax.swing.JLabel();
        txtUserActual = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        btnRoles = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JLabel();
        btnConfiguracion = new javax.swing.JLabel();
        btnReportes = new javax.swing.JLabel();
        btnCaja = new javax.swing.JLabel();
        ventanas = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnRegistrarIncidente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btnGenerarPago = new javax.swing.JButton();
        btnVentasDia = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtUDni = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtUnombre = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmbUEstado = new javax.swing.JComboBox<>();
        btnUGuardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtUPass = new javax.swing.JPasswordField();
        jLabel27 = new javax.swing.JLabel();
        txtUPassRe = new javax.swing.JPasswordField();
        btnUModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        cmbUCargo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRrol = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cmbREstado = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        btnRGuardar = new javax.swing.JButton();
        btnRModificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 50, 35));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 35));

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
        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 35));

        nav.setBackground(new java.awt.Color(0, 51, 102));
        nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRolActual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtRolActual.setForeground(new java.awt.Color(242, 242, 242));
        txtRolActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRolActual.setText("Administrador");
        nav.add(txtRolActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, -1));

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistroMouseExited(evt);
            }
        });
        nav.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        btnSalir.setBackground(new java.awt.Color(0, 51, 102));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(245, 245, 245));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("Cerrar Sesión");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setOpaque(true);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        nav.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 220, 50));

        btnRoles.setBackground(new java.awt.Color(0, 51, 102));
        btnRoles.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRoles.setForeground(new java.awt.Color(245, 245, 245));
        btnRoles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRoles.setText("Roles");
        btnRoles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRoles.setOpaque(true);
        btnRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRolesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRolesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRolesMouseExited(evt);
            }
        });
        nav.add(btnRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 220, 50));

        btnUsuarios.setBackground(new java.awt.Color(0, 51, 102));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(245, 245, 245));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setOpaque(true);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });
        nav.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 50));

        btnConfiguracion.setBackground(new java.awt.Color(0, 51, 102));
        btnConfiguracion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(245, 245, 245));
        btnConfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.setOpaque(true);
        btnConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfiguracionMouseExited(evt);
            }
        });
        nav.add(btnConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 220, 50));

        btnReportes.setBackground(new java.awt.Color(0, 51, 102));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(245, 245, 245));
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReportes.setText("Reportes");
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.setOpaque(true);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        nav.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 220, 50));

        btnCaja.setBackground(new java.awt.Color(0, 51, 102));
        btnCaja.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCaja.setForeground(new java.awt.Color(245, 245, 245));
        btnCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCaja.setText("Caja");
        btnCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCaja.setOpaque(true);
        btnCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCajaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCajaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCajaMouseExited(evt);
            }
        });
        nav.add(btnCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 220, 50));

        jPanel1.add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 670));

        ventanas.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setEnabled(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 153));
        jLabel14.setText("ESPACIOS LIBRES: 120");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 310, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa: ");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 160, 30));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("INGRESAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 110, 30));
        jPanel5.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 160, 30));

        jButton5.setBackground(new java.awt.Color(0, 51, 102));
        jButton5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("MOSTRAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Buscar:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(153, 153, 153));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Placa", "Hora de ingreso", "Estado"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 430, 230));

        jButton6.setBackground(new java.awt.Color(0, 51, 102));
        jButton6.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("RETIRAR VEHICULO");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 180, 30));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("______________________________________________________________________________________________");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 480, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("INGRESO  DE VEHICULOS");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 500, 30));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("_______________________________________________________________________________________________");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 480, 20));

        ventanas.addTab("Registro", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Buscar:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));
        jPanel6.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 160, 30));

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
        jPanel6.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

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
        btnRegistrarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIncidenteActionPerformed(evt);
            }
        });
        jPanel6.add(btnRegistrarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 220, 30));

        jTable3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable3.setForeground(new java.awt.Color(153, 153, 153));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Placa", "Hora de ingreso", "Estado"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 520, 240));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("CAJA");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, 30));

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
        btnGenerarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPagoActionPerformed(evt);
            }
        });
        jPanel6.add(btnGenerarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 160, 30));

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
        btnVentasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasDiaActionPerformed(evt);
            }
        });
        jPanel6.add(btnVentasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 160, 30));

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("________________________");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 20));

        ventanas.addTab("Caja", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("CONFIGURACIÓN DEL SISTEMA");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 610, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Razón Social :");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));
        jPanel8.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 160, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("r.u..c. :");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        jPanel8.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 160, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Nombre comercial :");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Tarfica unica:");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 20));
        jPanel8.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 160, 30));
        jPanel8.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 160, 30));

        jButton13.setBackground(new java.awt.Color(0, 51, 102));
        jButton13.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("REGISTRAR");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton13MouseExited(evt);
            }
        });
        jPanel8.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, -1, -1));

        jButton14.setBackground(new java.awt.Color(0, 51, 102));
        jButton14.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("MODIFICAR");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton14MouseExited(evt);
            }
        });
        jPanel8.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("____________________________________________________________________________________________________________________");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 580, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Espacios disponibles:");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, 20));
        jPanel8.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 160, 30));

        ventanas.addTab("Configuración", jPanel8);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nombre Completo:");
        jPanel7.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        jPanel7.add(txtUDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 160, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Estado:");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));
        jPanel7.add(txtUnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 160, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Dni:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 30));

        cmbUEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel7.add(cmbUEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 120, 30));

        btnUGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnUGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnUGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnUGuardar.setText("GUARDAR");
        btnUGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUGuardarMouseExited(evt);
            }
        });
        btnUGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUGuardarActionPerformed(evt);
            }
        });
        jPanel7.add(btnUGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 110, 30));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("____________________________________________________________________________________________");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 470, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("REGISTRO DE USUARIOS");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 480, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Contraseña:");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));
        jPanel7.add(txtUPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 160, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Repetir contraseña:");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, -1));
        jPanel7.add(txtUPassRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 160, 30));

        btnUModificar.setBackground(new java.awt.Color(0, 51, 102));
        btnUModificar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnUModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnUModificar.setText("MODIFICAR");
        btnUModificar.setEnabled(false);
        btnUModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUModificarMouseExited(evt);
            }
        });
        btnUModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUModificarActionPerformed(evt);
            }
        });
        jPanel7.add(btnUModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 30));

        tblUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 700, 320));

        cmbUCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Digitador", "Cajero", "Prueba", "Abogado" }));
        jPanel7.add(cmbUCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 120, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Cargo: ");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        ventanas.addTab("Usuarios", jPanel7);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("REGISTRO DE ROLES");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 410, 30));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("_____________________________________________________________________________");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 390, 20));
        jPanel3.add(txtRrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 160, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Rol:");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, 30));

        cmbREstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel3.add(cmbREstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 160, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Estado:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 60, -1));

        btnRGuardar.setBackground(new java.awt.Color(0, 51, 102));
        btnRGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnRGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnRGuardar.setText("GUARDAR");
        btnRGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRGuardarMouseExited(evt);
            }
        });
        btnRGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 110, 30));

        btnRModificar.setBackground(new java.awt.Color(0, 51, 102));
        btnRModificar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnRModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnRModificar.setText("MODIFICAR");
        btnRModificar.setEnabled(false);
        btnRModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 120, 30));

        tblRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblRoles);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, 700, 370));

        ventanas.addTab("Roles", jPanel3);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 90, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Desde:");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable4.setForeground(new java.awt.Color(153, 153, 153));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Usuario", "N° Ticket", "Placa", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 550, 240));

        jButton12.setBackground(new java.awt.Color(0, 51, 102));
        jButton12.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("EXPORTAR ");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 120, 30));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("__________________________________________________________________________________");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 440, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Usuario:");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        jPanel9.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 90, 30));

        jButton15.setBackground(new java.awt.Color(0, 51, 102));
        jButton15.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("MOSTRAR");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton15MouseExited(evt);
            }
        });
        jPanel9.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 110, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Omar", "Paolo", "Arturo" }));
        jPanel9.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 90, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Hasta:");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("REPORTES DE VENTAS");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 430, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Total de vehiculos:  120 ");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 240, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Total de ingresos: S/. 240.00");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 570, 290, 20));

        ventanas.addTab("Reportes", jPanel9);

        jPanel1.add(ventanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 740, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPagoActionPerformed

    private void btnRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIncidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarIncidenteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void btnVentasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasDiaActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void btnUGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUGuardarActionPerformed
        
        String pass = String.valueOf(txtUPass.getPassword());
        String passre = String.valueOf(txtUPassRe.getPassword());
        
        if (pass.equals(passre)) {
            Usuario user = new Usuario();
            Rol rol = new Rol();
            user.setUsuario(txtUDni.getText());
            user.setPass(pass);
            user.setNombreCompleto(txtUnombre.getText());
            user.setEstado((String) cmbUEstado.getSelectedItem());
            System.out.println(cmbUCargo.getSelectedIndex());
            rol.setId(cmbUCargo.getSelectedIndex() + 1);
            user.setRol(rol);
            
            udao.create(user);
            JOptionPane.showMessageDialog(this, "Usuario Agregado");
            actualizarTablaUsuarios();
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
        }

    }//GEN-LAST:event_btnUGuardarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            int x = tblUsuarios.getSelectedRow();
            
            idUsuario = usuarios.get(x).getId();
            txtUDni.setText("" + usuarios.get(x).getUsuario());
            txtUPass.setText("" + usuarios.get(x).getPass());
            txtUPassRe.setText("" + usuarios.get(x).getPass());
            txtUnombre.setText("" + usuarios.get(x).getNombreCompleto());
            cmbUCargo.setSelectedItem("" + usuarios.get(x).getRol().getDescripcion());
            cmbUEstado.setSelectedItem("" + usuarios.get(x).getEstado());
            btnUGuardar.setEnabled(false);
            btnUModificar.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dar solo click izquiero.");
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void btnUModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUModificarActionPerformed
        String pass = String.valueOf(txtUPass.getPassword());
        String passre = String.valueOf(txtUPassRe.getPassword());
        
        if (pass.equals(passre)) {
            Usuario user = new Usuario();
            Rol rol = new Rol();
            user.setId(idUsuario);
            user.setUsuario(txtUDni.getText());
            user.setPass(pass);
            user.setNombreCompleto(txtUnombre.getText());
            user.setEstado((String) cmbUEstado.getSelectedItem());
            System.out.println(cmbUCargo.getSelectedIndex());
            rol.setId(cmbUCargo.getSelectedIndex() + 1);
            user.setRol(rol);
            
            udao.update(user);
            JOptionPane.showMessageDialog(this, "Usuario Modificado");
            actualizarTablaUsuarios();
            btnUGuardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
        }
    }//GEN-LAST:event_btnUModificarActionPerformed

    private void btnRGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRGuardarActionPerformed
        String txtRol = txtRrol.getText();
        
        if (!txtRol.isEmpty()) {
            
            Rol rol = new Rol();
            
            rol.setDescripcion(txtRrol.getText());
            rol.setEstado((String) cmbUEstado.getSelectedItem());
            
            rdao.create(rol);
            JOptionPane.showMessageDialog(this, "Rol Agregado");
            actualizarTablaRoles();
            llenarCombo();
        } else {
            JOptionPane.showMessageDialog(this, "Llenar todos los campos");
        }
    }//GEN-LAST:event_btnRGuardarActionPerformed

    private void btnRModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRModificarActionPerformed
        
        Rol rol = new Rol();
        rol.setDescripcion(txtRrol.getText());
        rol.setEstado((String) cmbREstado.getSelectedItem());
        rol.setId(idRol);
        
        rdao.update(rol);
        JOptionPane.showMessageDialog(this, "Rol Modificado");
        actualizarTablaRoles();
        llenarCombo();
        actualizarTablaUsuarios();
        
        btnRGuardar.setEnabled(true);
        txtRrol.setText("");
        

    }//GEN-LAST:event_btnRModificarActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        try {
            int x = tblRoles.getSelectedRow();
            
            idRol = roles.get(x).getId();
            txtRrol.setText("" + roles.get(x).getDescripcion());
            cmbREstado.setSelectedItem("" + roles.get(x).getEstado());
            
            btnRGuardar.setEnabled(false);
            
            if(idRol > 3) {
                btnRModificar.setEnabled(true);
            } else {
                btnRModificar.setEnabled(false);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Dar solo click izquiero.");
        }
    }//GEN-LAST:event_tblRolesMouseClicked

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        if (permisoRegistro) ventanas.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseClicked
        if (permisoCaja) ventanas.setSelectedIndex(1);
    }//GEN-LAST:event_btnCajaMouseClicked

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        if (permisoReportes) ventanas.setSelectedIndex(2);
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseClicked
        if (permisoConfiguracion) ventanas.setSelectedIndex(3);
    }//GEN-LAST:event_btnConfiguracionMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        if (permisoUsuarios) ventanas.setSelectedIndex(4);
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseClicked
        if (permisoRoles) ventanas.setSelectedIndex(5);
    }//GEN-LAST:event_btnRolesMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        int op = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Salir", 0);
        if (op == 0) {
            new FrmLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirMouseClicked
    
    int xx, xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_headerMouseDragged

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinMouseClicked

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

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(new Color(139, 0, 0));
        btnCerrar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(242, 242, 242));
        btnCerrar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseEntered
        btnMin.setBackground(new Color(230, 230, 230));
    }//GEN-LAST:event_btnMinMouseEntered

    private void btnMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinMouseExited
        btnMin.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnMinMouseExited

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

    private void btnVentasDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseEntered
        btnVentasDia.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnVentasDiaMouseEntered

    private void btnVentasDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseExited
        btnVentasDia.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnVentasDiaMouseExited

    private void btnGenerarPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseEntered
        btnGenerarPago.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGenerarPagoMouseEntered

    private void btnGenerarPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseExited
        btnGenerarPago.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGenerarPagoMouseExited

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        jButton5.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        jButton5.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        jButton13.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseExited
       jButton13.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton13MouseExited

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
         jButton14.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseExited
        jButton14.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton14MouseExited

    private void btnUGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUGuardarMouseEntered
        btnUGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnUGuardarMouseEntered

    private void btnUGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUGuardarMouseExited
         btnUGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnUGuardarMouseExited

    private void btnUModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUModificarMouseEntered
        btnUModificar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnUModificarMouseEntered

    private void btnUModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUModificarMouseExited
        btnUModificar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnUModificarMouseExited

    private void btnRGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRGuardarMouseEntered
        btnRGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnRGuardarMouseEntered

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
         jButton15.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton15MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
         jButton12.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton12MouseExited

    private void btnRGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRGuardarMouseExited
         btnRGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnRGuardarMouseExited

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = new Usuario();
                user.setUsuario("alo");
                user.setRol(new Rol(1, "Administrador", "Activo"));
                new FrmPrincipal(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCaja;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnConfiguracion;
    private javax.swing.JButton btnGenerarPago;
    private javax.swing.JLabel btnMin;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRGuardar;
    private javax.swing.JButton btnRModificar;
    private javax.swing.JButton btnRegistrarIncidente;
    private javax.swing.JLabel btnRegistro;
    private javax.swing.JLabel btnReportes;
    private javax.swing.JLabel btnRoles;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JButton btnUGuardar;
    private javax.swing.JButton btnUModificar;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JButton btnVentasDia;
    private javax.swing.JComboBox<String> cmbREstado;
    private javax.swing.JComboBox<String> cmbUCargo;
    private javax.swing.JComboBox<String> cmbUEstado;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel nav;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JLabel txtRolActual;
    private javax.swing.JTextField txtRrol;
    private javax.swing.JTextField txtUDni;
    private javax.swing.JPasswordField txtUPass;
    private javax.swing.JPasswordField txtUPassRe;
    private javax.swing.JTextField txtUnombre;
    private javax.swing.JLabel txtUserActual;
    private javax.swing.JTabbedPane ventanas;
    // End of variables declaration//GEN-END:variables
}
