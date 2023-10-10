 package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Configuracion;
import vista.FrmPrincipal;
import vista.VistaConfiguracion;

public class CConfiguracion {

    public VistaConfiguracion vistaConfig = new VistaConfiguracion();
    private final BusinessLogic bl = new BusinessLogic();
    private Configuracion configuracion = new Configuracion();

    public CConfiguracion(FrmPrincipal frmPrincipal) {
        vistaConfig.setSize(740, 630);
        frmPrincipal.contenedor.removeAll();
        frmPrincipal.contenedor.add(vistaConfig, BorderLayout.CENTER);
        frmPrincipal.contenedor.revalidate();
        frmPrincipal.contenedor.repaint();

        actualizarParametrosConfiguracion();

        vistaConfig.btnGuardar.addActionListener(this::btnGuardarAction);

        vistaConfig.btnModificar.addActionListener(this::btnModificarAction);
        
        vistaConfig.btnContacto.addActionListener(this::btnContactoAction);
        
        vistaConfig.btnEnviar.addActionListener(this::btnEnviarAction);
    }
    
    private void actualizarParametrosConfiguracion() {
        configuracion = bl.leerConfiguracion(Configuracion.ARCHIVO_CONFIGURACION);
        vistaConfig.txtRazonSocial.setText(configuracion.getRazonSocial());
        vistaConfig.txtRUC.setText(configuracion.getRUC());
        vistaConfig.txtNombreComercial.setText(configuracion.getNombreComercial());
        vistaConfig.txtEspacios.setText("" + configuracion.getEspacios());
        vistaConfig.txtTarifa.setText("" + configuracion.getTarifa());
    }

    private void btnGuardarAction(ActionEvent e) {
        String RazonSoc = vistaConfig.txtRazonSocial.getText();
        String RUC = vistaConfig.txtRUC.getText();
        String nombreC = vistaConfig.txtNombreComercial.getText();
        String espacio = vistaConfig.txtEspacios.getText();
        String tarifa = vistaConfig.txtTarifa.getText();

        if (RazonSoc.isEmpty() || RUC.isEmpty() || nombreC.isEmpty() || espacio.isEmpty() || tarifa.isEmpty()) {
            JOptionPane.showMessageDialog(vistaConfig, "Llenar todos los campos.", "Configuración", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            configuracion.setRazonSocial(RazonSoc);
            configuracion.setRUC(RUC);
            configuracion.setNombreComercial(nombreC);
            configuracion.setEspacios(Integer.parseInt(espacio));
            configuracion.setTarifa(Double.parseDouble(tarifa));
            
            JOptionPane.showMessageDialog(vistaConfig, "Configuracion Guardada", "Configuración", JOptionPane.INFORMATION_MESSAGE);
            bl.guardarConfiguracion(configuracion);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaConfig, "NumberFormatException en Espacios y/o Tarifa" + ex,
                    "Configuración", JOptionPane.ERROR_MESSAGE);
            actualizarParametrosConfiguracion();
            
        }

        vistaConfig.txtRazonSocial.setEnabled(false);
        vistaConfig.txtRUC.setEnabled(false);
        vistaConfig.txtNombreComercial.setEnabled(false);
        vistaConfig.txtEspacios.setEnabled(false);
        vistaConfig.txtTarifa.setEnabled(false);
        vistaConfig.btnGuardar.setEnabled(false);
        vistaConfig.btnModificar.setEnabled(true);
    }

    private void btnModificarAction(ActionEvent e) {
        vistaConfig.txtRazonSocial.setEnabled(true);
        vistaConfig.txtRUC.setEnabled(true);
        vistaConfig.txtNombreComercial.setEnabled(true);
        vistaConfig.txtEspacios.setEnabled(true);
        vistaConfig.txtTarifa.setEnabled(true);
        vistaConfig.btnGuardar.setEnabled(true);
        vistaConfig.btnModificar.setEnabled(false);
    }
    
    private void btnContactoAction(ActionEvent e) {
        vistaConfig.dlgContacto.setVisible(true);
    }
    
    private void btnEnviarAction(ActionEvent e) {
        String nombre = vistaConfig.txtNombre.getText();
        String email = vistaConfig.txtEmail.getText();
        String asunto = vistaConfig.txtAsunto.getText();
        String mensaje = vistaConfig.txtMensaje.getText();

        if (nombre.isEmpty() || email.isEmpty() || asunto.isEmpty() || mensaje.isEmpty()) {
            JOptionPane.showMessageDialog(vistaConfig.dlgContacto, "Llenar todos los campos.", "Configuración", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Pattern pattern = Pattern.compile("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$\n");
        Matcher matcher = pattern.matcher(email);
        
        if (!matcher.find()) {
            JOptionPane.showMessageDialog(vistaConfig.dlgContacto, "E-mail no válido", "Configuración", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        MailContacto mail = new MailContacto("config/config.prop");
        mail.enviarEmail(asunto, mensaje, email);
        
        JOptionPane.showMessageDialog(vistaConfig.dlgContacto, "Mensaje enviado", "Configuración", JOptionPane.INFORMATION_MESSAGE);
        vistaConfig.dlgContacto.setVisible(false);
        
    }
}
