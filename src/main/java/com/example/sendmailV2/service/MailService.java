package com.example.sendmailV2.service;

import com.example.sendmailV2.infrastructure.Mail;
import com.example.sendmailV2.service.port.MailSender;
import com.example.sendmailV2.service.port.MailFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailFactory mailFactory;
    private final MailSender mailSender;

    public void testMailConnection(){
        Mail mail = mailFactory.createMail("host", 587, "name", "pass", new Properties());
        mailSender.send(mail,"to","from","sub","con");
    }
}
