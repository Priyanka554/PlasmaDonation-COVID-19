package com.plasmadonation.dao;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/*
 * Mail Sending configurations
 */

public class MailSendingConfigurations {

	/*
	 * Configuring all mail properties. Configuring message Sendig email
	 */

	public static int sendEmail(String host, String port, final String userName, final String password, String toMails,
			String subject, String message) throws AddressException, MessagingException, IOException {

		int count = 0;
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = InternetAddress.parse(toMails, true);
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(message, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);
		// MimeBodyPart image = new MimeBodyPart();
		// image.attachFile(new
		// File("F:\\Freelancer\\PlasmaDonation-Covid19\\WebContent\\img\\UCM.png"));
		// multipart.addBodyPart(image);
		msg.setContent(multipart);
		// sends the e-mail
		Transport.send(msg);
		count++;

		return count;

	}

}
