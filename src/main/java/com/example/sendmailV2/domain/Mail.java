package com.example.sendmailV2.domain;

import lombok.Getter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Getter
public class Mail extends JavaMailSenderImpl {

    private final JavaMailSender mailSender;
    
    public Mail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
