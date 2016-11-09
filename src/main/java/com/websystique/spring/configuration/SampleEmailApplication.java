package com.websystique.spring.configuration;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.websystique.springmvc.configuration.AppConfig;
import com.websystique.springmvc.service.MailService;
 
public class SampleEmailApplication {
 
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
 
        MailService orderService = (MailService) context.getBean("mailService");
        Integer temp = new Integer(2);
        orderService.sendEmail(temp);
        ((AbstractApplicationContext) context).close();
    }
     
   
 
}