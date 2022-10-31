package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.Incidente;

public class IncidenteDAO extends DAO<Incidente> {

    private final String INSERT = "INSERT INTO incidente (id_ticket, id_usuario, dni, nombre_completo, fecha) VALUES (?,?,?,?,now())";
    
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Incidente incidente) {
        try ( PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setInt(1, incidente.getTicket().getId());
            stmt.setInt(2, incidente.getUsuario().getId());
            stmt.setString(3, incidente.getDNI());
            stmt.setString(4, incidente.getNombreCompleto());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Incidente findBy(String id) {
        return null;
    }

    @Override
    public void update(Incidente t) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Incidente> filter(String filtro) {
        return null;
    }

    @Override
    public List<Incidente> getList() {
        return null;
    }
    
}