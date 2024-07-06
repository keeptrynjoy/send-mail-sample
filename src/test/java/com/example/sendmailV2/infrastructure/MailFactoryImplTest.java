package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.config.MailConfig;
import com.example.sendmailV2.domain.Mail;
import com.example.sendmailV2.service.port.MailFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {MailFactoryImpl.class, MailConfig.class})
@ComponentScan(basePackages = "com.example.sendmailV2")
public class MailFactoryImplTest {

    @MockBean
    private JavaMailSenderImpl javaMailSender;

    @Autowired
    private MailFactory mailFactory;

    @Test
    public void testCreateMail() {
        String host = "smtp.example.com";
        int port = 587;
        String userNm = "user@example.com";
        String userPswd = "password";
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");

        given(javaMailSender.getHost()).willReturn(host);
        given(javaMailSender.getPort()).willReturn(port);
        given(javaMailSender.getUsername()).willReturn(userNm);
        given(javaMailSender.getPassword()).willReturn(userPswd);
        given(javaMailSender.getJavaMailProperties()).willReturn(properties);

        Mail mail = mailFactory.createMail(
                host,
                port,
                userNm,
                userPswd,
                properties
        );

        assertAll(()->{
            assertThat(mail).isNotNull();
            assertThat(mail.getMailSender()).isEqualTo(javaMailSender);

            verify(javaMailSender, times(1)).setHost(host);
            verify(javaMailSender, times(1)).setPort(port);
            verify(javaMailSender, times(1)).setUsername(userNm);
            verify(javaMailSender, times(1)).setPassword(userPswd);
            verify(javaMailSender, times(1)).setJavaMailProperties(properties);
        });

    }
}