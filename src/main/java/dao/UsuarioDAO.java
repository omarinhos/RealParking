package dao;

import controlador.PasswordEncryption;
import modelo.Usuario;
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

public class UsuarioDAO extends DAO<Usuario> {

    private static final String SELECT = "SELECT u.*, r.descripcion, r.estado FROM usuarios AS u INNER JOIN rol AS r ON r.id_rol = u.id_rol ORDER BY u.id_usuario";
    private static final String INSERT = "INSERT INTO usuarios (usuario, pass, nombre_completo, estado, id_rol) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE usuarios SET usuario = ?, pass = ?, nombre_completo = ?, estado = ?, id_rol = ? WHERE id_usuario = ?";
    private static final String FINDBY = "SELECT u.*, r.descripcion, r.estado FROM rol AS r INNER JOIN usuarios AS u ON r.id_rol = u.id_rol WHERE usuario = ?";
    private static final String FILTER = "SELECT u.*, r.descripcion, r.estado FROM rol AS r INNER JOIN usuarios AS u ON r.id_rol = u.id_rol where u.usuario like ?";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Usuario usuario) {
        try {
            getConnection().setAutoCommit(false);

            try (PreparedStatement stmt = getConnection().prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getPass());
                stmt.setString(3, usuario.getNombreCompleto());
                stmt.setString(4, usuario.getEstado());
                stmt.setInt(5, usuario.getRol().getId());
                stmt.executeUpdate();

                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int usuarioId = generatedKeys.getInt(1);

                    String insertHistorialQuery = "INSERT INTO historial_passwords (id_usuario, password) VALUES (?, ?)";
                    try (PreparedStatement insertStmt = getConnection().prepareStatement(insertHistorialQuery)) {
                        insertStmt.setInt(1, usuarioId);
                        insertStmt.setString(2, usuario.getPass());
                        insertStmt.executeUpdate();
                    }
                } else {
                    throw new SQLException("No se pudo obtener el ID del usuario creado.");
                }
                getConnection().commit();
            } catch (SQLIntegrityConstraintViolationException e) {
                getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Usuario ya existe");
                throw new RuntimeException(e);
            } catch (SQLException e) {
                getConnection().rollback();
                throw new RuntimeException(e);
            } finally {
                getConnection().setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario findBy(String user) {
        Usuario usuario = null;
        try (PreparedStatement stmt = getConnection().prepareCall(FINDBY)) {
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario = crearUsuario(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    @Override
    public void update(Usuario usuario) {
        try {
            getConnection().setAutoCommit(false);

            try (PreparedStatement stmt = getConnection().prepareStatement(UPDATE)) {
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getPass());
                stmt.setString(3, usuario.getNombreCompleto());
                stmt.setString(4, usuario.getEstado());
                stmt.setInt(5, usuario.getRol().getId());
                stmt.setInt(6, usuario.getId());

                stmt.executeUpdate();

                // Agregar la nueva contraseña al historial
                String insertHistorialQuery = "INSERT INTO historial_passwords (id_usuario, password) VALUES (?, ?)";
                try (PreparedStatement insertStmt = getConnection().prepareStatement(insertHistorialQuery)) {
                    insertStmt.setInt(1, usuario.getId());
                    insertStmt.setString(2, usuario.getPass());
                    insertStmt.executeUpdate();
                }

                getConnection().commit();
            } catch (SQLIntegrityConstraintViolationException e) {
                getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Usuario ya existe");
                throw new RuntimeException(e);
            } catch (SQLException e) {
                getConnection().rollback();
                throw new RuntimeException(e);
            } finally {
                getConnection().setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Usuario> filter(String buscar) {
        List<Usuario> usuarios = new ArrayList<>();

        try (PreparedStatement stmt = getConnection().prepareStatement(FILTER)) {
            stmt.setString(1, "%" + buscar + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = crearUsuario(rs);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public List<Usuario> getList() {
        List<Usuario> usuarios = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement();
                ResultSet rs = stmt.executeQuery(SELECT);) {

            while (rs.next()) {
                Usuario usuario = crearUsuario(rs);
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    private Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getInt("id_usuario"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setPass(PasswordEncryption.desencriptar(rs.getString("pass")));
        usuario.setNombreCompleto(rs.getString("nombre_completo"));
        usuario.setEstado(rs.getString(5));
        usuario.setCambiarPassword(rs.getBoolean("cambiar_password"));
        Rol rol = new Rol();
        rol.setId(rs.getInt("id_rol"));
        rol.setDescripcion(rs.getString("descripcion"));
        rol.setEstado(rs.getString(8));
        usuario.setRol(rol);
        return usuario;
    }

    @Override
    public void delete(int id) {
    }

    public void cambiarPassword(String user, String newPassword) {
        try {
            Usuario usuario = findBy(user);
            CambioPassword.cambiarPassword(getConnection(), usuario.getId(), newPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
