package controlador;

import dao.BusinessLogic;
import modelo.Usuario;
import modelo.Rol;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.FrmPrincipal;
import vista.VistaUsuarios;

public class CUsuarios {

    public final VistaUsuarios vistaUsuarios = new VistaUsuarios();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloUsuarios = new DefaultTableModel();
    private List<Usuario> usuarios;
    
    private int idUsuario;

    public CUsuarios(FrmPrincipal FrmP) {

        vistaUsuarios.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaUsuarios, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        String[] cabecera = {"Id", "DNI", "Nombre", "Cargo", "Estado"};
        modeloUsuarios.setColumnIdentifiers(cabecera);
        vistaUsuarios.tblUsuarios.setModel(modeloUsuarios);

        actualizarComboRoles();
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();

        vistaUsuarios.btnGuardar.addActionListener(this::btnGuardarAction);

        vistaUsuarios.btnModificar.addActionListener(this::btnModificarAction);
        
        vistaUsuarios.tblUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblUsuariosMouseClicked(e);
            }
        });

        vistaUsuarios.btnNuevo.addActionListener(this::btnNuevoAction);

        vistaUsuarios.btnFiltrar.addActionListener(this::btnFiltrarAction);

    }

    private void actualizarComboRoles() {
        vistaUsuarios.cmbCargo.removeAllItems();
        List<Rol> roles = bl.getListaRol();
        roles.forEach(rol -> vistaUsuarios.cmbCargo.addItem(rol.getDescripcion()));
    }

    private void actualizarTablaUsuarios() {
        modeloUsuarios.setRowCount(0);

        usuarios.forEach(usuario -> modeloUsuarios.addRow(new Object[]{
            usuario.getId(),
            usuario.getUsuario(),
            usuario.getNombreCompleto(),
            usuario.getRol().getDescripcion(),
            usuario.getEstado()
        }));
    }

    private void btnGuardarAction(ActionEvent e) {
        String DNI = vistaUsuarios.txtDni.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String pass = String.valueOf(vistaUsuarios.txtPass.getPassword());
        String passre = String.valueOf(vistaUsuarios.txtPassRe.getPassword());

        if (DNI.isEmpty() || nombre.isEmpty() || pass.isEmpty() || passre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Llenar todos los campos.", "Usuario", 2);
            return;
        }

        if (!pass.equals(passre)) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Las contraseñas no coinciden.", "Usuario", 2);
            return;
        }

        Usuario user = new Usuario();
        user.setUsuario(DNI);
        user.setPass(pass);
        user.setNombreCompleto(nombre);
        user.setEstado((String) vistaUsuarios.cmbEstado.getSelectedItem());
        Rol rol = new Rol();
        rol.setId(vistaUsuarios.cmbCargo.getSelectedIndex() + 1);
        user.setRol(rol);
        bl.crearUsuario(user);
        JOptionPane.showMessageDialog(vistaUsuarios, "Usuario Agregado.", "Usuario", 1);
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();

    }

    private void btnModificarAction(ActionEvent e) {
        String DNI = vistaUsuarios.txtDni.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String pass = String.valueOf(vistaUsuarios.txtPass.getPassword());
        String passre = String.valueOf(vistaUsuarios.txtPassRe.getPassword());

        if (DNI.isEmpty() || nombre.isEmpty() || pass.isEmpty() || passre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Llenar todos los campos.", "Usuario", 2);
            return;
        }

        if (!pass.equals(passre)) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Las contraseñas no coinciden.", "Usuario", 2);
            return;
        }

        Usuario user = new Usuario();
        user.setId(idUsuario);
        user.setUsuario(DNI);
        user.setPass(pass);
        user.setNombreCompleto(nombre);
        user.setEstado((String) vistaUsuarios.cmbEstado.getSelectedItem());
        Rol rol = new Rol();
        rol.setId(vistaUsuarios.cmbCargo.getSelectedIndex() + 1);
        user.setRol(rol);

        bl.actualizarUsuario(user);
        JOptionPane.showMessageDialog(vistaUsuarios, "Usuario Mdificado", "Usuario", 1);
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();
    }

    private void tblUsuariosMouseClicked(MouseEvent evt) {
        try {
            int x = vistaUsuarios.tblUsuarios.getSelectedRow();

            idUsuario = usuarios.get(x).getId();
            vistaUsuarios.txtDni.setText(usuarios.get(x).getUsuario());
            vistaUsuarios.txtPass.setText(usuarios.get(x).getPass());
            vistaUsuarios.txtPassRe.setText(usuarios.get(x).getPass());
            vistaUsuarios.txtNombre.setText(usuarios.get(x).getNombreCompleto());
            vistaUsuarios.cmbCargo.setSelectedItem(usuarios.get(x).getRol().getDescripcion());
            vistaUsuarios.cmbEstado.setSelectedItem(usuarios.get(x).getEstado());
            vistaUsuarios.btnGuardar.setEnabled(false);
            vistaUsuarios.btnModificar.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Dar solo click izquiero.", "Advertencia", 2);
        }
    }

    private void btnNuevoAction(ActionEvent e) {
        vistaUsuarios.btnGuardar.setEnabled(true);
        vistaUsuarios.btnModificar.setEnabled(false);
        vistaUsuarios.tblUsuarios.setSelectionMode(0);
        vistaUsuarios.txtDni.setText("");
        vistaUsuarios.txtNombre.setText("");
        vistaUsuarios.txtPass.setText("");
        vistaUsuarios.txtPassRe.setText("");
        vistaUsuarios.txtFiltro.setText("");
    }
    
    private void btnFiltrarAction(ActionEvent e) {
        String filtro = vistaUsuarios.txtFiltro.getText();
        usuarios = bl.filtrarPorUsuario(filtro);
        actualizarTablaUsuarios();
    }

}
