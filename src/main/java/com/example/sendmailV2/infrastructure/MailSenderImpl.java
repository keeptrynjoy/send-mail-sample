package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.service.port.MailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Slf4j
@RequiredArgsConstructor
public class MailSenderImpl implements MailSender{

    private final JavaMailSender javaMailSender;

    public void send(String to, String from, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(content);
        } catch (MessagingException me) {
            log.error("makeMailMsg Exception", me.fillInStackTrace());
            throw new RuntimeException(me.getMessage(), me);
        }
        javaMailSender.send(message);
    }
}
