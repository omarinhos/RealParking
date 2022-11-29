package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
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

    public CReportes(FrmPrincipal FrmP) {
        vistaReportes.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaReportes, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

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
        resizeColumnWidth(vistaReportes.tblVentas);

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
            JOptionPane.showMessageDialog(vistaReportes, "Seleccionar las fechas", "Campos vacíos", 2);
        }

    }

    private void btnExportarAction(ActionEvent e) {
        try {
            GeneradorExcel excel = new GeneradorExcel();
            excel.crearExcel(ventas);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(vistaReportes, "Primero debe mostrar la vista previa", "Ventas vacías", 2);
        }
    }

    private void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 100; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 1, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }

        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        columnModel.getColumn(0).setCellRenderer(dtcr);
        columnModel.getColumn(1).setCellRenderer(dtcr);
        columnModel.getColumn(5).setCellRenderer(dtcr);

    }

}
