package modelo;

import java.sql.Blob;

public class Usuario {

    private int id;
    private String usuario;
    private String pass;
    private String nombreCompleto;
    private String estado;
    private Rol rol;
    private String rutaFoto;
    private Blob imagen;

    public Usuario() {
    }

    public Usuario(int id, String usuario, String pass, String nombreCompleto, String estado, Rol rol, String rutaFoto, Blob imagen) {
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
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
    
}