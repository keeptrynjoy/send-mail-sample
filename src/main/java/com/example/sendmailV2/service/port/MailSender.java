package com.example.sendmailV2.service.port;


import com.example.sendmailV2.domain.MailCore;

public interface MailSender {

    void send(MailCore mailCore, String to, String from, String subject, String content);
}
