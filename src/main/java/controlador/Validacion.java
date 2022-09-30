package controlador;

import dao.BusinessLogic;
import dao.UsuarioDAO;
import javax.swing.JOptionPane;
import dao.UsuarioDTO;

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
    
    public boolean existeUsuario(UsuarioDTO usuario) {
        BusinessLogic bsl = new BusinessLogic();
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioDTO user = bsl.buscarPorUsuario(usuario.getUsuario());
        
        if (user == null) {
            this.mostrarError("Usuario o contraseña incorrecto.");
            return false;
        }
        
        if (!usuario.getPass().equals(user.getPass())) {
            this.mostrarError("Usuario o contraseña incorrecta.");
            return false;
        }
        
        if (!user.getEstado().equals("Activo")) {
            this.mostrarError(user.getUsuario() + " no tiene acceso al sistema.");
            return false;
        }
        
        
        return true;
    }
    
    public UsuarioDTO tipoUsuario(UsuarioDTO usuario) {
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioDTO user = udao.findBy(usuario.getUsuario());
        
        if (user == null) {
            return null;
        }
                
        return user;
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", 2);
    }
    
}