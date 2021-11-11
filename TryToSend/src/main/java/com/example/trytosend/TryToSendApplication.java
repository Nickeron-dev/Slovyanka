package com.example.trytosend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TryToSendApplication {

    @Autowired
    private SendService sendService;

    public static void main(String[] args) {
        SpringApplication.run(TryToSendApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
        sendService.sendEmail("koshkin061969@gmail.com", "Subject", "some text for body");
    }

}
