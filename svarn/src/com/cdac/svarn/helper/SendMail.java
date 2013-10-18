package com.cdac.svarn.helper;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static String senderEmailID = "svarnbank@gmail.com";
	final String senderPassword = "svarnBank";
	final String emailSMTPserver = "trinetra.cdacbangalore.in";
	final String emailServerPort = "25";
	String receiverEmailID = "";
	String emailSubject = null;
	String emailBody = "svarnBank";
	
	
	public SendMail(String senderEmailID,String receiverEmailID, String emailSubject, String emailBody) {
		
		this.receiverEmailID=receiverEmailID;
		this.emailSubject=emailSubject;
		this.emailBody=emailBody;
		

		Properties props = new Properties();
		props.put("mail.smtp.user",senderEmailID);
		props.put("mail.smtp.host", emailSMTPserver);
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.auth", "true");

		SecurityManager security = System.getSecurityManager();
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(receiverEmailID));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}


		/*try {
			
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(receiverEmailID));
			Transport.send(msg);
			
		} catch (Exception mex) {
			mex.printStackTrace();
		}*/


	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication(senderEmailID, senderPassword);
		}
	}

	/*public void sendMail() {

		SendMail mailSender=new SendMail("vikrammaurya@gmail.com","Test Mail from Puretechie","Wat man Wat going ther in gmail.. ");
		//SendMail mailSender=new SendMail(emailID,subject,body);
	}*/

} 
