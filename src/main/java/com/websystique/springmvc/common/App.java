package com.websystique.springmvc.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.websystique.springmvc.configuration.MailConfig;
import com.websystique.springmvc.service.CrunchifyEmailAPI;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { MailConfig.class})
public class App
{
	@Autowired
	CrunchifyEmailAPI crunchifyEmailAPI; 
    public static void main( String[] args )
    {

    	String toAddr = "test@crunchify.com";
		String fromAddr = "test@crunchify.com";
 
		// email subject
		String subject = "Hey.. This email sent by Crunchify's Spring MVC Tutorial";
 
		// email body
		String body = "There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
		//crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);


    }
}
