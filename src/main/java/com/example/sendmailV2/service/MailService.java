package com.example.sendmailV2.service;

import com.example.sendmailV2.service.port.MailSender;
import com.example.sendmailV2.service.port.MailSenderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderFactory mailSenderFactory;

    public void testMailConnection(){
        MailSender mailSender = mailSenderFactory.createMailSender("host", 587, "name", "pass", new Properties());
        mailSender.send("to","from","sub","con");
    }
}
