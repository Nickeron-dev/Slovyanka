package com.example.trytosend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String target, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("illianickeron@gmail.com");
        message.setTo(target);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail has been sent.");
    }
}
