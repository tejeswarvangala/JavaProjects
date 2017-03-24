package com.websystique.springmvc.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mailServer.properties")
public class EmailUtility {
	@Value("${mail.username}")
	private String username;
	
	@Value("${mail.password}")
	private String password;

	@Value("${mail.smtp.auth}")
	private String smtpAuth;
	
	@Value("${mail.smtp.starttls.enable}")
	private String smtpStartTLS;
	
	@Value("${mail.smtp.host}")
	private String smtpHost;
	
	@Value("${mail.smtp.port}")
	private String smtpPort;
	
	public void sendEmail(String toAddress, String subject, String text){
		try{
		Session session = getMailSession();
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(toAddress));
		message.setSubject(subject);
		message.setText(text);

		Transport.send(message);
		
		}catch (MessagingException e) {
			System.out.println("Exception occured while Mail Sent to: "+toAddress);
			throw new RuntimeException(e);
		}
		
		System.out.println("Mail Sent to: "+toAddress);
	}
	
	public Session getMailSession(){

		Properties props = new Properties();
		props.put("mail.smtp.auth", smtpAuth);
		props.put("mail.smtp.starttls.enable", smtpStartTLS);
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.port", smtpPort);

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		return session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getSmtpStartTLS() {
		return smtpStartTLS;
	}

	public void setSmtpStartTLS(String smtpStartTLS) {
		this.smtpStartTLS = smtpStartTLS;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}
}
