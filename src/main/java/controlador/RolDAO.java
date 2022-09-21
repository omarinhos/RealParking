package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;
import servicio.Conexion;
import servicio.IDAO;

public class RolDAO implements IDAO<Rol> {

    private final String SELECT = "SELECT * FROM rol";
    private final String INSERT = "INSERT INTO rol (descripcion, estado) VALUES (?, ?)";
    private final String UPDATEROL = "UPDATE rol SET estado = ? WHERE id_rol = ?  ";
    private final String UPDATEUSER = "UPDATE usuarios SET estado = ? WHERE id_rol = ?";
    private final String FINDBY = "SELECT * FROM rol WHERE id_rol = ";
    private final String SEARCH = "SELECT * FROM rol where descripcion like";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Rol rol) {

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT)) {

            stmt.setString(1, rol.getDescripcion());
            stmt.setString(2, rol.getEstado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//falta hacer este metodo
    @Override
    public Rol findBy(String id) {
        Rol rol = null;
        try ( Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareCall(FINDBY + id);
                ResultSet rs = stmt.executeQuery()) {
            
           
            if (rs.next()) {
                rol = new Rol();
                rol = crearRol(rs);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rol;
    }

    @Override
    public void update(Rol rol) {
        try (Connection conn = getConnection();
                PreparedStatement stmtrol = conn.prepareStatement(UPDATEROL);
                PreparedStatement stmtuser = conn.prepareStatement(UPDATEUSER)) {

            stmtrol.setString(1, rol.getEstado());
            stmtrol.setInt(2, rol.getId());

            stmtrol.executeUpdate();

            stmtuser.setString(1, rol.getEstado());
            stmtuser.setInt(2, rol.getId());

            stmtuser.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Rol> find(String buscar
    ) {
        List<Rol> roles = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SEARCH + " '" + buscar + "%'");) {

            while (rs.next()) {
                Rol rol = crearRol(rs);
                roles.add(rol);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    @Override
    public List<Rol> getList() {
        List<Rol> roles = new ArrayList<>();

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SELECT);) {

            while (rs.next()) {
                Rol rol = crearRol(rs);
                roles.add(rol);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    private Rol crearRol(ResultSet rs) throws SQLException {
        Rol rol = new Rol();
        rol.setId(rs.getInt("id_rol"));
        rol.setDescripcion(rs.getString("descripcion"));
        rol.setEstado(rs.getString("estado"));

        return rol;
    }

}
