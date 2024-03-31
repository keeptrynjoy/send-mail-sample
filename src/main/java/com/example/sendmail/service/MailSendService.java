package com.example.sendmail.service;


import com.example.sendmail.MailMessage;

public interface MailSendService {

    void send(MailMessage m);
}
