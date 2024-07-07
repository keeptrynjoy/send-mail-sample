package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.service.port.MailFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@RequiredArgsConstructor
public class MailFactoryImpl implements MailFactory {

    private final ObjectProvider<JavaMailSenderImpl> senderObjectProvider;

    public Mail createMail(String host, int port, String userNm, String userPswd, Properties properties) {
        JavaMailSenderImpl sender = senderObjectProvider.getObject();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userNm);
        sender.setPassword(userPswd);
        sender.setJavaMailProperties(properties);
        return new Mail(sender);
    }
}
