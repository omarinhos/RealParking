package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.Comprobante;
import modelo.Configuracion;
import modelo.Incidente;
import modelo.Ticket;
import modelo.Usuario;
import vista.FrmPrincipal;
import vista.VistaCaja;

public class CCaja {

    public final VistaCaja vistaCaja = new VistaCaja();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloTicket = new DefaultTableModel();
    private final DefaultTableModel modeloVenta = new DefaultTableModel();
    private List<Ticket> tickets = new ArrayList<>();
    private List<Comprobante> ventas = new ArrayList<>();
    private final Configuracion configuracion;

    TableColumnModel columnModelT = vistaCaja.tblTicket.getColumnModel();
    TableColumnModel columnModelV = vistaCaja.tblVentas.getColumnModel();
    DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();

    private int idTicket, x;

    public CCaja(FrmPrincipal FrmP, Usuario usuario) {
        vistaCaja.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaCaja, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);

        String cabecera[] = {"Id", "Placa", "Hora de Ingreso", "Estado"};
        modeloTicket.setColumnIdentifiers(cabecera);
        vistaCaja.tblTicket.setModel(modeloTicket);

        String cabeceraV[] = {"Id Ticket", "Placa", "Fecha", "Importe"};
        modeloVenta.setColumnIdentifiers(cabeceraV);
        vistaCaja.tblVentas.setModel(modeloVenta);

        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        configuracion = bl.leerConfiguracion(Configuracion.ARCHIVO_CONFIGURACION);
        vistaCaja.lblTarifa.setText(String.valueOf(configuracion.getTarifa()));

        vistaCaja.btnGenerarPago.addActionListener(e -> btnGenerarPago(e, usuario));

        vistaCaja.btnRegistrarIncidente.addActionListener(this::btnRegistrarIncidente);

        vistaCaja.btnVentasDia.addActionListener(this::btnVentasDiaAction);

        vistaCaja.btnMostrar.addActionListener(this::btnMostrarAction);

        vistaCaja.tblTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblRegistroMouseClicked(e);
            }
        });

        vistaCaja.btnGenerarComprobanteDlg.addActionListener(e -> btnGenerarPagoDlg(e, usuario));
    }

    private void actualizarTablaTickets() {
        modeloTicket.setRowCount(0);

        tickets = tickets.stream()
                .filter(f -> f.getEstado().equals("Tránsito"))
                .collect(Collectors.toList());

        tickets.forEach(registro -> {
            modeloTicket.addRow(new Object[]{
                registro.getId(),
                registro.getPlaca(),
                registro.getHoraIngreso(),
                registro.getEstado()
            });
        });
        columnModelT.getColumn(0).setCellRenderer(dtcr);
        columnModelT.getColumn(2).setCellRenderer(dtcr);
    }

    private void actualizarTablaVentas() {
        ventas = bl.getListaComprobantes();
        modeloVenta.setRowCount(0);
        ventas.forEach(venta -> {
            modeloVenta.addRow(new Object[]{
                venta.getId(),
                venta.getTicket().getPlaca(),
                venta.getFecha(),
                venta.getImporte()
            });
        });
        columnModelV.getColumn(0).setCellRenderer(dtcr);
        columnModelV.getColumn(2).setCellRenderer(dtcr);
        columnModelV.getColumn(3).setCellRenderer(dtcr);
    }

    private void btnMostrarAction(ActionEvent e) {
        String placa = vistaCaja.txtPlaca.getText();
        tickets = bl.filtrarPorPlaca(placa);
        actualizarTablaTickets();
        vistaCaja.btnRegistrarIncidente.setEnabled(false);
        vistaCaja.btnGenerarPago.setEnabled(false);
    }

    private void btnVentasDiaAction(ActionEvent e) {
        actualizarTablaVentas();
        vistaCaja.lblVehículos.setText("" + ventas.size());
        vistaCaja.lblIngresos.setText("" + ventas.stream()
                .mapToDouble(v -> v.getImporte())
                .sum());
        vistaCaja.dlgVentas.setVisible(true);
    }

    private void btnRegistrarIncidente(ActionEvent e) {
        vistaCaja.dlgIncidente.setVisible(true);

    }

    private void btnGenerarPago(ActionEvent e, Usuario usuario) {
        Ticket ticket = new Ticket();
        ticket.setId(idTicket);
        ticket.setEstado(tickets.get(x).getEstado());
        bl.actualizarEstadoVehiculo(ticket);
        JOptionPane.showMessageDialog(vistaCaja, "Pago registrado.", "Pago", 1);

        Comprobante comprobante = new Comprobante();
        comprobante.setTicket(ticket);
        comprobante.setUsuario(usuario);
        comprobante.setImporte(configuracion.getTarifa());
        bl.crearComprobante(comprobante);

        //Pendiente generar comprobante
        JOptionPane.showMessageDialog(vistaCaja, "Comprobante en pantalla", "", 1);

        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        vistaCaja.btnGenerarPago.setEnabled(false);
        vistaCaja.btnRegistrarIncidente.setEnabled(false);
    }

    private void tblRegistroMouseClicked(MouseEvent e) {
        x = vistaCaja.tblTicket.getSelectedRow();

        idTicket = tickets.get(x).getId();
        vistaCaja.btnGenerarPago.setEnabled(true);
        vistaCaja.btnRegistrarIncidente.setEnabled(true);
    }

    private void btnGenerarPagoDlg(ActionEvent e, Usuario usuario) {
        String nombreCompleto = vistaCaja.txtNombreCompleto.getText();
        String dni = vistaCaja.txtDNI.getText();
        if (!nombreCompleto.isEmpty() && !dni.isEmpty()) {
            Incidente incidente = new Incidente();
            Ticket ticket = new Ticket();
            ticket.setId(idTicket);
            incidente.setTicket(ticket);
            incidente.setUsuario(usuario);
            incidente.setDNI(dni);
            incidente.setNombreCompleto(nombreCompleto);
            bl.crearIncidente(incidente);
            btnGenerarPago(e, usuario);
            vistaCaja.dlgIncidente.setVisible(false);
            vistaCaja.txtDNI.setText("");
            vistaCaja.txtNombreCompleto.setText("");
        } else {
            JOptionPane.showMessageDialog(vistaCaja.dlgIncidente, "Llenar todos los campos.", "Campos Vacíos", 2);
        }
    }
}
