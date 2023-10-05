package controlador;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import modelo.Comprobante;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GeneradorExcel {

    String nombreArchivo;
    String fecha;

    public GeneradorExcel() {
        fecha = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        nombreArchivo = "excel/reporte-" + fecha + ".xlsx";
    }

    public void crearExcel(List<Comprobante> ventas) {
        try (XSSFWorkbook xSSFWorkbook = new XSSFWorkbook()) {
            XSSFSheet sheet = xSSFWorkbook.createSheet("Hoja de datos");
            Row rowCabecera = sheet.createRow(0);
            rowCabecera.createCell(0).setCellValue("Id Comprobante");
            rowCabecera.createCell(1).setCellValue("DNI Usuario");
            rowCabecera.createCell(2).setCellValue("Placa del vehículo");
            rowCabecera.createCell(3).setCellValue("Hora de ingreso");
            rowCabecera.createCell(4).setCellValue("Hora de salida");
            rowCabecera.createCell(5).setCellValue("Importe");

            int rownum = 1;
            for (Comprobante venta : ventas) {
                Row row = sheet.createRow(rownum++);
                row.createCell(0).setCellValue(venta.getId());
                row.createCell(1).setCellValue(venta.getUsuario().getUsuario());
                row.createCell(2).setCellValue(venta.getTicket().getPlaca());
                row.createCell(3).setCellValue(venta.getTicket().getHoraIngreso());
                row.createCell(4).setCellValue(venta.getTicket().getHoraSalida());
                row.createCell(5).setCellValue(venta.getImporte());
            }

            Row rowSuma = sheet.createRow(ventas.size() + 1);
            rowSuma.createCell(5).setCellValue(ventas.stream()
                    .mapToDouble(Comprobante::getImporte)
                    .sum());
            try {
                File file = new File(nombreArchivo);
                FileOutputStream out = new FileOutputStream(file);
                xSSFWorkbook.write(out);
                Desktop.getDesktop().open(file);
                System.out.println(nombreArchivo + " open");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
