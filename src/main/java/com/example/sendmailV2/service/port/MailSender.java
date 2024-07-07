package com.example.sendmailV2.service.port;


import com.example.sendmailV2.infrastructure.Mail;

public interface MailSender {

    void send(Mail mail, String to, String from, String subject, String content);
}
