package com.deerwalk.service;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailDispatcher {
    public void sendEmail(String fromEmail, String username, String password, String toEmail,
                          String subject, String msg) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setContent(msg, "text/html");
            message.setSubject(subject);

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);

            transport.sendMessage(message, message.getAllRecipients());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

