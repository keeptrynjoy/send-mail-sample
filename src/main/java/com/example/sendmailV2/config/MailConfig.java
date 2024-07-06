package com.example.sendmailV2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean
    @Scope("prototype")
    public JavaMailSenderImpl javaMailSender() {
        return new JavaMailSenderImpl();
    }
}
