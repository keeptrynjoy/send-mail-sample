package com.example.sendmail.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConfigurationV1 {
    private static final String MAIL_SMTP_HOST = "mail.smtp.host";
    private static final String MAIL_SMTP_PORT = "mail.smtp.port";
    private static final String MAIL_SMTP_SSL_TRUST = "mail.smtp.ssl.trust";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    private static final String MAIL_SMTP_STARTTLS_REQUIRED = "mail.smtp.starttls.required";
    private static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    private static final String MAIL_SMTP_SSL_PROTOCOLS = "mail.smtp.ssl.protocols";


    @Getter
    @Setter
    public static class Smtp{
        private boolean auth;
        private boolean startTlsEnable;
        private boolean startTlsRequired;
        private String sslProtocols;
    }

    private String username;
    private String password;
    private int port;
    private String host;
    private String protocol;
    private String defaultEncoding;
    private Smtp smtp;

    @Bean
    public Session sendMailConfig(){
        Session session = null;
        Properties prop = new Properties();
        prop.put(MAIL_SMTP_HOST, host);
        prop.put(MAIL_SMTP_PORT, port);
        prop.put(MAIL_TRANSPORT_PROTOCOL, protocol);
        prop.put(MAIL_SMTP_AUTH, getSmtp().isAuth()); // SMTP 서버에서 인증을 필요로할 경우
//        prop.put("mail.smtp.ssl.enable", "true"); // SMTP 서버에서 SSL(smtps)이 보안 정책일 경우
        prop.put(MAIL_SMTP_SSL_TRUST, host); // SMTP 보안 접근시 신뢰할 수 있는 호스트로 지정
        prop.put(MAIL_SMTP_SSL_PROTOCOLS, getSmtp().sslProtocols);
        prop.put(MAIL_SMTP_STARTTLS_ENABLE, getSmtp().isStartTlsEnable()); // STARTTLS를 사용하여 TLS 보안 연결을 활성화할 것인지를 지정
        prop.put(MAIL_SMTP_STARTTLS_REQUIRED, getSmtp().isStartTlsRequired()); // //  STARTTLS를 사용한 TLS 보안 연결이 필수적으로 요구되는지를 지정

        session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }
}
