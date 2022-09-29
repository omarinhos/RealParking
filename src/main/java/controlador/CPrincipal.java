package controlador;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Rol;
import vista.FrmPrincipal;
import modelo.Usuario;
import vista.FrmLogin;
import vista.VistaCaja;
import vista.VistaConfiguracion;
import vista.VistaRegistro;
import vista.VistaReportes;
import vista.VistaRoles;
import vista.VistaUsuarios;

public class CPrincipal {

    public FrmPrincipal frmPrincipal;

    boolean permisoRegistro;
    boolean permisoCaja;
    boolean permisoReportes;
    boolean permisoConfiguracion;
    boolean permisoUsuarios;
    boolean permisoRoles;

    public CPrincipal(Usuario usuario) {
        frmPrincipal = new FrmPrincipal(usuario);

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
                if (permisoRegistro) cargarPanel(new VistaRegistro());
                
            }
        });

        frmPrincipal.btnCaja.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoCaja) cargarPanel(new VistaCaja());
            }
        });

        frmPrincipal.btnReportes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoReportes) cargarPanel(new VistaReportes());
            }
        });

        frmPrincipal.btnConfiguracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoConfiguracion) cargarPanel(new VistaConfiguracion());
            }
        });

        frmPrincipal.btnUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoUsuarios) cargarPanel(new VistaUsuarios());
            }
        });

        frmPrincipal.btnRoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (permisoRoles) cargarPanel(new VistaRoles());
            }
        });

        frmPrincipal.btnSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int op = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "Salir", 0);
                if (op == 0) {
                    new Clogin().FrmLogin.setVisible(true);
                    frmPrincipal.dispose();
                }
            }
        });
    }

    private void cargarPanel(JPanel panel) {
        panel.setSize(740, 640);
        frmPrincipal.contenedor.removeAll();
        frmPrincipal.contenedor.add(panel, BorderLayout.CENTER);
        frmPrincipal.contenedor.revalidate();
        frmPrincipal.contenedor.repaint();
    }

    private void tipoRolPanel(Rol rol) {
        switch (rol.getDescripcion()) {
            case "Administrador":
                cargarPanel(new VistaUsuarios());
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
            Usuario user = new Usuario();
            user.setUsuario("alo");
            user.setRol(new Rol(1, "Administrador", "Activo"));
            new CPrincipal(user).frmPrincipal.setVisible(true);
        });
    }
}
