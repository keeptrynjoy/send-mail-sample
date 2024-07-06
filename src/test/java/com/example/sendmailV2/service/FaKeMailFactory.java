package com.example.sendmailV2.service;

import com.example.sendmailV2.domain.Mail;
import com.example.sendmailV2.service.port.MailFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class FaKeMailFactory implements MailFactory {
    @Override
    public Mail createMail(String host, int port, String userNm, String userPswd, Properties properties) {
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost(host);
        jms.setPort(port);
        jms.setUsername(userNm);
        jms.setPassword(userPswd);
        jms.setJavaMailProperties(properties);
        return new Mail(jms);
    }
}
