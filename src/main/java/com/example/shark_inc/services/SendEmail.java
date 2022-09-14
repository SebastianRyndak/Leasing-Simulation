package com.example.shark_inc.services;

import com.example.shark_inc.models.leasing.KindOfEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(KindOfEmail kindOfEmail) {
        String mailText = "";
        String mailTitle = "";

        switch (kindOfEmail) {
            case MANUAL -> {
                mailText = "Please process the request manually";
                mailTitle = "Manual";
            }
            case POSITIVE -> {
                mailText = "The application was granted";
                mailTitle = "Positive";
            }
            case NEGATIVE -> {
                mailText = "The application has been denied";
                mailTitle = "Negative";
            }
        }
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ryndaksebastiann@gmail.com"); //Todo
        message.setTo("ryndaksebastiann@gmail.com");
        message.setText(mailText);
        message.setSubject(mailTitle);

        mailSender.send(message);
        System.out.println("Mail send...");
    }
}
