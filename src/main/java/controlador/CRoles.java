package controlador;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.FrmPrincipal;
import vista.VistaRoles;

public class CRoles {
    
    VistaRoles vistaRoles;
    
    public CRoles(FrmPrincipal FrmP) {
        vistaRoles = new VistaRoles();
        
        vistaRoles.setSize(740, 640);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaRoles, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();
        
        vistaRoles.btnGuardar.addActionListener(e -> {
            System.out.println("btnGuardar");
        });
        
        vistaRoles.btnModificar.addActionListener(e -> {
            
        });
        
        vistaRoles.tblRoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("tabla");
            }
        });
    }
}