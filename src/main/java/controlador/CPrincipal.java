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
