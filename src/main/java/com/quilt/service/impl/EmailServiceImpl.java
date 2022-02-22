package com.quilt.service.impl;
import com.quilt.dao.CustomerDao;
import com.quilt.entity.Customer;
import com.quilt.service.EmailService;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
class EmailServiceImpl implements EmailService {
    @Autowired
    private CustomerDao customerDao;
    ResourceBundle resourceBundle=ResourceBundle.getBundle("mail");
    //异常交给异常处理类执行
    @ExceptionHandler(value = {MessagingException.class,GeneralSecurityException.class})
    public int SendEmail(String content) throws MessagingException, GeneralSecurityException {
        Properties props = new Properties();
        // 开启debug调试，以便在控制台查看
        props.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = null;
        sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);
        Message msg = new MimeMessage(session);
        // 发送的邮箱地址
            msg.setFrom(new InternetAddress("228520681@qq.com"));
        // 设置标题
            msg.setSubject("您关注的博客(zhangjin)更新了发布了新内容");
        // 设置内容
        Date date=new Date();
        List<Customer> customers = customerDao.GetAllCustomers();
        Transport transport = null;
        transport = session.getTransport();
        // 设置服务器以及账号和密码
        // 这里端口改成465
        String user=resourceBundle.getString("mail.smtp.username");
        String password=resourceBundle.getString("mail.smtp.password");
        transport.connect("smtp.qq.com",465, user, password);
        Address []addresses=new Address[1];
        for(Customer customer:customers)
        {
            addresses[0]=new InternetAddress(customer.getEmail());
            msg.setContent("博客更新:hello "+customer.getName()+":) 欢迎前往http://uestcjin.top/blog "+
                    " 祝您每天生活愉快 "+date,"text/html;charset=utf-8;");
            transport.sendMessage(msg,addresses);
        }

        if (transport != null) {
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    //后台登陆报错预警
    public int SendToBlogOwner(String content)
    {
        Properties props = new Properties();
        // 开启debug调试，以便在控制台查看
        props.setProperty("mail.debug", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        // 开启SSL加密，否则会失败
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);
        Message msg = new MimeMessage(session);
        // 发送的邮箱地址
        try {
            msg.setFrom(new InternetAddress("228520681@qq.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 设置标题
        try {
            msg.setSubject(content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            msg.setContent(content, "text/html;charset=utf-8;");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        Transport transport = null;
        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        try {
            transport.connect("smtp.qq.com",465, "228520681@qq.com", "xvzdqzzyuzwgcabb");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    Address []address=new Address[2];
        try {
            address[0]=new InternetAddress("228520681@qq.com");
            address[1]=new InternetAddress("3367567794@qq.com");
        } catch (AddressException e) {
            e.printStackTrace();
        }
        try {
            transport.sendMessage(msg,address);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        if (transport != null) {
            try {
                transport.close();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}

