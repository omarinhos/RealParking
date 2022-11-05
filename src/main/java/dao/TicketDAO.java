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
import modelo.Ticket;

public class TicketDAO extends DAO<Ticket> {

    private final String SELECT = "SELECT * FROM ticket WHERE estado != 'retirado' AND hora_ingreso LIKE ";
    private final String INSERT = "INSERT INTO ticket (placa, estado, hora_ingreso) VALUES (?, ?, now())";
    private final String UPDATE = "UPDATE ticket SET estado = ?, hora_salida = now() WHERE id_ticket = ? ";
    private final String FILTER = "SELECT * FROM ticket WHERE estado != 'retirado' AND placa like '";

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public void create(Ticket ticket) {
        try ( PreparedStatement stmt = getConnection().prepareStatement(INSERT)) {

            stmt.setString(1, ticket.getPlaca());
            stmt.setString(2, ticket.getEstado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Ticket ticket) {
        try ( PreparedStatement stmt = getConnection().prepareStatement(UPDATE)) {

            if (ticket.getEstado().equals("Tránsito")) {
                stmt.setString(1, "Cancelado");
            } else {
                stmt.setString(1, "Retirado");
            }
            
            stmt.setInt(2, ticket.getId());
            stmt.executeUpdate();
    

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ticket findBy(String id) {
        return null;
    }

    @Override
    public void delete(int id) {
        try ( PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM ticket WHERE id_ticket = ?")) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ticket> filter(String placa) {
        String fechaHoy = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Ticket> tickets = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery(FILTER + placa + "%' AND hora_ingreso like '" + fechaHoy + "%' ORDER BY estado")) {
            while (rs.next()) {
                Ticket ticket = crearTicket(rs);
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }

    @Override
    public List<Ticket> getList() {
        String fechaHoy = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Ticket> tickets = new ArrayList<>();
        try ( Statement stmt = getConnection().createStatement();  
                ResultSet rs = stmt.executeQuery(SELECT + "'" + fechaHoy + "%' ORDER BY estado")) {

            while (rs.next()) {
                Ticket ticket = crearTicket(rs);
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }

    private Ticket crearTicket(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("id_ticket"));
        ticket.setPlaca(rs.getString("placa"));
        ticket.setHoraIngreso(rs.getString("hora_ingreso"));
        ticket.setEstado(rs.getString("estado"));
        return ticket;
    }

}
