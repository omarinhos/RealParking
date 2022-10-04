package controlador;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import dao.RolDTO;
import vista.FrmPrincipal;
import dao.UsuarioDTO;
import static java.awt.Frame.ICONIFIED;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import vista.VistaCaja;
import vista.VistaConfiguracion;
import vista.VistaRegistro;
import vista.VistaReportes;

public class CPrincipal {
    
    public FrmPrincipal frmPrincipal = new FrmPrincipal();
    
    private boolean permisoRegistro;
    private boolean permisoCaja;
    private boolean permisoReportes;
    private boolean permisoConfiguracion;
    private boolean permisoUsuarios;
    private boolean permisoRoles;
    
    public CPrincipal(UsuarioDTO usuario) {
        tipoRolPanel(usuario.getRol());
        frmPrincipal.txtUserActual.setText(usuario.getNombreCompleto());
        frmPrincipal.txtRolActual.setText(usuario.getRol().getDescripcion());
        frmPrincipal.btnRegistro.setEnabled(permisoRegistro);
        frmPrincipal.btnCaja.setEnabled(permisoCaja);
        frmPrincipal.btnReportes.setEnabled(permisoReportes);
        frmPrincipal.btnConfiguracion.setEnabled(permisoConfiguracion);
        frmPrincipal.btnUsuarios.setEnabled(permisoUsuarios);
        frmPrincipal.btnRoles.setEnabled(permisoRoles);
        
        if (usuario.getImagen() != null) {
            cargarImagen(usuario.getImagen());
        }
        
        frmPrincipal.btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoRegistro) {
                    cargarPanel(new VistaRegistro());
                }
                
            }
        });
        
        frmPrincipal.btnCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoCaja) {
                    cargarPanel(new VistaCaja());
                }
            }
        });
        
        frmPrincipal.btnReportes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoReportes) {
                    cargarPanel(new VistaReportes());
                }
            }
        });
        
        frmPrincipal.btnConfiguracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoConfiguracion) {
                    new CConfiguracion(frmPrincipal).vistaConfig.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoUsuarios) {
                    new CUsuarios(frmPrincipal).vistaUsuarios.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnRoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoRoles) {
                    new CRoles(frmPrincipal).vistaRoles.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int op = JOptionPane.showConfirmDialog(frmPrincipal, "¿Desea cerrar sesión?",
                        "Salir", 0, 3);
                if (op == 0) {
                    new Clogin().FrmLogin.setVisible(true);
                    frmPrincipal.dispose();
                }
            }
        });
        
        frmPrincipal.btnCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        
        frmPrincipal.btnMin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frmPrincipal.setExtendedState(ICONIFIED);
            }
        });
    }
    
    private void cargarPanel(JPanel panel) {
        panel.setSize(740, 630);
        frmPrincipal.contenedor.removeAll();
        frmPrincipal.contenedor.add(panel, BorderLayout.CENTER);
        frmPrincipal.contenedor.revalidate();
        frmPrincipal.contenedor.repaint();
    }
    
    private void tipoRolPanel(RolDTO rol) {
        switch (rol.getDescripcion()) {
            case "Administrador":
                //cargarPanel(new VistaUsuarios());
                new CUsuarios(frmPrincipal).vistaUsuarios.setVisible(true);
                permisoRegistro = false;
                permisoCaja = false;
                permisoReportes = true;
                permisoConfiguracion = true;
                permisoUsuarios = true;
                permisoRoles = true;
                break;
            case "Cajero":
                cargarPanel(new VistaCaja());
                permisoRegistro = false;
                permisoCaja = true;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            case "Digitador":
                cargarPanel(new VistaRegistro());
                permisoRegistro = true;
                permisoCaja = false;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            default:
                cargarPanel(new VistaRegistro());
                permisoRegistro = true;
                permisoCaja = true;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
            
        }
    }
    
    private void cargarImagen(Blob blob) {
        
        BufferedImage img = null;
        try {
            //pasar el binario a imagen
            byte[] data = blob.getBytes(1, (int) blob.length());
            //lee la imagen
            img = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon icono = new ImageIcon(img);
        Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(frmPrincipal.userFoto.getWidth(), frmPrincipal.userFoto.getHeight(), Image.SCALE_DEFAULT));
        frmPrincipal.userFoto.setIcon(imagen);
    }
    
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            UsuarioDTO user = new UsuarioDTO();
            user.setUsuario("alo");
            user.setRol(new RolDTO(1, "Administrador", "Activo"));
            new CPrincipal(user).frmPrincipal.setVisible(true);
        });
    }
    
}
