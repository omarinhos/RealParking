package dao;

import controlador.PasswordEncryption;
import org.junit.Test;

public class MainTest {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Test
    public void test() {
        usuarioDAO.cambiarPassword("71397835", PasswordEncryption.encriptar("123"));
        String pass = "12345";
        String passEncript = PasswordEncryption.encriptar(pass);
        System.out.println(passEncript);
        System.out.println(PasswordEncryption.desencriptar(passEncript));
    }

}
