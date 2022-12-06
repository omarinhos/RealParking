package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.activation.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailContacto {

    private Properties props;
    private Session session;

    public MailContacto(String ruta) {
        props = new Properties();
        loadConfig(ruta);
        session = Session.getDefaultInstance(props);

    }

    private void loadConfig(String ruta) {
        try {
            InputStream is = new FileInputStream(ruta);
            this.props.load(is);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void enviarEmail(String asunto, String mensaje, String correo) {
        try {
            MimeMessage contenedor = new MimeMessage(session);
            contenedor.setFrom(new InternetAddress((String) props.get("mail.smtp.user")));
            contenedor.addRecipient(Message.RecipientType.TO, new InternetAddress((String) props.get("mail.smtp.user")));
            contenedor.setSubject(asunto);
            contenedor.setText(correo + "\n" + mensaje);
            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com", (String) props.get("mail.smtp.user"), (String) props.get("mail.smtp.password"));
            t.sendMessage(contenedor, contenedor.getAllRecipients());
            System.out.println("enviado");
        } catch (MessagingException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        MailContacto m = new MailContacto("config/config.prop");

        m.enviarEmail("Test", "Hola mundo", "omarmarinosaguilar@gmail.com");

    }

}
