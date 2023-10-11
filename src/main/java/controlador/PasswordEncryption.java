package controlador;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordEncryption {

    private static final String SECRET_KEY = "tu_clave_secreta";
    private static final String SALT = "tu_valor_salt";

    public static String encriptar(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey claveSecreta = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, claveSecreta);

            byte[] textoCifrado = cipher.doFinal(password.getBytes());
            return Base64.getEncoder().encodeToString(textoCifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String desencriptar(String passwordCifrada) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKey claveSecreta = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, claveSecreta);

            byte[] textoPlano = cipher.doFinal(Base64.getDecoder().decode(passwordCifrada));
            return new String(textoPlano);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
