package com.example.sendmailV2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MailServiceTest {

    private MailService mailService;

    @BeforeEach
    void init(){
        this.mailService = new MailService(new FaKeMailFactory());
    }

    @Test
    void 메일_연동_테스트(){
        //given
        //when
        mailService.testMailConnection();
        //then
    }
}
