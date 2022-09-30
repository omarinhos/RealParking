package controlador;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.FrmPrincipal;
import vista.VistaUsuarios;

public class CUsuarios {
    
    VistaUsuarios vistaUsuarios;
    
    public CUsuarios(FrmPrincipal FrmP) {
        vistaUsuarios = new VistaUsuarios();
        
        vistaUsuarios.setSize(740, 640);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaUsuarios, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();
        
        vistaUsuarios.btnUGuardar.addActionListener(e -> {
            System.out.println("btnGuardar");
        });
        
        vistaUsuarios.btnUModificar.addActionListener(e -> {
            
        });
        
        vistaUsuarios.tblUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("tabla");
            }
        });
    }
    
}