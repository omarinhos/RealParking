package dao;

import java.util.List;

public class BusinessLogic {

    
    DAO<UsuarioDTO> usuarioDAO = DAOFactory.getUsuarioDAO();
    DAO<RolDTO> rolDAO = DAOFactory.getRolDAO();
    DAO<ConfiguracionDTO> configuracionDAO = DAOFactory.getTxtConfiguracionDAO();

    //metodos Usuario
    public void crearUsuario(UsuarioDTO usuarioDTO) {
        usuarioDAO.create(usuarioDTO);

    }

    public UsuarioDTO buscarPorUsuario(String user) {
        return usuarioDAO.findBy(user);

    }

    public void actualizarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDAO.update(usuarioDTO);
    }

    public List<UsuarioDTO> filtrarPorUsuario(String user) {
        return usuarioDAO.filter(user);
    }

    public List<UsuarioDTO> mostrarListaUsuario() {

        return usuarioDAO.getList();
    }

    //metodos Rol
    public void crearRol(RolDTO rolDTO) {
        rolDAO.create(rolDTO);

    }

    public RolDTO buscarPorRol(String id) {
        return rolDAO.findBy(id);

    }

    public void actualizarRol(RolDTO rolDTO) {
        rolDAO.update(rolDTO);
    }

    public List<RolDTO> filtrarPorRol(String buscar) {
        return rolDAO.filter(buscar);
    }

    public List<RolDTO> mostrarListaRol() {

        return rolDAO.getList();
    }

    //metodo Configuracion
    public void guardarConfiguracion(ConfiguracionDTO configuracionDTO) {

        configuracionDAO.create(configuracionDTO);

    }

    public ConfiguracionDTO LeerConfiguracion(String nombreArchivo) {
        return configuracionDAO.findBy(nombreArchivo);
    }

}
