package com.example.sendmailV2.domain;

import lombok.Getter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Getter
public class MailCore extends JavaMailSenderImpl {
    
    private final JavaMailSender mailSender;
    
    public MailCore(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
}
