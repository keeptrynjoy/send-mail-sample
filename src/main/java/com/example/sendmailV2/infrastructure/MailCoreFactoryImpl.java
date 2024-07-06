package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.domain.MailCore;
import com.example.sendmailV2.service.port.MailCoreFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class MailCoreFactoryImpl implements MailCoreFactory {

    private static JavaMailSenderImpl sender;

    @Override
    public MailCore createMailCore(String host, int port, String userNm, String userPswd, Properties properties) {
     return create(host, port, userNm, userPswd, properties);
    }

    public static MailCore create(String host, int port, String userNm, String userPswd, Properties properties) {
        if(sender == null) {
            sender = new JavaMailSenderImpl();
        }
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userNm);
        sender.setPassword(userPswd);
        sender.setJavaMailProperties(properties);
        return new MailCore(sender);
    }
}
