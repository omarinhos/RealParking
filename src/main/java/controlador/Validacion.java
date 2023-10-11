package controlador;

import dao.BusinessLogic;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Validacion {

    private final PasswordEncryption passwordEncryption = new PasswordEncryption();

    public boolean comprobarCampo(String campo) {
        if(campo.isEmpty()) {
            this.mostrarError("Hay un campo vacío.");
            return true;
        }
        return false;
    }
    
    public boolean comprobarPass(String pass) {
        if(pass.length() <= 5) {
            this.mostrarError("La contraseña debe tener más de 5 caracteres.");
            return false;
        } 
        
        return true;
    }
    
    public boolean existeUsuario(Usuario usuario) {
        BusinessLogic bsl = new BusinessLogic();
        Usuario user = bsl.buscarPorUsuario(usuario.getUsuario());
        
        if (user == null) {
            this.mostrarError("Usuario o contraseña incorrecto.");
            return false;
        }
        
        if (!usuario.getPass().equals(PasswordEncryption.desencriptar(user.getPass()))) {
            this.mostrarError("Usuario o contraseña incorrecta.");
            return false;
        }
        
        if (user.getEstado().equals("Inactivo")) {
            this.mostrarError(user.getUsuario() + " no tiene acceso al sistema.");
            return false;
        }

        if (user.getCambiarPassword()) {
            this.mostrarError(user.getUsuario() + " necesita actualizar su contraseña.");
            return false;
        }

        return true;
    }
    
    public Usuario tipoUsuario(Usuario usuario) {
        UsuarioDAO udao = new UsuarioDAO();
        return udao.findBy(usuario.getUsuario());
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.WARNING_MESSAGE);
    }
    
}