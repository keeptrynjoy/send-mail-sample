package com.example.sendmailV2.infrastructure;

import com.example.sendmailV2.domain.Mail;
import com.example.sendmailV2.service.port.MailSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailSenderImpl implements MailSender{

    @Override
    public void send(Mail mail, String to, String from, String subject, String content) {
        MimeMessage message = mail.createMimeMessage();
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
        mail.send(message);
    }
}
