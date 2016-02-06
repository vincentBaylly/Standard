/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.standard.bestpratice.jms;

// File Name SendEmail.java
import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax
//import javax.mail.internet.*;

public class EmailSender {

    public void sendEmail(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "vincent.baylly@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "vincent.baylly@gmail.com";

//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class",
//                "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", "465");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("vincent.baylly", "P@ss_23RDAg.1305Gm!");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Anniversaire Clotilde");

//            // Send the actual HTML message, as big as you like
//            message.setContent("<html>\n"
//                    + "  <head>\n"
//                    + "    <link href=\"http://fonts.googleapis.com/css?family=Lobster+Two\" rel=\"stylesheet\" type=\"text/css\">\n"
//                    + "    <style>\n"
//                    + "      body {\n"
//                    + "        background-image: URL(\"http://www.clarionwines.co.uk/images/champagne.jpg\");\n"
//                    + "        #background-size: 100% 100%;\n"
//                    + "        #background-repeat:no-repeat;\n"
//                    + "      }\n"
//                    + "      h2 {\n"
//                    + "        font: 400 50px/1.3 'Lobster Two', Helvetica, sans-serif;\n"
//                    + "        #color: #236B8E;\n"
//                    + "        text-shadow: 1px 1px 0px #ededed, 4px 4px 0px rgba(0,0,0,0.15);\n"
//                    + "        font-weight : bold;\n"
//                    + "        text-align : center;\n"
//                    + "        background: -webkit-linear-gradient(#eee, #026); \n"
//                    + "                    -webkit-background-clip: text; \n"
//                    + "                    -webkit-text-fill-color: transparent;\n"
//                    + "      }\n"
//                    + "    </style>\n"
//                    + "  </head>\n"
//                    + "  <body>\n"
//                    + "      <h2>A L'occasion de mes 60 ans, je voudrais marquer cette date !</h2>\n"
//                    + "      <h2>je vous invite &agrave; venir f&ecirc;ter</h2>\n"
//                    + "      <h2>cet &eacute;v&eacute;nement autour d'un repas</h2>\n"
//                    + "      <h2>Au St Jean - Sentier Godine, 18200 Drevant</h2>\n"
//                    + "      <h2>le 17 Juillet 2015 &agrave 11h30</h2>\n"
//                    + "  </body>\n"
//                    + "</html>",
//                    "text/html");
           message.setContent(" <table style=\"background-image: URL(http://www.clarionwines.co.uk/images/champagne.jpg); background-size: 100% 100%;\">\n"
 + "<tr>\n"
 + "<td>\n"
       + "<h2 style=\"font-family: 'Lobster Two';\n"
   + "font-style: normal;\n"
   + "font-weight: 400;\n"
   + "src: local('Lobster Two'), local('LobsterTwo'), url(http://fonts.gstatic.com/s/lobstertwo/v7/Law3VVulBOoxyKPkrNsAaI4P5ICox8Kq3LLUNMylGO4.woff2) format('woff2');\n"
   + "unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2212, U+2215, U+E0FF, U+EFFD, U+F000;\">A L'occasion de mes 60 ans, je voudrais marquer cette date !<br>\n"
     + "  je vous invite &agrave; venir f&ecirc;ter<br>\n"
      + " cet &eacute;v&eacute;nement autour d'un repas<br>\n"
      + " Au St Jean - Sentier Godine, 18200 Drevant<br>\n"
      + " le 17 Juillet 2015 &agrave 11h30</h2>\n"
 + "<td>\n"
 + "</tr>\n"
 + "</table>", "text/html");
//
//            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
