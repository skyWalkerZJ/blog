package com.quilt.exception.enums;

import com.quilt.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.Date;

@Controller
@ControllerAdvice
public class EmailException{
    @Autowired
    EmailService emailService;
    @ExceptionHandler(value = MessagingException.class)
    public void EmailExceptionHander(Exception ex)
    {
        emailService.SendToBlogOwner("博客报错: "+ex.getMessage());
    }
    @ExceptionHandler(value = GeneralSecurityException.class)
    public void EmailExceptionHnader01(Exception ex)
    {
        emailService.SendToBlogOwner("博客报错: "+ex.getMessage()+new Date());
    }
    @ExceptionHandler
    public void DoOtherException(Exception ex)
    {
        emailService.SendToBlogOwner("博客报错: "+ex.getCause()+ex.getMessage()+"         "+new Date());
    }

}
