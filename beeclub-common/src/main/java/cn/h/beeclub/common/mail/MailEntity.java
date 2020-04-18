package cn.h.beeclub.common.mail;

import java.io.Serializable;

import lombok.Data;

@Data
public class MailEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8977370479129606967L;
	private String recipient;   //邮件接收人
    private String subject; //邮件主题
    private String content; //邮件内容
}
