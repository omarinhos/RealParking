package controlador;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.FrmPrincipal;
import static java.awt.Frame.ICONIFIED;
import modelo.Usuario;
import modelo.Rol;

public class CPrincipal {
    
    public FrmPrincipal frmPrincipal = new FrmPrincipal();
    private CConfiguracion cConfiguracion;
    private CUsuarios cUsuarios;
    private CRoles cRoles;
    private CRegistro cRegistro;
    private CCaja cCaja;
    private CReportes cReportes;
    private final Usuario usuario;
    
    private boolean permisoRegistro;
    private boolean permisoCaja;
    private boolean permisoReportes;
    private boolean permisoConfiguracion;
    private boolean permisoUsuarios;
    private boolean permisoRoles;
    
    public CPrincipal(Usuario user) {
        this.usuario = user;
        tipoRolPanel(usuario.getRol());
        frmPrincipal.txtUserActual.setText(usuario.getNombreCompleto());
        frmPrincipal.txtRolActual.setText(usuario.getRol().getDescripcion());
        
        frmPrincipal.btnRegistro.setEnabled(permisoRegistro);
        frmPrincipal.btnCaja.setEnabled(permisoCaja);
        frmPrincipal.btnReportes.setEnabled(permisoReportes);
        frmPrincipal.btnConfiguracion.setEnabled(permisoConfiguracion);
        frmPrincipal.btnUsuarios.setEnabled(permisoUsuarios);
        frmPrincipal.btnRoles.setEnabled(permisoRoles);
        
        frmPrincipal.btnRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoRegistro) {
                    cRegistro = new CRegistro(frmPrincipal);
                    cRegistro.vistaRegistro.setVisible(true);
                }
                
            }
        });
        
        frmPrincipal.btnCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoCaja) {
                    cCaja = new CCaja(frmPrincipal, usuario);
                    cCaja.vistaCaja.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnReportes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoReportes) {
                    cReportes = new CReportes(frmPrincipal);
                    cReportes.vistaReportes.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnConfiguracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoConfiguracion) {
                    cConfiguracion = new CConfiguracion(frmPrincipal);
                    cConfiguracion.vistaConfig.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoUsuarios) {
                    cUsuarios = new CUsuarios(frmPrincipal);
                    cUsuarios.vistaUsuarios.setVisible(true);
                }
            }
        });
        
        frmPrincipal.btnRoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoRoles) {
                    cRoles = new CRoles(frmPrincipal);
                    cRoles.vistaRoles.setVisible(true);
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
    
    private void tipoRolPanel(Rol rol) {
        switch (rol.getDescripcion()) {
            case "Administrador":
                new CUsuarios(frmPrincipal).vistaUsuarios.setVisible(true);
                permisoRegistro = false;
                permisoCaja = false;
                permisoReportes = true;
                permisoConfiguracion = true;
                permisoUsuarios = true;
                permisoRoles = true;
                break;
            case "Cajero":
                new CCaja(frmPrincipal, usuario).vistaCaja.setVisible(true);
                permisoRegistro = false;
                permisoCaja = true;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            case "Digitador":
                new CRegistro(frmPrincipal).vistaRegistro.setVisible(true);
                permisoRegistro = true;
                permisoCaja = false;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
                break;
            case "Testing":
                new CRegistro(frmPrincipal).vistaRegistro.setVisible(true);
                permisoRegistro = true;
                permisoCaja = true;
                permisoReportes = true;
                permisoConfiguracion = true;
                permisoUsuarios = true;
                permisoRoles = true;
                break;
            default:
                new CRegistro(frmPrincipal).vistaRegistro.setVisible(true);
                permisoRegistro = true;
                permisoCaja = true;
                permisoReportes = false;
                permisoConfiguracion = false;
                permisoUsuarios = false;
                permisoRoles = false;
            
        }
    }

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            Usuario user = new Usuario();
            user.setId(1);
            user.setUsuario("alo");
            user.setNombreCompleto("Omar Santos");
            user.setRol(new Rol(1, "Testing", "Activo"));
            new CPrincipal(user).frmPrincipal.setVisible(true);
        });
    }
    
}
