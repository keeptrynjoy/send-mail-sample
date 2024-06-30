package com.example.sendmailV2.service;

import com.example.sendmailV2.service.port.MailSender;
import com.example.sendmailV2.service.port.MailSenderFactory;

import java.util.Properties;

public class FaKeMailFactory implements MailSenderFactory {
    @Override
    public MailSender createMailSender(String host, int port, String userNm, String userPswd, Properties properties) {
        return new FakeMailSender();
    }
}
