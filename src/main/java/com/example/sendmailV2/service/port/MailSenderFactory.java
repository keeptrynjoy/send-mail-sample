package com.example.sendmailV2.service.port;

import java.util.Properties;

public interface MailSenderFactory {
    MailSender createMailSender(String host, int port, String userNm, String userPswd, Properties properties);
}
