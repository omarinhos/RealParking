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
import javax.swing.table.DefaultTableModel;
import modelo.Comprobante;
import modelo.Configuracion;
import modelo.Ticket;
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
    
    private int idTicket, x;

    public CCaja(FrmPrincipal FrmP) {
        vistaCaja.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaCaja, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        String cabecera[] = {"Id", "Placa", "Hora de Ingreso", "Estado"};
        modeloTicket.setColumnIdentifiers(cabecera);
        vistaCaja.tblTicket.setModel(modeloTicket);
        
        String cabeceraV[] = {"Id Ticket", "Placa", "Fecha", "Importe"};
        modeloVenta.setColumnIdentifiers(cabeceraV);
        vistaCaja.tblVentas.setModel(modeloVenta);

        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        configuracion = bl.leerConfiguracion(Configuracion.ARCHIVO_CONFIGURACION);

        vistaCaja.btnGenerarPago.addActionListener(this::btnGenerarPago);

        vistaCaja.btnRegistrarIncidente.addActionListener(this::btnRegistrarIncidente);

        vistaCaja.btnVentasDia.addActionListener(this::btnVentasDiaAction);

        vistaCaja.btnMostrar.addActionListener(this::btnMostrarAction);

        vistaCaja.tblTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblRegistroMouseClicked(e);
            }
        });
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
    }

    private void btnMostrarAction(ActionEvent e) {
        String placa = vistaCaja.txtPlaca.getText();
        tickets = bl.filtrarPorPlaca(placa);
        actualizarTablaTickets();
    }

    private void btnVentasDiaAction(ActionEvent e) {
        actualizarTablaVentas();
        vistaCaja.dlgVentas.setVisible(true);
    }

    private void btnRegistrarIncidente(ActionEvent e) {
    }

    private void btnGenerarPago(ActionEvent e) {
        Ticket ticket = new Ticket();
        ticket.setId(idTicket);
        ticket.setEstado(tickets.get(x).getEstado());
        bl.actualizarEstadoVehiculo(ticket);
        JOptionPane.showMessageDialog(vistaCaja, "Pago registrado.", "Pago", 1);
        
        //Pendiente generar comprobante
        JOptionPane.showMessageDialog(vistaCaja, "Comprobante en pantalla", "", 1);
        
        tickets = bl.getListaTickets();
        actualizarTablaTickets();
        vistaCaja.btnGenerarPago.setEnabled(false);
    }

    private void tblRegistroMouseClicked(MouseEvent e) {
        x = vistaCaja.tblTicket.getSelectedRow();

        idTicket = tickets.get(x).getId();
        vistaCaja.btnGenerarPago.setEnabled(true);
        vistaCaja.btnRegistrarIncidente.setEnabled(true);
    }
}
