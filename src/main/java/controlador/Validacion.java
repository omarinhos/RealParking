package controlador;

import javax.swing.JOptionPane;
import modelo.Usuario;

public class Validacion {
    
    public boolean comprobarCampo(String campo) {
        if(campo.length() == 0) {
            this.mostrarError("Hay un campo vacío.");
            return false;
        }
        
        return true;
    }
    
    public boolean comprobarPass(String pass) {
        
        if(pass.length() <= 5) {
            this.mostrarError("La contraseña debe tener más de 5 caracteres.");
            return false;
        } 
        
        return true;
    }
    
    public boolean exiteUsuario(Usuario usuario) {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario user = udao.findBy(usuario.getUsuario());
        
        if (user == null) {
            this.mostrarError("Usuario no exite");
            return false;
        }
        
        return true;
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}