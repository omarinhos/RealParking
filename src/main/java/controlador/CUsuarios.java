package controlador;

import dao.BusinessLogic;
import dao.RolDTO;
import dao.UsuarioDTO;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import vista.FrmPrincipal;
import vista.VistaUsuarios;

public class CUsuarios {

    public final VistaUsuarios vistaUsuarios = new VistaUsuarios();
    private final BusinessLogic bl = new BusinessLogic();
    private final DefaultTableModel modeloUsuarios = new DefaultTableModel();
    private List<UsuarioDTO> usuarios = new ArrayList<>();
    private List<RolDTO> roles = new ArrayList<>();
    
    private int idUsuario;
    private String rutaImagen = null;

    public CUsuarios(FrmPrincipal FrmP) {

        vistaUsuarios.setSize(740, 630);
        FrmP.contenedor.removeAll();
        FrmP.contenedor.add(vistaUsuarios, BorderLayout.CENTER);
        FrmP.contenedor.revalidate();
        FrmP.contenedor.repaint();

        String cabecera[] = {"Id", "DNI", "Nombre", "Cargo", "Estado"};
        modeloUsuarios.setColumnIdentifiers(cabecera);
        vistaUsuarios.tblUsuarios.setModel(modeloUsuarios);

        actualizarComboRoles();
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();

        vistaUsuarios.btnGuardar.addActionListener(e -> {
            btnGuardarAction(e);
        });

        vistaUsuarios.btnModificar.addActionListener(e -> {
            btnModificarAction(e);
        });
        vistaUsuarios.tblUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tblUsuariosMouseClicked(e);
            }
        });

        vistaUsuarios.btnNuevo.addActionListener(e -> {
            btnNuevoAction(e);
        });

        vistaUsuarios.btnGuardarFotos.addActionListener(e -> {
            btnGuardarFotosAction(e);
        });
        
        vistaUsuarios.btnFiltrar.addActionListener(e -> {
            btnFiltrarAction(e);
        });

    }

    private void actualizarComboRoles() {
        vistaUsuarios.cmbCargo.removeAllItems();
        roles = bl.getListaRol();
        roles.forEach(rol -> vistaUsuarios.cmbCargo.addItem(rol.getDescripcion()));
    }

    private void actualizarTablaUsuarios() {
        modeloUsuarios.setRowCount(0);

        usuarios.forEach(usuario -> {
            modeloUsuarios.addRow(new Object[]{
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getNombreCompleto(),
                usuario.getRol().getDescripcion(),
                usuario.getEstado()
            });
        });
    }

    private boolean btnGuardarAction(ActionEvent e) {
        String DNI = vistaUsuarios.txtDni.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String pass = String.valueOf(vistaUsuarios.txtPass.getPassword());
        String passre = String.valueOf(vistaUsuarios.txtPassRe.getPassword());

        if (DNI.isEmpty() || nombre.isEmpty() || pass.isEmpty() || passre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Llenar todos los campos.", "Usuario", 2);
            return false;
        }

        if (!pass.equals(passre)) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Las contraseñas no coinciden.", "Usuario", 2);
            return false;
        }

        UsuarioDTO user = new UsuarioDTO();
        user.setUsuario(DNI);
        user.setPass(pass);
        user.setNombreCompleto(nombre);
        user.setEstado((String) vistaUsuarios.cmbEstado.getSelectedItem());
        user.setRutaFoto(rutaImagen);
        RolDTO rol = new RolDTO();
        rol.setId(vistaUsuarios.cmbCargo.getSelectedIndex() + 1);
        user.setRol(rol);
        bl.crearUsuario(user);
        JOptionPane.showMessageDialog(vistaUsuarios, "Usuario Agregado.", "Usuario", 1);
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();
        rutaImagen = null;

        return true;
    }

    private boolean btnModificarAction(ActionEvent e) {
        String DNI = vistaUsuarios.txtDni.getText();
        String nombre = vistaUsuarios.txtNombre.getText();
        String pass = String.valueOf(vistaUsuarios.txtPass.getPassword());
        String passre = String.valueOf(vistaUsuarios.txtPassRe.getPassword());

        if (DNI.isEmpty() || nombre.isEmpty() || pass.isEmpty() || passre.isEmpty()) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Llenar todos los campos.", "Usuario", 2);
            return false;
        }

        if (!pass.equals(passre)) {
            JOptionPane.showMessageDialog(vistaUsuarios, "Las contraseñas no coinciden.", "Usuario", 2);
            return false;
        }

        UsuarioDTO user = new UsuarioDTO();
        user.setId(idUsuario);
        user.setUsuario(DNI);
        user.setPass(pass);
        user.setNombreCompleto(nombre);
        user.setEstado((String) vistaUsuarios.cmbEstado.getSelectedItem());
        RolDTO rol = new RolDTO();
        rol.setId(vistaUsuarios.cmbCargo.getSelectedIndex() + 1);
        user.setRol(rol);

        bl.actualizarUsuario(user);
        JOptionPane.showMessageDialog(vistaUsuarios, "Usuario Mdificado", "Usuario", 1);
        usuarios = bl.getListaUsuario();
        actualizarTablaUsuarios();

        return true;
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
            if (usuarios.get(x).getImagen() != null) {
                cargarImagen(usuarios.get(x).getImagen());
            } else {
                vistaUsuarios.jlbfotoUsuario.setIcon(new ImageIcon("src/main/java/images/user.png"));
            }

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
        vistaUsuarios.jlbfotoUsuario.setIcon(null);
        vistaUsuarios.txtFiltro.setText("");
    }
    
    private void btnFiltrarAction(ActionEvent e) {
        String filtro = vistaUsuarios.txtFiltro.getText();
        usuarios = bl.filtrarPorUsuario(filtro);
        actualizarTablaUsuarios();
    }

    private void btnGuardarFotosAction(ActionEvent e) {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
                "Formatos de Archivos JPEG(*.JPG;*.JPEG)", "jpg", "jpeg", "png"
        );
        JFileChooser se = new JFileChooser();
        se.addChoosableFileFilter(filtro);
        se.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = se.showOpenDialog(null);

        if (estado == JFileChooser.APPROVE_OPTION) {
            try {

                rutaImagen = se.getSelectedFile().getAbsolutePath();
                Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(vistaUsuarios.jlbfotoUsuario.getWidth(), vistaUsuarios.jlbfotoUsuario.getHeight(), Image.SCALE_DEFAULT);
                vistaUsuarios.jlbfotoUsuario.setIcon(new ImageIcon(icono));
                vistaUsuarios.jlbfotoUsuario.updateUI();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void cargarImagen(Blob blob) {

        BufferedImage img = null;
        try {
            //pasar el binario a imagen
            byte[] data = blob.getBytes(1, (int) blob.length());
            //lee la imagen
            img = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon icono = new ImageIcon(img);
        Icon imagen = new ImageIcon(icono.getImage().getScaledInstance(vistaUsuarios.jlbfotoUsuario.getWidth(), vistaUsuarios.jlbfotoUsuario.getHeight(), Image.SCALE_DEFAULT));
        vistaUsuarios.jlbfotoUsuario.setIcon(imagen);
    }

}
