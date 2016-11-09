package com.websystique.springmvc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public class MailMail
{
	
	
	private static MailSender mailSender;
	

	 @Autowired
	    public MailMail(MailSender mailSender) {
		 MailMail.mailSender = mailSender;
	    }
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public static  void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);
	}

	public static  void sendMail(SimpleMailMessage crunchifyMsg) {
		// TODO Auto-generated method stub
		mailSender.send(crunchifyMsg);
	}
}
