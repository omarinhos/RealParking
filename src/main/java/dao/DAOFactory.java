package dao;

import modelo.Ticket;

public class DAOFactory {

    public static DAO<UsuarioDTO> getUsuarioDAO() {
        return new UsuarioDAO();
    }

    public static DAO<RolDTO> getRolDAO() {
        return new RolDAO();
    }

    public static DAO<ConfiguracionDTO> getTxtConfiguracionDAO() {
        return new TxtConfiguracionDAO();
    }
    
    public static DAO<Ticket> getTicketDAO() {
        return new TicketDAO();
    }
    
//    public static DAO<Comprobante> getComprobanteDAO() {
//        return new ComprobanteDAO();
//    }
}
