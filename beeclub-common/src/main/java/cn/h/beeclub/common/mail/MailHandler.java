package cn.h.beeclub.common.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class MailHandler {

//	@Autowired
	private JavaMailSender javaMailSender;

	public MailHandler(JavaMailSender javaMailSender){
	    this.javaMailSender = javaMailSender;
    }
	
	private static final String MAIL_SENDER = "1570356753@qq.com";

	public void sendSimpleMail(MailEntity email) {
		try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(MAIL_SENDER);
            //邮件接收人
            simpleMailMessage.setTo(email.getRecipient());
            //邮件主题
            simpleMailMessage.setSubject(email.getSubject());
            //邮件内容
            simpleMailMessage.setText(email.getContent());
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e.getMessage());
        }
	}
}
