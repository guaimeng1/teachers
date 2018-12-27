package com.tt.teachers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendEmailPlus(String email, String title, String context, MultipartFile file) throws MessagingException {
        //创建一封信
        MimeMessage mimeMailMessage=javaMailSender.createMimeMessage();
        //找个信封，把信放到里面
        MimeMessageHelper helper=new MimeMessageHelper(mimeMailMessage,true);
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setText(context);
        String fileName=file.getOriginalFilename();
        helper.addAttachment(fileName,file);
        javaMailSender.send(mimeMailMessage);
    }
}
