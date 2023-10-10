package controlador;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import dao.TicketDAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.Configuracion;
import modelo.Ticket;

public class GeneradorTicket extends GenerarReporte{

    public GeneradorTicket(Configuracion configuracion) {
        super(configuracion);
    }
    
    public void crearTicket() {
        TicketDAO tdao = new TicketDAO();
        Ticket ticket = tdao.findBy("");
        nombreArchivo = "tickets/ticket-" + ticket.getId() + ".pdf";
        
        try {
            FileOutputStream ficheroPdf = new FileOutputStream(nombreArchivo);
            PdfWriter.getInstance(doc, ficheroPdf);
            doc.open();
            agregarLinea("---------------------------------------------------------------", 10);
            agregarLineaCenter(configuracion.getRazonSocial(), 10);
            agregarLineaCenter("RUC: " + configuracion.getRUC(), 12);
            agregarLineaCenter(configuracion.getNombreComercial() + " - " + "NUEVO CHIMBOTE", 12);
            agregarLineaCenter("Ticket N° " + ticket.getId(), 16);
            agregarLinea("---------------------------------------------------------------", 10);
            agregarLineaCenter("PLACA: " + ticket.getPlaca(), 16);
            agregarLineaCenter("FECHA: " + ticket.getHoraIngreso(), 10);
            agregarLineaCenter("Tarifa única: S/ " + configuracion.getTarifa(), 10);
            agregarLinea("---------------------------------------------------------------", 10);
            agregarLineaCenter("Cancelar en los módulos de caja antes de retirarse", 8);
            agregarLinea("---------------------------------------------------------------", 10);
            doc.close();
            System.out.println(nombreArchivo + " creado");
        } catch (DocumentException | FileNotFoundException e) {
            Logger.getLogger(GeneradorTicket.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}