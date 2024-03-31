package com.example.sendmail.service.impl;

import com.example.sendmail.MailMessage;
import com.example.sendmail.config.MailConfigurationV1;
import com.example.sendmail.service.MailSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailSendImplV1Service implements MailSendService {

    private final MailConfigurationV1 mailConfigurationV1;

    @Override
    public void send(MailMessage mailMessage) {
        final String type = "text/html; charset=utf-8";

        MimeMessage mimeMessage = new MimeMessage(mailConfigurationV1.sendMailConfig());
        try {
            mimeMessage.setFrom(new InternetAddress(mailMessage.getFrom()));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailMessage.getTo()));
            mimeMessage.setSubject(mailMessage.getSubject());
            mimeMessage.setContent(mailMessage.getContent(), type);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        try {
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
