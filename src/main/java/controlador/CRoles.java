package controlador;

import dao.BusinessLogic;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Rol;
import vista.FrmPrincipal;
import vista.VistaRoles;

public class CRoles {

    public final VistaRoles vistaRoles = new VistaRoles();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloRoles = new DefaultTableModel();
    private List<Rol> roles;
    private int idRol;

    public CRoles(FrmPrincipal FrmP) {
        vistaRoles.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaRoles, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        String[] cabecera = {"Id", "Rol", "Estado"};
        modeloRoles.setColumnIdentifiers(cabecera);
        vistaRoles.tblRoles.setModel(modeloRoles);
        
        roles = bl.getListaRol();
        actualizarTablaRoles();

        vistaRoles.btnGuardar.addActionListener(this::btnGuardarAction);

        vistaRoles.btnModificar.addActionListener(this::btnModificarAction);

        vistaRoles.tblRoles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblRolesMouseClicked(e);
            }
        });

        vistaRoles.btnNuevo.addActionListener(this::btnNuevoAction);
        
        vistaRoles.btnFiltrar.addActionListener(this::btnFiltrarAction);
    }

    private void actualizarTablaRoles() {
        modeloRoles.setRowCount(0);

        roles.forEach(rol -> modeloRoles.addRow(new Object[]{
            rol.getId(),
            rol.getDescripcion(),
            rol.getEstado()
        }));
    }

    private void btnGuardarAction(ActionEvent e) {
        String campoRol = vistaRoles.txtRol.getText();

        if (!campoRol.isEmpty()) {

            Rol rol = new Rol();

            rol.setId(roles.size() + 1);
            rol.setDescripcion(campoRol);
            rol.setEstado((String) vistaRoles.cmbEstado.getSelectedItem());

            bl.crearRol(rol);
            JOptionPane.showMessageDialog(vistaRoles, "Rol Agregado.", "Roles", 1);
            roles = bl.getListaRol();
            actualizarTablaRoles();
        } else {
            JOptionPane.showMessageDialog(vistaRoles, "Llenar todos los campos.", "Roles", 2);
        }
    }

    private void btnModificarAction(ActionEvent e) {
        String campoRol = vistaRoles.txtRol.getText();

        if (!campoRol.isEmpty()) {

            Rol rol = new Rol();

            rol.setDescripcion(campoRol);
            rol.setEstado((String) vistaRoles.cmbEstado.getSelectedItem());
            rol.setId(idRol);

            bl.actualizarRol(rol);
            JOptionPane.showMessageDialog(vistaRoles, "Rol Modificado.", "Roles", 1);
            roles = bl.getListaRol();
            actualizarTablaRoles();
        } else {
            JOptionPane.showMessageDialog(vistaRoles, "Llenar todos los campos.", "Roles", 2);
        }
    }

    private void tblRolesMouseClicked(MouseEvent evt) {
        try {
            int x = vistaRoles.tblRoles.getSelectedRow();

            idRol = roles.get(x).getId();
            vistaRoles.txtRol.setText(roles.get(x).getDescripcion());
            vistaRoles.cmbEstado.setSelectedItem(roles.get(x).getEstado());

            vistaRoles.btnGuardar.setEnabled(false);
            vistaRoles.btnModificar.setEnabled(idRol > 3);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaRoles, "Dar solo click izquiero.", "Advertencia", 2);
        }
    }

    private void btnNuevoAction(ActionEvent e) {
        vistaRoles.btnGuardar.setEnabled(true);
        vistaRoles.btnModificar.setEnabled(false);
        vistaRoles.txtRol.setText("");
        vistaRoles.tblRoles.setSelectionMode(0);
        vistaRoles.txtFiltro.setText("");
    }
    
    private void btnFiltrarAction(ActionEvent e) {
        String filtro = vistaRoles.txtFiltro.getText();
        roles = bl.filtrarPorRol(filtro);
        actualizarTablaRoles();
    }

}
