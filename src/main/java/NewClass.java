
import dao.RolDAO;
import dao.UsuarioDAO;
import controlador.Validacion;
import dao.ConfiguracionDTO;
import java.util.ArrayList;
import java.util.List;
import dao.RolDTO;
import dao.TxtConfiguracionDAO;
import dao.UsuarioDTO;

public class NewClass {

    public static void main(String[] args) {

//        UsuarioDAO udao = new UsuarioDAO();
//        RolDAO roldao = new RolDAO();
//        RolDTO rol = new RolDTO();
//        rol.setDescripcion("abogado");
//        rol.setEstado("activo");
//        roldao.update(rol);
//
////        UsuarioDTO user = new UsuarioDTO();
////        user.setId(4);
////        user.setUsuario("71717171");
////        user.setPass("adminadmin");
////        user.setNombreCompleto("caj");
////        user.setEstado("inactivo");
////        user.setRol(new RolDTO(3, ""));
////        udao.update(user);
////        
//        List<Usuario> usuarios = udao.getList();
//        usuarios.forEach(System.out::println);
//        roldao.create(rol);
//        List<Rol> roles = roldao.find("");
//        roles.forEach(System.out::println);
//Rol rol = roldao.findBy("1");
//        System.out.println(rol);
//        UsuarioDTO user = new UsuarioDTO();
//        user.setUsuario("71397835");
////        
//        Validacion v = new Validacion();
//        System.out.println(v.tipoUsuario(user));
//        
//        if (v.exiteUsuario(user)) {
//            System.out.println("SI exite");
//        }
//        ConfiguracionDTO txtcf = new ConfiguracionDTO("Razon Social", "14523658974", "Real Plaza", 50, 2.0);
//        TxtConfiguracionDAO txtDao = new TxtConfiguracionDAO();
//        
//        txtDao.create(txtcf);
//
//        txtcf = txtDao.findBy(ConfiguracionDTO.NOMBRE_CONFIGURACION);
//        System.out.println(txtcf.getRazonSocial() + "\n" + txtcf.getRUC() + "\n" + txtcf.getNombreComercial()
//                + "\n" + txtcf.getEspacios() + "\n" + txtcf.getTarifa());
    }
}
