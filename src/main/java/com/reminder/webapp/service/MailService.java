package com.reminder.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailService
{
	

	private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		
		this.javaMailSender = javaMailSender;
	}

	
	
	public void sendEmail(String recipent, String eventName)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(sender);
		mail.setTo(recipent);
		mail.setSubject("Reminder");
		mail.setText(eventName);
		javaMailSender.send(mail);
		
		
	}

}
