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
import dao.RolDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicio.Conexion;

public class UsuarioDAO extends DAO<UsuarioDTO> {

    private final String SELECT = "SELECT u.*, r.descripcion, r.estado FROM usuarios AS u INNER JOIN rol AS r ON r.id_rol = u.id_rol ORDER BY u.id_usuario";
    private String INSERT = "INSERT INTO usuarios (usuario, pass, nombre_completo, estado, id_rol) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE usuarios SET usuario = ?, pass = ?, nombre_completo = ?, estado = ?, id_rol = ? WHERE id_usuario = ?";
    private final String FINDBY = "SELECT u.*, r.descripcion, r.estado FROM rol AS r INNER JOIN usuarios AS u ON r.id_rol = u.id_rol WHERE usuario = '";
    private final String FILTER = "SELECT u.*, r.descripcion, r.estado FROM rol AS r INNER JOIN usuarios AS u ON r.id_rol = u.id_rol where u.usuario like";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getRutaFoto()!= null) {
            INSERT = "INSERT INTO usuarios (usuario, pass, nombre_completo, estado, id_rol, foto) VALUES (?, ?, ?, ?, ?, ?)";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setString(1, usuarioDTO.getUsuario());
            stmt.setString(2, usuarioDTO.getPass());
            stmt.setString(3, usuarioDTO.getNombreCompleto());
            stmt.setString(4, usuarioDTO.getEstado());
            stmt.setInt(5, usuarioDTO.getRol().getId());

            if (usuarioDTO.getRutaFoto()!= null) {
                File imageFile = new File(usuarioDTO.getRutaFoto());
                FileInputStream fis = new FileInputStream(imageFile);
                stmt.setBinaryStream(6, fis, imageFile.length());
            }

            stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Usuario ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public UsuarioDTO findBy(String user) {
        UsuarioDTO usuarioDTO = null;

        try (PreparedStatement stmt = getConnection().prepareCall(FINDBY + user + "'");
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                usuarioDTO = new UsuarioDTO();
                usuarioDTO = crearUsuario(rs);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarioDTO;
    }

    @Override
    public void update(UsuarioDTO usuarioDTO) {
        try (PreparedStatement stmt = getConnection().prepareStatement(UPDATE)) {

            stmt.setString(1, usuarioDTO.getUsuario());
            stmt.setString(2, usuarioDTO.getPass());
            stmt.setString(3, usuarioDTO.getNombreCompleto());
            stmt.setString(4, usuarioDTO.getEstado());
            stmt.setInt(5, usuarioDTO.getRol().getId());
            stmt.setInt(6, usuarioDTO.getId());

            stmt.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Usuario ya existe");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UsuarioDTO> filter(String buscar) {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(FILTER + " '" + buscar + "%' ORDER BY u.id_usuario");) {

            while (rs.next()) {
                UsuarioDTO usuarioDTO = crearUsuario(rs);
                usuariosDTO.add(usuarioDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuariosDTO;
    }

    @Override
    public List<UsuarioDTO> getList() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(SELECT);) {

            while (rs.next()) {
                UsuarioDTO usuarioDTO = crearUsuario(rs);
                usuariosDTO.add(usuarioDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuariosDTO;
    }

    private UsuarioDTO crearUsuario(ResultSet rs) throws SQLException {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(rs.getInt("id_usuario"));
        usuarioDTO.setUsuario(rs.getString("usuario"));
        usuarioDTO.setPass(rs.getString("pass"));
        usuarioDTO.setNombreCompleto(rs.getString("nombre_completo"));
        usuarioDTO.setEstado(rs.getString(5));
        RolDTO rol = new RolDTO();
        rol.setId(rs.getInt("id_rol"));
        rol.setDescripcion(rs.getString("descripcion"));
        rol.setEstado(rs.getString(8));
        usuarioDTO.setRol(rol);
        usuarioDTO.setImagen(rs.getBlob("foto"));
        return usuarioDTO;
    }

}
