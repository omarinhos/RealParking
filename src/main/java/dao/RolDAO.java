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
import servicio.Conexion;

public class RolDAO extends DAO<RolDTO> {

    private final String SELECT = "SELECT * FROM rol";
    private final String INSERT = "INSERT INTO rol (id_rol, descripcion, estado) VALUES (?, ?, ?)";
    private final String UPDATEROL = "UPDATE rol SET descripcion = ?, estado = ? WHERE id_rol = ? ";
    private final String UPDATEUSER = "UPDATE usuarios SET estado = ? WHERE id_rol = ?";
    private final String FINDBY = "SELECT * FROM rol WHERE id_rol = ";
    private final String FILTER = "SELECT * FROM rol where descripcion like";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(RolDTO rolDTO) {

        try ( PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setInt(1, rolDTO.getId());
            stmt.setString(2, rolDTO.getDescripcion());
            stmt.setString(3, rolDTO.getEstado());

            stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Rol ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public RolDTO findBy(String id) {
        RolDTO rolDTO = null;
        try ( PreparedStatement stmt = getConnection().prepareCall(FINDBY + id);  ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                rolDTO = new RolDTO();
                rolDTO = crearRol(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolDTO;
    }

    @Override
    public void update(RolDTO rolDTO) {
        try ( PreparedStatement stmtrol = getConnection().prepareStatement(UPDATEROL);  
                PreparedStatement stmtuser = getConnection().prepareStatement(UPDATEUSER)) {

            stmtrol.setString(1, rolDTO.getDescripcion());
            stmtrol.setString(2, rolDTO.getEstado());
            stmtrol.setInt(3, rolDTO.getId());

            stmtrol.executeUpdate();

            stmtuser.setString(1, rolDTO.getEstado());
            stmtuser.setInt(2, rolDTO.getId());

            stmtuser.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Rol ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RolDTO> filter(String buscar) {
        List<RolDTO> rolesDTO = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery(FILTER + " '" + buscar + "%'");) {

            while (rs.next()) {
                RolDTO rolDTO = crearRol(rs);
                rolesDTO.add(rolDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesDTO;
    }

    @Override
    public List<RolDTO> getList() {
        List<RolDTO> rolesDTO = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  ResultSet rs = stmt.executeQuery(SELECT)) {

            while (rs.next()) {
                RolDTO rolDTO = crearRol(rs);
                rolesDTO.add(rolDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rolesDTO;
    }

    private RolDTO crearRol(ResultSet rs) throws SQLException {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rs.getInt("id_rol"));
        rolDTO.setDescripcion(rs.getString("descripcion"));
        rolDTO.setEstado(rs.getString("estado"));

        return rolDTO;
    }

}
