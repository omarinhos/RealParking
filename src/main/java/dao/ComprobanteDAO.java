package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import modelo.Comprobante;
import modelo.Ticket;
import modelo.Usuario;

public class ComprobanteDAO extends DAO<Comprobante> {

    private final String INSERT = "INSERT INTO comprobante (id_ticket, id_usuario, fecha, importe) VALUES (?,?,now(),?)";
    private final String SELECT = "SELECT c.id_comprobante, u.usuario, c.id_ticket, c.fecha, t.placa, c.importe, t.hora_ingreso, t.hora_salida\n"
            + "FROM comprobante AS c JOIN ticket AS t ON c.id_ticket = t.id_ticket JOIN usuarios AS u ON u.id_usuario = c.id_usuario\n"
            + "WHERE c.fecha LIKE '";
    private final String FINDBY = "SELECT c.id_comprobante, u.usuario, c.id_ticket, c.fecha, t.placa, c.importe, t.hora_ingreso, t.hora_salida \n" +
            "FROM comprobante AS c JOIN ticket AS t ON c.id_ticket = t.id_ticket JOIN usuarios AS u ON u.id_usuario = c.id_usuario \n" +
            "order by c.id_comprobante desc limit 1";
    private final String FILTER = "SELECT c.id_comprobante, u.usuario, c.id_ticket, c.fecha, t.placa, c.importe, t.hora_ingreso, t.hora_salida\n"
            + "            FROM comprobante AS c JOIN ticket AS t ON c.id_ticket = t.id_ticket JOIN usuarios AS u ON u.id_usuario = c.id_usuario ";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Comprobante comprobante) {
        try ( PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setInt(1, comprobante.getTicket().getId());
            stmt.setInt(2, comprobante.getUsuario().getId());
            stmt.setDouble(3, comprobante.getImporte());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Comprobante findBy(String id) {
        Comprobante comprobante = null;
        try ( PreparedStatement stmt = getConnection().prepareCall(FINDBY);  
                ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                comprobante = new Comprobante();
                comprobante = crearComprobante(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return comprobante;
    }

    @Override
    public void update(Comprobante comprobante) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public List<Comprobante> filter(String filtro) {
        List<Comprobante> comprobantes = new ArrayList<>();

        String desde = filtro.split("/")[0];
        String hasta = filtro.split("/")[1];
        String user = filtro.split("/")[2];

        if (user.equals("Todos los usuarios")) {
            user = "";
        }

        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery(FILTER + "WHERE c.fecha >= cast('" + desde + " 00:00:00' AS DATETIME) and c.fecha <= cast('" + hasta + " 23:59:59' AS DATETIME) and u.usuario like '%" + user + "'")) {
            while (rs.next()) {
                Comprobante comprobante = crearComprobante(rs);
                comprobantes.add(comprobante);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return comprobantes;
    }

    @Override
    public List<Comprobante> getList() {
        String fechaHoy = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Comprobante> comprobantes = new ArrayList<>();

        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery(SELECT + fechaHoy + "%'")) {
            while (rs.next()) {
                Comprobante comprobante = crearComprobante(rs);
                comprobantes.add(comprobante);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return comprobantes;
    }

    private Comprobante crearComprobante(ResultSet rs) throws SQLException {
        Comprobante comprobante = new Comprobante();
        Ticket ticket = new Ticket();
        Usuario usuario = new Usuario();
        comprobante.setId(rs.getInt("id_comprobante"));
        usuario.setUsuario(rs.getString("usuario"));
        ticket.setId(rs.getInt("id_ticket"));
        comprobante.setFecha(rs.getString("fecha"));
        ticket.setPlaca(rs.getString("placa"));
        comprobante.setImporte(rs.getDouble("importe"));
        ticket.setHoraIngreso(rs.getString("hora_ingreso"));
        ticket.setHoraSalida(rs.getString("hora_salida"));
        comprobante.setUsuario(usuario);
        comprobante.setTicket(ticket);
        return comprobante;
    }

}
