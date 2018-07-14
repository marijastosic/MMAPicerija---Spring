package com.demo.mmapicerija.service.impl;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void posaljiMailZaRegistraciju(Korisnik korisnik) {
		SimpleMailMessage message = new SimpleMailMessage();
				
		message.setTo(korisnik.getEmail());
		message.setSubject("MMA picerija - uspešna registracija!");
		message.setBcc("mmapicerija@gmail.com");
		String postovani = korisnik.getPol().equals("Muški") ? "Poštovani " : korisnik.getPol().equals("Ženski") ? "Poštovana " : "Poštovani/a ";
		message.setText(postovani + korisnik.getIme() + ",\n\nUspešno ste izvršili registraciju! Vaše korisničko ime je: " + korisnik.getUsername() + ".\n\nHvala što koristite naš sistem!");

		mailSender.send(message);
		
		
	}

}
