package com.websystique.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.common.MailMail;

@Service("crunchifyEmail")
public class CrunchifyEmailAPI {
 
	@Autowired
	private MailMail crunchifymail; // MailSender interface defines a strategy
										// for sending simple mails
 
	public void crunchifyReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
 
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddress);
		crunchifyMsg.setTo(toAddress);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		crunchifymail.sendMail(crunchifyMsg);
	}
}
