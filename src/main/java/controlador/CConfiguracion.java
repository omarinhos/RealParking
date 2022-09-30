package controlador;

import dao.BusinessLogic;
import dao.ConfiguracionDTO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import vista.FrmPrincipal;
import vista.VistaConfiguracion;

public class CConfiguracion {

    public VistaConfiguracion vistaConfig = new VistaConfiguracion();
    private final BusinessLogic bl = new BusinessLogic();
    private ConfiguracionDTO configuracionDTO = new ConfiguracionDTO();

    public CConfiguracion(FrmPrincipal FrmP) {
        vistaConfig.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaConfig, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        configuracionDTO = bl.leerConfiguracion(ConfiguracionDTO.ARCHIVO_CONFIGURACION);
        vistaConfig.txtRazonSocial.setText(configuracionDTO.getRazonSocial());
        vistaConfig.txtRUC.setText(configuracionDTO.getRUC());
        vistaConfig.txtNombreComercial.setText(configuracionDTO.getNombreComercial());
        vistaConfig.txtEspacios.setText("" + configuracionDTO.getEspacios());
        vistaConfig.txtTarifa.setText("" + configuracionDTO.getTarifa());

        vistaConfig.btnGuardar.addActionListener(e -> {
            btnGuardarAction(e);
        });

        vistaConfig.btnModificar.addActionListener(e -> {
            btnModificarAction(e);
        });
    }

    private boolean btnGuardarAction(ActionEvent e) {
        String RazonSoc = vistaConfig.txtRazonSocial.getText();
        String RUC = vistaConfig.txtRUC.getText();
        String nombreC = vistaConfig.txtNombreComercial.getText();
        String espacio = vistaConfig.txtEspacios.getText();
        String tarifa = vistaConfig.txtTarifa.getText();

        if (RazonSoc.isEmpty() || RUC.isEmpty() || nombreC.isEmpty() || espacio.isEmpty() || tarifa.isEmpty()) {
            JOptionPane.showMessageDialog(vistaConfig, "Llenar todos los campos.", "Configuración", 2);
            return false;
        }

        try {
            configuracionDTO.setRazonSocial(RazonSoc);
            configuracionDTO.setRUC(RUC);
            configuracionDTO.setNombreComercial(nombreC);
            configuracionDTO.setEspacios(Integer.parseInt(espacio));
            configuracionDTO.setTarifa(Double.parseDouble(tarifa));
            
            JOptionPane.showMessageDialog(vistaConfig, "Configuracion Guardada", "Configuración", 1);
            bl.guardarConfiguracion(configuracionDTO);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vistaConfig, "NumberFormatException en Espacios y/o Tarifa" + ex,
                    "Configuración", 0);
        }

        vistaConfig.txtRazonSocial.setEnabled(false);
        vistaConfig.txtRUC.setEnabled(false);
        vistaConfig.txtNombreComercial.setEnabled(false);
        vistaConfig.txtEspacios.setEnabled(false);
        vistaConfig.txtTarifa.setEnabled(false);
        vistaConfig.btnGuardar.setEnabled(false);
        vistaConfig.btnModificar.setEnabled(true);
        return true;
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
}
