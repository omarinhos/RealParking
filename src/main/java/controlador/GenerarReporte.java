package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import modelo.Configuracion;

abstract class GenerarReporte {
    
    protected Document doc;
    protected String nombreArchivo;
    protected Configuracion configuracion;
    
    public GenerarReporte(Configuracion configuracion) {
        this.configuracion = configuracion;
        Rectangle r = new Rectangle(215, 280);
        doc = new Document(r, 2, 2, 2, 2);
    }
    
    public void abrirDoc() {
        try {
            File file = new File(nombreArchivo);
            Desktop.getDesktop().open(file);
            System.out.println(nombreArchivo + " abierto");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void agregarLinea(String texto, int tamanio) throws DocumentException{
        Paragraph txt = new Paragraph(texto, fuente(tamanio));
        doc.add(txt);
    }
    
    public void agregarLineaCenter(String texto, int tamanio) throws DocumentException{
        Paragraph txt = new Paragraph(texto, fuente(tamanio));
        txt.setAlignment(FlowLayout.CENTER);
        doc.add(txt);
    }
    
    public Font fuente(int tamanio) {
        return FontFactory.getFont("Monospaced", tamanio);
    }
    
}