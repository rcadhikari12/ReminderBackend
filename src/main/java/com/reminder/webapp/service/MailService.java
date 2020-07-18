package com.reminder.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailService
{

	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		
		this.javaMailSender = javaMailSender;
	}

	
	
	public void sendEmail(String recipent, String eventName)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("");
		mail.setTo("");
		mail.setSubject("Reminder");
		mail.setText("This is a test reminder email");
		javaMailSender.send(mail);
		
		
	}

}
