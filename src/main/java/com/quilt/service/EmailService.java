package com.quilt.service;


import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

public interface EmailService {
    int SendEmail(String Content) throws MessagingException, GeneralSecurityException;

    int  SendToBlogOwner(String content);
}
