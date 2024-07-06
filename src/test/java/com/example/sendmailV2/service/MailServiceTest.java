package com.example.sendmailV2.service;

import com.example.sendmailV2.service.port.MailCoreFactory;
import com.example.sendmailV2.service.port.MailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailServiceTest {

    private MailService mailService;

    @BeforeEach
    void init(){
        MailCoreFactory mailCoreFactory = new FaKeMailCoreFactory();
        MailSender mailSender = new FakeMailSender();
        this.mailService = new MailService(mailCoreFactory, mailSender);
    }

    @Test
    void 메일_연동_테스트(){
        //given
        //when
        mailService.testMailConnection();
        //then
    }
}
