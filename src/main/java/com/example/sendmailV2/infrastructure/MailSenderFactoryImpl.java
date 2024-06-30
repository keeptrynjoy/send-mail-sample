package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.service.port.MailSender;
import com.example.sendmailV2.service.port.MailSenderFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailSenderFactoryImpl implements MailSenderFactory {

    @Override
    public MailSender createMailSender(String host, int port, String userNm, String userPswd, Properties properties) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userNm);
        sender.setPassword(userPswd);
        sender.setJavaMailProperties(properties);
        return new MailSenderImpl(sender);
    }
}
