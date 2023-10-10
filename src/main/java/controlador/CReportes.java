package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Comprobante;
import modelo.Usuario;
import vista.FrmPrincipal;
import vista.VistaReportes;

public class CReportes {

    public final VistaReportes vistaReportes = new VistaReportes();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloVenta = new DefaultTableModel();
    private List<Comprobante> ventas;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public CReportes(FrmPrincipal frmPrincipal) {
        vistaReportes.setSize(740, 630);
        frmPrincipal.contenedor.removeAll();
        frmPrincipal.contenedor.add(vistaReportes, BorderLayout.CENTER);
        frmPrincipal.contenedor.revalidate();
        frmPrincipal.contenedor.repaint();

        String[] cabecera = {"Id", "Usuario", "Placa", "Hora Ingreso", "Hora Salida", "Importe"};
        modeloVenta.setColumnIdentifiers(cabecera);
        vistaReportes.tblVentas.setModel(modeloVenta);

        actualizarComboUsuarios();

        vistaReportes.btnMostrar.addActionListener(this::btnMostrarAction);

        vistaReportes.btnExportar.addActionListener(this::btnExportarAction);
    }

    private void actualizarTablaVentas() {
        modeloVenta.setRowCount(0);
        ventas.forEach(venta -> modeloVenta.addRow(new Object[]{
            venta.getId(),
            venta.getUsuario().getUsuario(),
            venta.getTicket().getPlaca(),
            venta.getTicket().getHoraIngreso(),
            venta.getTicket().getHoraSalida(),
            venta.getImporte()
        }));
        vistaReportes.resizeColumnWidth(vistaReportes.tblVentas);

    }

    private void actualizarComboUsuarios() {
        vistaReportes.cmbUsuarios.removeAllItems();
        vistaReportes.cmbUsuarios.addItem("Todos los usuarios");
        List<String> usuarios = bl.getListaUsuario()
                .stream()
                .map(Usuario::getUsuario)
                .collect(Collectors.toList());

        usuarios.forEach(u -> vistaReportes.cmbUsuarios.addItem(u));
    }

    private void btnMostrarAction(ActionEvent e) {

        try {
            String desde = sdf.format(vistaReportes.jDateDesde.getCalendar().getTime());
            String hasta = sdf.format(vistaReportes.jDateHasta.getCalendar().getTime());
            String user = "" + vistaReportes.cmbUsuarios.getSelectedItem();

            ventas = bl.filtrarComprobantes(desde + "/" + hasta + "/" + user);
            actualizarTablaVentas();

            vistaReportes.lblVehiculos.setText("" + ventas.size());
            vistaReportes.lblIngresos.setText("" + ventas.stream()
                    .mapToDouble(Comprobante::getImporte)
                    .sum());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(vistaReportes, "Seleccionar las fechas", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void btnExportarAction(ActionEvent e) {
        try {
            GeneradorExcel excel = new GeneradorExcel();
            excel.crearExcel(ventas);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(vistaReportes, "Primero debe mostrar la vista previa", "Ventas vacías", JOptionPane.WARNING_MESSAGE);
        }
    }

}
