package vista;

import controlador.RolDAO;
import controlador.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

    public FrmPrincipal(Usuario user) {
        initComponents();
        
        iniciarTablas();
        actualizarTablaUsuarios();
        actualizarTablaRoles();
        
        JOptionPane.showMessageDialog(this, user.getRol().getDescripcion()
                + " " + user.getUsuario());

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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.setEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 235, 235));
        jLabel2.setText("Administrador");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 235, 235));
        jLabel3.setText("Eddy Olivo ");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 670));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 204));
        jLabel14.setText("ESPACIOS LIBRES: 120");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 270, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Placa: ");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 160, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("INGRESAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 90, 30));
        jPanel5.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 160, 30));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("MOSTRAR");
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Buscar:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

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

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 380, 140));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton6.setText("RETIRAR VEHICULO");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 160, 30));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("___________________________________________________________________");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 570, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("INGRESO  DE VEHICULOS");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 270, 20));

        jTabbedPane1.addTab("tab1", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Buscar:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        jPanel6.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 160, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton7.setText("MOSTRAR");
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton8.setText("REGISTRAR INCIDENTE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 160, 30));

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

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 380, 160));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("CAJA");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, 20));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton9.setText("GENERAR PAGO");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 160, 30));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton10.setText("VENTAS DEL DIA");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 160, -1));

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("___________________________________________________________________");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 570, 20));

        jTabbedPane1.addTab("tab2", jPanel6);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("CONFIGURACIÓN DEL SISTEMA");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 340, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Razón Social :");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));
        jPanel8.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 160, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("r.u..c. :");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));
        jPanel8.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 160, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Nombre comercial :");
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Tarfica unica:");
        jPanel8.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, 20));
        jPanel8.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 160, 30));
        jPanel8.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 160, 30));

        jButton13.setText("REGISTRAR");
        jPanel8.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, -1, -1));

        jButton14.setText("MODIFICAR");
        jPanel8.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("___________________________________________________________________");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 570, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Espacios disponibles:");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));
        jPanel8.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 160, 30));

        jTabbedPane1.addTab("tab4", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 90, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Desde:");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        jPanel9.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 380, 160));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton12.setText("EXPORTAR ");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 100, 30));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("___________________________________________________________________");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 570, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Usuario:");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, -1, -1));
        jPanel9.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 90, 30));

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton15.setText("MOSTRAR");
        jPanel9.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 100, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Omar", "Paolo", "Arturo" }));
        jPanel9.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 90, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Hasta:");
        jPanel9.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("REPORTES DE VENTAS");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 240, 20));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Total de vehiculos:  120 ");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 240, 20));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Total de ingresos: S/. 240.00");
        jPanel9.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 290, 20));

        jTabbedPane1.addTab("tab5", jPanel9);

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

        btnUGuardar.setText("GUARDAR");
        btnUGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUGuardarActionPerformed(evt);
            }
        });
        jPanel7.add(btnUGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 110, 30));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("___________________________________________________________________");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 380, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("REGISTRO DE USUARIOS");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 260, 20));

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

        btnUModificar.setText("MODIFICAR");
        btnUModificar.setEnabled(false);
        btnUModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUModificarActionPerformed(evt);
            }
        });
        jPanel7.add(btnUModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 110, 30));

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

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 650, 360));

        cmbUCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Digitador", "Cajero", "Prueba", "Abogado" }));
        jPanel7.add(cmbUCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 120, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Cargo: ");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jTabbedPane1.addTab("Usuarios", jPanel7);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("REGISTRO DE ROLES");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 260, 20));

        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("___________________________________________________________________");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 380, 20));
        jPanel3.add(txtRrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Rol:");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 30));

        cmbREstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jPanel3.add(cmbREstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 160, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Estado:");
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 60, -1));

        btnRGuardar.setText("GUARDAR");
        btnRGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 110, 30));

        btnRModificar.setText("MODIFICAR");
        btnRModificar.setEnabled(false);
        btnRModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRModificarActionPerformed(evt);
            }
        });
        jPanel3.add(btnRModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 110, 30));

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
        jScrollPane5.setViewportView(tblRoles);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 247, 640, 370));

        jTabbedPane1.addTab("Roles", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 680, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRGuardarActionPerformed

    private void btnRModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRModificarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
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
    private javax.swing.JButton btnRGuardar;
    private javax.swing.JButton btnRModificar;
    private javax.swing.JButton btnUGuardar;
    private javax.swing.JButton btnUModificar;
    private javax.swing.JComboBox<String> cmbREstado;
    private javax.swing.JComboBox<String> cmbUCargo;
    private javax.swing.JComboBox<String> cmbUEstado;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JTable tblRoles;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtRrol;
    private javax.swing.JTextField txtUDni;
    private javax.swing.JPasswordField txtUPass;
    private javax.swing.JPasswordField txtUPassRe;
    private javax.swing.JTextField txtUnombre;
    // End of variables declaration//GEN-END:variables
}
