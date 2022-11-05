package dao;

import java.util.List;
import modelo.*;

public class BusinessLogic {

    DAO<Usuario> usuarioDAO = DAOFactory.getUsuarioDAO();
    DAO<Rol> rolDAO = DAOFactory.getRolDAO();
    DAO<Configuracion> configuracionDAO = DAOFactory.getTxtConfiguracionDAO();
    DAO<Ticket> ticketDAO = DAOFactory.getTicketDAO();
    DAO<Comprobante> comprobanteDAO = DAOFactory.getComprobanteDAO();
    DAO<Incidente> incidenteDAO = DAOFactory.getIncidenteDAO();

    //Métodos Usuario
    public void crearUsuario(Usuario usuario) {
        usuarioDAO.create(usuario);
    }

    public Usuario buscarPorUsuario(String user) {
        return usuarioDAO.findBy(user);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public List<Usuario> filtrarPorUsuario(String user) {
        return usuarioDAO.filter(user);
    }

    public List<Usuario> getListaUsuario() {
        return usuarioDAO.getList();
    }

    //Métodos Rol
    public void crearRol(Rol rol) {
        rolDAO.create(rol);
    }

    public Rol buscarPorRol(String id) {
        return rolDAO.findBy(id);
    }

    public void actualizarRol(Rol rol) {
        rolDAO.update(rol);
    }

    public List<Rol> filtrarPorRol(String buscar) {
        return rolDAO.filter(buscar);
    }

    public List<Rol> getListaRol() {
        return rolDAO.getList();
    }

    //Métodos Configuracion
    public void guardarConfiguracion(Configuracion configuracion) {
        configuracionDAO.create(configuracion);
    }

    public Configuracion leerConfiguracion(String nombreArchivo) {
        return configuracionDAO.findBy(nombreArchivo);
    }
    
    //métodos registro y caja
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
   
    public void crearComprobante(Comprobante comprobante) {
        comprobanteDAO.create(comprobante);
    }
    
    public List<Comprobante> getListaComprobantes() {
        return comprobanteDAO.getList();
    }
    
    public void crearIncidente(Incidente incidente) {
        incidenteDAO.create(incidente);
    }

    public List<Comprobante> filtrarComprobantes(String filtro) {
        return comprobanteDAO.filter(filtro);
    } 
}
