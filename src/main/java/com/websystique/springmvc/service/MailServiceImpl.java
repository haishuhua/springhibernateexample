package com.websystique.springmvc.service;


import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
 
 
@Service("mailService")
public class MailServiceImpl implements MailService {
 
    @Autowired
    JavaMailSender mailSender;
 
    public void sendEmail(Object object) {
 
 
       MimeMessagePreparator preparator = getMessagePreparator("Test");
 
        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    private MimeMessagePreparator getMessagePreparator(final String string) {
 
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
 
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(string));
                mimeMessage.setText("Dear " + "name"
                        + ", thank you for placing order. Your order id is " + 1231231 + ".");
                mimeMessage.setSubject("Your order on Demoapp");
            }
        };
        return preparator;
    }

	
}
