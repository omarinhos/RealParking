package vista;

import com.formdev.flatlaf.FlatIntelliJLaf;
import controlador.RolDAO;
import controlador.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
        
        formatoCabeceraTabla(tblUsuarios);
        formatoCabeceraTabla(tblRoles);
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
    
    private void formatoCabeceraTabla(JTable tabla) {
        tabla.getTableHeader().setFont(new Font("Segue UI", Font.BOLD, 14));
        tabla.getTableHeader().setForeground(Color.BLACK);
        tabla.setRowHeight(25);
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
        ventanas = new javax.swing.JTabbedPane();
        registro = new javax.swing.JPanel();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        caja = new javax.swing.JPanel();
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
        pReportes = new javax.swing.JPanel();
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
        configuracion = new javax.swing.JPanel();
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
        pUsuarios = new javax.swing.JPanel();
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
        pRoles = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRrol = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        cmbREstado = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        btnRGuardar = new javax.swing.JButton();
        btnRModificar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRoles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Real Parking");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 2, true));
        fondo.setPreferredSize(new java.awt.Dimension(950, 670));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        fondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 35));

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
        fondo.add(btnMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 50, 35));

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
        fondo.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 35));

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

        fondo.add(nav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 670));

        ventanas.setEnabled(false);

        registro.setBackground(new java.awt.Color(255, 255, 255));
        registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 153));
        jLabel14.setText("ESPACIOS LIBRES: 120");
        registro.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 310, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa: ");
        registro.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        registro.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 160, 30));

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
        registro.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 110, 30));
        registro.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 160, 30));

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
        registro.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Buscar:");
        registro.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

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

        registro.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 430, 230));

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
        registro.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 180, 30));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("_______________________________________________________________________________________________");
        registro.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 480, 20));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("______________________________________________________________________________________________");
        registro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("INGRESO  DE VEHICULOS");
        registro.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        ventanas.addTab("Registro", registro);

        caja.setBackground(new java.awt.Color(255, 255, 255));
        caja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Buscar:");
        caja.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 129, -1, -1));
        caja.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 119, 160, 30));

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
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        caja.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 119, -1, -1));

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
        caja.add(btnRegistrarIncidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 499, 220, 30));

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

        caja.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 189, 520, 240));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("CAJA");
        caja.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

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
        caja.add(btnGenerarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 499, 160, 30));

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
        caja.add(btnVentasDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 549, 160, 30));

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("________________________");
        caja.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        ventanas.addTab("Caja", caja);

        pReportes.setBackground(new java.awt.Color(255, 255, 255));
        pReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pReportes.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 99, 90, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Desde:");
        pReportes.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 109, -1, -1));

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

        pReportes.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 259, 550, 240));

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
        pReportes.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 149, 120, 30));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("__________________________________________________________________________________");
        pReportes.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 740, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Usuario:");
        pReportes.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 199, -1, -1));
        pReportes.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 149, 90, 30));

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
        pReportes.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 109, 110, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Omar", "Paolo", "Arturo" }));
        pReportes.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 199, 90, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Hasta:");
        pReportes.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 149, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("REPORTES DE VENTAS");
        pReportes.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Total de vehiculos:  120 ");
        pReportes.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 559, 240, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Total de ingresos: S/. 240.00");
        pReportes.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 589, 290, 20));

        ventanas.addTab("Reportes", pReportes);

        configuracion.setBackground(new java.awt.Color(255, 255, 255));
        configuracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("CONFIGURACIÓN DEL SISTEMA");
        configuracion.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Razón Social :");
        configuracion.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));
        configuracion.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 160, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("r.u..c. :");
        configuracion.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));
        configuracion.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 160, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Nombre comercial :");
        configuracion.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Tarfica unica:");
        configuracion.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, 20));
        configuracion.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 160, 30));
        configuracion.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 160, 30));

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
        configuracion.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

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
        configuracion.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("____________________________________________________________________________________________________________________");
        configuracion.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Espacios disponibles:");
        configuracion.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, 20));
        configuracion.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 160, 30));

        ventanas.addTab("Configuracion", configuracion);

        pUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        pUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Nombre Completo:");
        pUsuarios.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));
        pUsuarios.add(txtUDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 74, 160, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Estado:");
        pUsuarios.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, 30));
        pUsuarios.add(txtUnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 114, 160, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Dni:");
        pUsuarios.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 30));

        cmbUEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        pUsuarios.add(cmbUEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 204, 160, 30));

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
        pUsuarios.add(btnUGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 120, 30));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("____________________________________________________________________________________________");
        pUsuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 730, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("REGISTRO DE USUARIOS");
        pUsuarios.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Contraseña:");
        pUsuarios.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));
        pUsuarios.add(txtUPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 160, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Repetir contraseña:");
        pUsuarios.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));
        pUsuarios.add(txtUPassRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 160, 30));

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
        pUsuarios.add(btnUModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 120, 30));

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
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        pUsuarios.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 700, 330));

        cmbUCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Digitador", "Cajero", "Prueba", "Abogado" }));
        pUsuarios.add(cmbUCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 164, 160, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Cargo: ");
        pUsuarios.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        ventanas.addTab("Usuarios", pUsuarios);

        pRoles.setBackground(new java.awt.Color(255, 255, 255));
        pRoles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("REGISTRO DE ROLES");
        pRoles.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("_____________________________________________________________________________");
        pRoles.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 720, 20));
        pRoles.add(txtRrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 96, 160, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Rol:");
        pRoles.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 96, -1, 30));

        cmbREstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        pRoles.add(cmbREstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 146, 160, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Estado:");
        pRoles.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 156, 60, -1));

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
        pRoles.add(btnRGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 96, 110, 30));

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
        pRoles.add(btnRModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 146, 120, 30));

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 102), 1, true));

        tblRoles.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        tblRoles.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblRoles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblRoles.setFocusable(false);
        tblRoles.setGridColor(new java.awt.Color(0, 51, 102));
        tblRoles.setRowHeight(25);
        tblRoles.setSelectionBackground(new java.awt.Color(0, 51, 102));
        tblRoles.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tblRoles.getTableHeader().setResizingAllowed(false);
        tblRoles.getTableHeader().setReorderingAllowed(false);
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblRoles);

        pRoles.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 700, 330));

        ventanas.addTab("Roles", pRoles);

        fondo.add(ventanas, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 740, 670));

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

    private void btnRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseClicked
        if (permisoRegistro) ventanas.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegistroMouseClicked

    private void btnRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseEntered
        btnRegistro.setBackground(colorEntrar);
    }//GEN-LAST:event_btnRegistroMouseEntered

    private void btnRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistroMouseExited
        btnRegistro.setBackground(colorSalir);
    }//GEN-LAST:event_btnRegistroMouseExited

    private void btnCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseClicked
        if (permisoCaja) ventanas.setSelectedIndex(1);
    }//GEN-LAST:event_btnCajaMouseClicked

    private void btnCajaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseEntered
        btnCaja.setBackground(colorEntrar);
    }//GEN-LAST:event_btnCajaMouseEntered

    private void btnCajaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajaMouseExited
        btnCaja.setBackground(colorSalir);
    }//GEN-LAST:event_btnCajaMouseExited

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        if (permisoReportes) ventanas.setSelectedIndex(2);
    }//GEN-LAST:event_btnReportesMouseClicked

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBackground(colorEntrar);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBackground(colorSalir);
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseClicked
        if (permisoConfiguracion) ventanas.setSelectedIndex(3);
    }//GEN-LAST:event_btnConfiguracionMouseClicked

    private void btnConfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseEntered
        btnConfiguracion.setBackground(colorEntrar);
    }//GEN-LAST:event_btnConfiguracionMouseEntered

    private void btnConfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracionMouseExited
        btnConfiguracion.setBackground(colorSalir);
    }//GEN-LAST:event_btnConfiguracionMouseExited

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        if (permisoUsuarios) ventanas.setSelectedIndex(4);
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(colorEntrar);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(colorSalir);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseClicked
        if (permisoRoles) ventanas.setSelectedIndex(5);
    }//GEN-LAST:event_btnRolesMouseClicked

    private void btnRolesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseEntered
        btnRoles.setBackground(colorEntrar);
    }//GEN-LAST:event_btnRolesMouseEntered

    private void btnRolesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseExited
        btnRoles.setBackground(colorSalir);
    }//GEN-LAST:event_btnRolesMouseExited

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        int op = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Salir", 0);
        if (op == 0) {
            new FrmLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setBackground(colorEntrar);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setBackground(colorSalir);
    }//GEN-LAST:event_btnSalirMouseExited

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseEntered
        jButton4.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton4MouseEntered

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        jButton4.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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

    private void btnRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIncidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarIncidenteActionPerformed

    private void btnGenerarPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseEntered
        btnGenerarPago.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnGenerarPagoMouseEntered

    private void btnGenerarPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseExited
        btnGenerarPago.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnGenerarPagoMouseExited

    private void btnGenerarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarPagoActionPerformed

    private void btnVentasDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseEntered
        btnVentasDia.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnVentasDiaMouseEntered

    private void btnVentasDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasDiaMouseExited
        btnVentasDia.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnVentasDiaMouseExited

    private void btnVentasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVentasDiaActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        jButton12.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        jButton12.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseEntered
        jButton15.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_jButton15MouseEntered

    private void jButton15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseExited
        jButton15.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_jButton15MouseExited

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

    private void btnUModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUModificarMouseEntered
        btnUModificar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnUModificarMouseEntered

    private void btnUModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUModificarMouseExited
        btnUModificar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnUModificarMouseExited

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

    private void btnRGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRGuardarMouseEntered
        btnRGuardar.setBackground(new Color(5,42,136));
    }//GEN-LAST:event_btnRGuardarMouseEntered

    private void btnRGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRGuardarMouseExited
        btnRGuardar.setBackground(new Color(3,24,77));
    }//GEN-LAST:event_btnRGuardarMouseExited

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
    private javax.swing.JPanel caja;
    private javax.swing.JComboBox<String> cmbREstado;
    private javax.swing.JComboBox<String> cmbUCargo;
    private javax.swing.JComboBox<String> cmbUEstado;
    private javax.swing.JPanel configuracion;
    private javax.swing.JPanel fondo;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
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
    private javax.swing.JPanel pReportes;
    private javax.swing.JPanel pRoles;
    private javax.swing.JPanel pUsuarios;
    private javax.swing.JPanel registro;
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JLabel txtRolActual;
    private javax.swing.JTextField txtRrol;
    private javax.swing.JTextField txtUDni;
    private javax.swing.JPasswordField txtUPass;
    private javax.swing.JPasswordField txtUPassRe;
    private javax.swing.JTextField txtUnombre;
    private javax.swing.JLabel txtUserActual;
    private javax.swing.JLabel userFoto;
    private javax.swing.JTabbedPane ventanas;
    // End of variables declaration//GEN-END:variables
}
