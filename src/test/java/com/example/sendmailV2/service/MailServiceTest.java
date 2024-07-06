package com.example.sendmailV2.service;

import com.example.sendmailV2.service.port.MailFactory;
import com.example.sendmailV2.service.port.MailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailServiceTest {

    private MailService mailService;

    @BeforeEach
    void init(){
        MailFactory mailFactory = new FaKeMailFactory();
        MailSender mailSender = new FakeMailSender();
        this.mailService = new MailService(mailFactory, mailSender);
    }

    @Test
    void 메일_연동_테스트(){
        //given
        //when
        mailService.testMailConnection();
        //then
    }
}
