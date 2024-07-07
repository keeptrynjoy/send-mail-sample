package com.example.sendmailV2.service.port;

import com.example.sendmailV2.infrastructure.Mail;

import java.util.Properties;

public interface MailFactory {
    Mail createMail(String host, int port, String userNm, String userPswd, Properties properties);
}
