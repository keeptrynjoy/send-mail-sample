package com.example.sendmailV2.service;

import com.example.sendmailV2.domain.MailCore;
import com.example.sendmailV2.service.port.MailSender;
import com.example.sendmailV2.service.port.MailCoreFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {
    private final MailCoreFactory mailCoreFactory;
    private final MailSender mailSender;

    public void testMailConnection(){
        MailCore mailCore = mailCoreFactory.createMailCore("host", 587, "name", "pass", new Properties());
        mailSender.send(mailCore,"to","from","sub","con");
    }
}
