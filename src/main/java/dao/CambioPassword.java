package dao;

import javax.swing.*;
import java.sql.*;

public class CambioPassword {

    public static boolean verificarPasswordAnterior(Connection conn, int usuarioId, String newPassword) throws SQLException {
        String query = "SELECT COUNT(*) FROM historial_passwords WHERE id_usuario = ? AND password = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, usuarioId);
            stmt.setString(2, newPassword);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        }
    }

    public static void cambiarPassword(Connection conn, int usuarioId, String newPassword) throws SQLException {
        String insertHistorialQuery = "INSERT INTO historial_passwords (id_usuario, password) VALUES (?, ?)";
        String updateUsuarioQuery = "UPDATE usuarios SET pass = ?, ultima_modificacion_pass = now() WHERE id_usuario = ?";
        try (PreparedStatement insertStmt = conn.prepareStatement(insertHistorialQuery);
             PreparedStatement updateStmt = conn.prepareStatement(updateUsuarioQuery)) {

            conn.setAutoCommit(false);

            if (verificarPasswordAnterior(conn, usuarioId, newPassword)) {
                JOptionPane.showMessageDialog(null, "La nueva contraseña ya ha sido utilizada anteriormente. Por favor, elige otra.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                return;
            }

            insertStmt.setInt(1, usuarioId);
            insertStmt.setString(2, newPassword);
            insertStmt.executeUpdate();

            updateStmt.setString(1, newPassword);
            updateStmt.setInt(2, usuarioId);
            updateStmt.executeUpdate();

            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Contraseña cambiada exitosamente.");
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }
}
