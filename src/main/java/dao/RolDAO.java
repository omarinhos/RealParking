package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Rol;

public class RolDAO extends DAO<Rol> {

    private static final String SELECT = "SELECT * FROM rol";
    private static final String INSERT = "INSERT INTO rol (id_rol, descripcion, estado) VALUES (?, ?, ?)";
    private static final String UPDATEROL = "UPDATE rol SET descripcion = ?, estado = ? WHERE id_rol = ? ";
    private static final String UPDATEUSER = "UPDATE usuarios SET estado = ? WHERE id_rol = ?";
    private static final String FINDBY = "SELECT * FROM rol WHERE id_rol = ?";
    private static final String FILTER = "SELECT * FROM rol WHERE descripcion LIKE ?";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Rol rol) {

        try ( PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setInt(1, rol.getId());
            stmt.setString(2, rol.getDescripcion());
            stmt.setString(3, rol.getEstado());

            stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Rol ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Rol findBy(String id) {
        Rol rolDTO = null;
        try (PreparedStatement stmt = getConnection().prepareStatement(FINDBY)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rolDTO = crearRol(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolDTO;
    }

    @Override
    public void update(Rol rol) {
        try ( PreparedStatement stmtrol = getConnection().prepareStatement(UPDATEROL);  
                PreparedStatement stmtuser = getConnection().prepareStatement(UPDATEUSER)) {

            stmtrol.setString(1, rol.getDescripcion());
            stmtrol.setString(2, rol.getEstado());
            stmtrol.setInt(3, rol.getId());

            stmtrol.executeUpdate();

            stmtuser.setString(1, rol.getEstado());
            stmtuser.setInt(2, rol.getId());

            stmtuser.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Rol ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Rol> filter(String buscar) {
        List<Rol> rolesDTO = new ArrayList<>();

        try (PreparedStatement stmt = getConnection().prepareStatement(FILTER)) {
            stmt.setString(1, buscar + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Rol rol = crearRol(rs);
                rolesDTO.add(rol);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesDTO;
    }

    @Override
    public List<Rol> getList() {
        List<Rol> roles = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery(SELECT)) {

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

    @Override
    public void delete(int id) {
    }

}
