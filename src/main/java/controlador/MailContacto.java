package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailContacto {

    private final Properties props;
    private final Session session;

    public MailContacto(String ruta) {
        this.props = new Properties();
        loadConfig(ruta);
        session = Session.getDefaultInstance(props);

    }

    private void loadConfig(String ruta) {
        try (InputStream is = new FileInputStream(ruta)) {
            this.props.load(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void enviarEmail(String asunto, String mensaje, String correo) {
        try {
            MimeMessage contenedor = new MimeMessage(session);
            contenedor.setFrom(new InternetAddress((String) props.get("mail.smtp.user")));
            contenedor.addRecipient(Message.RecipientType.TO, new InternetAddress((String) props.get("mail.smtp.user")));
            contenedor.setSubject(asunto);
            contenedor.setText(correo + "\n\n" + mensaje);
            
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) props.get("mail.smtp.user"), (String) props.get("mail.smtp.password"));
            t.sendMessage(contenedor, contenedor.getAllRecipients());
            System.out.println("enviado");
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
        }
    }
}
