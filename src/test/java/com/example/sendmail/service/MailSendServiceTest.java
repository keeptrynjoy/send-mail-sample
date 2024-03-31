package com.example.sendmail.service;

import com.example.sendmail.MailMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
class MailSendServiceTest {

    @Autowired
    private MailSendService mailSendService;

    @Test
    void send() {
        MailMessage message = MailMessage.builder()
                .from("sungmin4218@gmail.com")
                .to("sm.kim2@okestro.com")
                .subject("[TEST] mail")
                .content("test").build();
        mailSendService.send(message);
    }
}