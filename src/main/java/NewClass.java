
import controlador.UsuarioDAO;
import controlador.Validacion;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;

public class NewClass {
    
    public static void main(String[] args) {
        
        UsuarioDAO udao = new UsuarioDAO();
        
//        Usuario user = new Usuario();
//        user.setId(4);
//        user.setUsuario("71717171");
//        user.setPass("adminadmin");
//        user.setNombreCompleto("caj");
//        user.setEstado("inactivo");
//        user.setRol(new Rol(3, ""));
//        udao.update(user);
//        
//        List<Usuario> usuarios = udao.getList();
//        
//        usuarios.forEach(System.out::println);

        Usuario user = new Usuario();
        user.setUsuario("71397");
        
        Validacion v = new Validacion();
        
        if (v.exiteUsuario(user)) {
            System.out.println("SI exite");
        }
        
    }
}