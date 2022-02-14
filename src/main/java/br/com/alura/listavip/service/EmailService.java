package br.com.alura.listavip.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private static String emailfrom = "email@gmail.com";
    private static String password = "myPassToLogin";

    public void enviar(String nome, String emailDestinatario) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator(emailfrom, password));
            email.setDebug(true);
            email.setSSLOnConnect(true);
            email.setCharset("UTF-8");

            email.setFrom(emailfrom);
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá ".concat(nome).concat(". Você acaba de ser convidado pelo ListaVIP."));
            email.addTo(emailDestinatario);
            email.send();
        } catch (EmailException ex) {
            ex.printStackTrace();
        }
    }

}
