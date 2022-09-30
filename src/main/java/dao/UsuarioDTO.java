
package dao;




public class UsuarioDTO {

 
    private int id;
    private String usuario;
    private String pass;
    private String nombreCompleto;
    private String estado;
    private RolDTO rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String usuario, String pass, String nombreCompleto, String estado, RolDTO rol) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.nombreCompleto = nombreCompleto;
        this.estado = estado;
        this.rol = rol;
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

    @Override
    public String toString() {
        return  id + ", " +
                usuario + ", " +
                pass + ", " +
                nombreCompleto + ", " +
                estado + ", " +
                rol;
    }
    
}
