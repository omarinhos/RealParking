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
    
    public boolean existeUsuario(Usuario usuario) {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario user = udao.findBy(usuario.getUsuario());
        
        if (user == null) {
            this.mostrarError("Usuario no exite.");
            return false;
        }
        
        if (!usuario.getPass().equals(user.getPass())) {
            this.mostrarError("La contraseña es incorrecta.");
            return false;
        }
        
        if (!user.getEstado().equals("activo")) {
            this.mostrarError(user.getUsuario() + " no tiene acceso al sistema.");
            return false;
        }
        
        
        return true;
    }
    
    public Usuario tipoUsuario(Usuario usuario) {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario user = udao.findBy(usuario.getUsuario());
        
        if (user == null) {
            return null;
        }
                
        return user;
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
}