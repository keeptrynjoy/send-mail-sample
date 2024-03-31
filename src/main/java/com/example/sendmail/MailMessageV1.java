package com.example.sendmail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailMessageV1 {
    private String from;
    private String to;
    private String subject;
    private String content;
}
