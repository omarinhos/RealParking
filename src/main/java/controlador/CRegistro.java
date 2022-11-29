package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Configuracion;
import modelo.Ticket;
import vista.FrmPrincipal;
import vista.VistaRegistro;

public class CRegistro {

    public final VistaRegistro vistaRegistro = new VistaRegistro();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloTicket = new DefaultTableModel();
    private List<Ticket> tickets;
    private final Configuracion configuracion;

    TableColumnModel columnModel = vistaRegistro.tblTicket.getColumnModel();
    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

    private int idTicket, x;

    public CRegistro(FrmPrincipal FrmP) {

        vistaRegistro.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaRegistro, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        String[] cabecera = {"Id", "Placa", "Hora de Ingreso", "Estado"};
        modeloTicket.setColumnIdentifiers(cabecera);
        vistaRegistro.tblTicket.setModel(modeloTicket);

        tickets = bl.getListaTickets();
        actualizarTablaTickets();

        configuracion = bl.leerConfiguracion(Configuracion.ARCHIVO_CONFIGURACION);
        actualizarEspaciosDisponibles();

        vistaRegistro.btnIngresar.addActionListener(this::btnIngresarAction);

        vistaRegistro.btnEliminar.addActionListener(this::btnElimiarAction);

        vistaRegistro.btnMostrar.addActionListener(this::btnMostrarAction);

        vistaRegistro.btnRetirar.addActionListener(this::btnRetirarAction);

        vistaRegistro.tblTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblRegistroMouseClicked(e);
            }

        });

    }

    private void actualizarEspaciosDisponibles() {
        int espaciosDisponibles = configuracion.getEspacios() - tickets.size();
        vistaRegistro.lblEspacios.setText("" + espaciosDisponibles);
        vistaRegistro.btnIngresar.setEnabled(espaciosDisponibles >= 1);
    }

    private void actualizarTablaTickets() {
        modeloTicket.setRowCount(0);

        tickets.forEach(registro -> modeloTicket.addRow(new Object[]{
            registro.getId(),
            registro.getPlaca(),
            registro.getHoraIngreso(),
            registro.getEstado()
        }));
        columModel();
    }

    private void btnIngresarAction(ActionEvent e) {
        String placa = vistaRegistro.txtPlaca.getText().toUpperCase();

        if (!placa.isEmpty()) {

            Ticket ticket = new Ticket();
            ticket.setId(idTicket);
            ticket.setPlaca(placa);
            ticket.setEstado("Tránsito");

            bl.crearTicket(ticket);
            JOptionPane.showMessageDialog(vistaRegistro, "Vehiculo Agregado.", "Registro", 1);

            GeneradorTicket ticketPdf = new GeneradorTicket(configuracion);
            ticketPdf.crearTicket();
            ticketPdf.abrirDoc();

            tickets = bl.getListaTickets();
            actualizarTablaTickets();
            actualizarEspaciosDisponibles();
            vistaRegistro.txtPlaca.setText("");
        } else {
            JOptionPane.showMessageDialog(vistaRegistro, "Llenar todos los campos.", "Resgistro", 2);
        }
    }

    private void btnMostrarAction(ActionEvent e) {
        String placa = vistaRegistro.txtBuscar.getText().toUpperCase();
        tickets = bl.filtrarPorPlaca(placa);
        actualizarTablaTickets();
    }

    private void tblRegistroMouseClicked(MouseEvent e) {
        x = vistaRegistro.tblTicket.getSelectedRow();

        idTicket = tickets.get(x).getId();

        if (tickets.get(x).getEstado().equals("Tránsito")) {
            vistaRegistro.btnEliminar.setEnabled(true);
            vistaRegistro.btnRetirar.setEnabled(false);

        } else {
            vistaRegistro.btnRetirar.setEnabled(true);
            vistaRegistro.btnEliminar.setEnabled(false);

        }

    }

    private void btnElimiarAction(ActionEvent e) {
        bl.eliminarTicket(idTicket);
        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        actualizarEspaciosDisponibles();
        vistaRegistro.btnEliminar.setEnabled(false);
    }

    private void btnRetirarAction(ActionEvent e) {
        Ticket ticket = new Ticket();
        ticket.setId(idTicket);
        ticket.setEstado(tickets.get(x).getEstado());
        bl.actualizarEstadoVehiculo(ticket);
        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        actualizarEspaciosDisponibles();
        vistaRegistro.btnRetirar.setEnabled(false);
    }

    private void columModel() {
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        columnModel.getColumn(0).setCellRenderer(dtcr);
        columnModel.getColumn(2).setCellRenderer(dtcr);
    }
}
