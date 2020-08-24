package com.sathish.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sathish.model.Account;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public EmailUtils(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public boolean sendAccountUnlockMail(Account account) throws MessagingException, IOException {
		boolean isSent = false;
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setTo(account.getEmail());
		helper.setSubject("UNLOCK YOUR ACCOUNT");
		helper.setText(getUnlockAccEmailBody(account), true);

		mailSender.send(mimeMessage);
		isSent = true;
		return isSent;

	}

	private String getUnlockAccEmailBody(Account account) throws IOException {

		StringBuffer sb = new StringBuffer();
		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();

		}
		br.close();

		String mailbody = sb.toString();
		mailbody = mailbody.replace("{FNAME}", account.getFirstName());
		mailbody = mailbody.replace("{LNAME}", account.getLastName());
		mailbody = mailbody.replace("{TEMP-PWD}", account.getPwd());
		mailbody = mailbody.replace("{EMAIL}", account.getEmail());
		return mailbody;
	}

}
