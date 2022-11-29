package controlador;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Usuario;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.FrmLogin;

public class Clogin {

    private final Usuario usuario = new Usuario();
    public FrmLogin FrmLogin = new FrmLogin();
    private final Validacion v = new Validacion();
    private CPrincipal cPrincipal;

    public Clogin() {

        FrmLogin.btniniciar.addActionListener(e -> {
            ingresar();
        });

        FrmLogin.btnCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        FrmLogin.btnMin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FrmLogin.setExtendedState(ICONIFIED);
            }
        });
    }

    private void ingresar() {
        if (!v.comprobarCampo(FrmLogin.txtUser.getText())) {
            return;
        }

        if (!v.comprobarCampo(String.valueOf(FrmLogin.txtPass.getPassword()))) {
            return;
        }

        usuario.setUsuario(FrmLogin.txtUser.getText());
        usuario.setPass(String.valueOf(FrmLogin.txtPass.getPassword()));

        if (!v.existeUsuario(usuario)) {
            return;
        }

        Usuario newUser = v.tipoUsuario(usuario);
        cPrincipal = new CPrincipal(newUser);
        cPrincipal.frmPrincipal.setVisible(true);
        FrmLogin.dispose();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Clogin().FrmLogin.setVisible(true);
        });
    }

}
