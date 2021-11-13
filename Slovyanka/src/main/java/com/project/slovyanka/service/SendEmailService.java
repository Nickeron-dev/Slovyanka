package com.project.slovyanka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author Illia Koshkin
 * Цей клас - сервіс відправки повідомлень на пошту.
 */
@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("spring.mail.username")
    String sendFromMail;

    /**
     * Цей метод відправляє повідомлення на передану пошту
     * @param target пошта отримувача
     * @param subject тема повідомлення
     * @param body основний текст повідомлення
     */
    public void sendEmail(String target, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();

        System.out.println(sendFromMail);
        message.setFrom(sendFromMail);
        message.setTo(target);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail has been sent.");
    }
}
