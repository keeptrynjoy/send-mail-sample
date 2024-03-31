package com.example.sendmail.service;


import com.example.sendmail.MailMessageV1;

public interface MailSendService {

    void send(MailMessageV1 m);
}
