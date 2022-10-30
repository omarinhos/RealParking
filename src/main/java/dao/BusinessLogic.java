package dao;

import java.util.List;
import modelo.Ticket;

public class BusinessLogic {

    DAO<UsuarioDTO> usuarioDAO = DAOFactory.getUsuarioDAO();
    DAO<RolDTO> rolDAO = DAOFactory.getRolDAO();
    DAO<ConfiguracionDTO> configuracionDAO = DAOFactory.getTxtConfiguracionDAO();
    DAO<Ticket> ticketDAO = DAOFactory.getTicketDAO();

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

    public List<UsuarioDTO> getListaUsuario() {
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

    public List<RolDTO> getListaRol() {
        return rolDAO.getList();
    }

    //metodo Configuracion
    public void guardarConfiguracion(ConfiguracionDTO configuracionDTO) {
        configuracionDAO.create(configuracionDTO);
    }

    public ConfiguracionDTO leerConfiguracion(String nombreArchivo) {
        return configuracionDAO.findBy(nombreArchivo);
    }
    
    public List<Ticket> getListaTickets() {
        return ticketDAO.getList();
    }
    
    public void crearTicket(Ticket ticket) {
        ticketDAO.create(ticket);
    }
    
    public void eliminarTicket(int id) {
        ticketDAO.delete(id);
    }
    
    public List<Ticket> filtrarPorPlaca(String placa) {
        return ticketDAO.filter(placa);
    }
    
    public void actualizarEstadoVehiculo(Ticket ticket) {
        ticketDAO.update(ticket);
    }

}
