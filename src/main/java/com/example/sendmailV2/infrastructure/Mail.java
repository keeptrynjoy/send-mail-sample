package com.example.sendmailV2.infrastructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;

public record Mail(JavaMailSender mailSender) {

    public MimeMessage createMimeMessage() {
        return mailSender.createMimeMessage();
    }

    public void send(MimeMessage mimeMessage) throws MessagingException {
        mailSender.send(mimeMessage);
    }
}
