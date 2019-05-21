package com.chen.service.impl;

import com.chen.entity.User;
import com.chen.service.ISendMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class SendMailServiceImpl implements ISendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    private static final Logger LOGGER = LoggerFactory.getLogger(SendMailServiceImpl.class);

    @Override
    public boolean sendMail(List<User> users) {
        try {
            if (users == null || users.size() <= 0) {
                return Boolean.FALSE;
            }
            for (User user : users) {
                MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMailMessage);
                //邮件发送方
                messageHelper.setFrom(from);
                //邮件主题
                messageHelper.setSubject("这是一个测试");
                messageHelper.setTo("827702877@qq.com");
                messageHelper.setText(user.getName() + ",你好，测试邮件，不用回复。");
                javaMailSender.send(mimeMailMessage);

            }

        } catch (Exception e) {
            LOGGER.error("发送邮件出错。。。，用户：%s", users, e);
            return Boolean.FALSE;
        }
        return true;
    }
}
