package controlador;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Usuario;
import vista.FrmLogin;
import recursos.TextPrompt;

public class Clogin {
    
    private Usuario usuario;
    public FrmLogin FrmLogin;
    private Validacion v;
    
    public Clogin() {
        usuario = new Usuario();
        FrmLogin = new FrmLogin();
        v = new Validacion();
        
        FrmLogin.btniniciar.addActionListener(e -> {
            ingresar();
        });
        
        TextPrompt txtUserTP = new TextPrompt("Ingrese su Dni", FrmLogin.txtUser);
        TextPrompt txtPassTP = new TextPrompt("Ingrese su Contraseña", FrmLogin.txtPass);
    }
    
    private boolean ingresar() {
        if (!v.comprobarCampo(FrmLogin.txtUser.getText())) {
            return false;
        }
        
        if (!v.comprobarCampo(String.valueOf(FrmLogin.txtPass.getPassword()))) {
            return false;
        }
        
        usuario.setUsuario(FrmLogin.txtUser.getText());
        usuario.setPass(String.valueOf(FrmLogin.txtPass.getPassword()));

        if (!v.existeUsuario(usuario)) {
            return false;
        }
        
        Usuario newUser = v.tipoUsuario(usuario);
        new CPrincipal(newUser).frmPrincipal.setVisible(true);
        FrmLogin.dispose();
        
        return true;
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