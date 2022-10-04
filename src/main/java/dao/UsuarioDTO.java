package dao;

import java.sql.Blob;

public class UsuarioDTO {

    private int id;
    private String usuario;
    private String pass;
    private String nombreCompleto;
    private String estado;
    private RolDTO rol;
    private String rutaFoto;
    private Blob imagen;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String usuario, String pass, String nombreCompleto, String estado, RolDTO rol, String rutaFoto, Blob imagen) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.rol = rol;
        this.rutaFoto = rutaFoto;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }



    

    @Override
    public String toString() {
        return id + ", "
                + usuario + ", "
                + pass + ", "
                + nombreCompleto + ", "
                + estado + ", "
                + rol + ","
                + rutaFoto;
    }

}
