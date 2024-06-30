package com.example.sendmailV2.service.port;


public interface MailSender {

    void send(String to, String from, String subject, String content);
}
