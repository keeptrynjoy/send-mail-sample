package com.example.sendmailV2.service;

import com.example.sendmailV2.service.port.MailSender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakeMailSender implements MailSender {
    @Override
    public void send(String to, String from, String subject, String content) {
      log.info("MailSend Success~!!");
    }
}
