package com.example.sendmailV2.service.port;

import com.example.sendmailV2.domain.MailCore;

import java.util.Properties;

public interface MailCoreFactory {
    MailCore createMailCore(String host, int port, String userNm, String userPswd, Properties properties);
}
