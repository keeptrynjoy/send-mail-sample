package com.example.sendmail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailMessage {
    private String from;
    private String to;
    private String subject;
    private String content;
}
