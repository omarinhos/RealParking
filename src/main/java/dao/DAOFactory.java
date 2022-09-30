package dao;

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
}
