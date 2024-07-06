package com.example.sendmailV2.service;

import com.example.sendmailV2.domain.MailCore;
import com.example.sendmailV2.service.port.MailCoreFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class FaKeMailCoreFactory implements MailCoreFactory {
    @Override
    public MailCore createMailCore(String host, int port, String userNm, String userPswd, Properties properties) {
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost(host);
        jms.setPort(port);
        jms.setUsername(userNm);
        jms.setPassword(userPswd);
        jms.setJavaMailProperties(properties);
        return new MailCore(jms);
    }
}
