package dao;

import modelo.*;

public class DAOFactory {

    public static DAO<Usuario> getUsuarioDAO() {
        return new UsuarioDAO();
    }

    public static DAO<Rol> getRolDAO() {
        return new RolDAO();
    }

    public static DAO<Configuracion> getTxtConfiguracionDAO() {
        return new TxtConfiguracionDAO();
    }
    
    public static DAO<Ticket> getTicketDAO() {
        return new TicketDAO();
    }
    
    public static DAO<Comprobante> getComprobanteDAO() {
        return new ComprobanteDAO();
    }
}
