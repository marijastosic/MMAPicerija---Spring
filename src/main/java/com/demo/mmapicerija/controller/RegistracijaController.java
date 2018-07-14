package com.demo.mmapicerija.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.mmapicerija.dao.KorisnikDAO;
import com.demo.mmapicerija.entities.Korisnik;

@Controller
public class RegistracijaController {

	@Autowired
	private KorisnikDAO korisnikDao;

	@RequestMapping(value = "/registracija", method = RequestMethod.GET)
	public String registracija(Model model) {
		Korisnik korisnik = new Korisnik();
		model.addAttribute("korisnik", korisnik);

		return "registracija";
	}

	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	public String registracijaPost(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registracija";
		}

		Korisnik postojeciKorisnikSaEmailom = korisnikDao.getKorisnikByEmail(korisnik.getEmail());
		Korisnik postojeciKorisnikSaUsername = korisnikDao.getKorisnikByUsername(korisnik.getUsername());

		if (postojeciKorisnikSaEmailom != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim email-om!");
			return "registracija";
		}

		if (postojeciKorisnikSaUsername != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim username-om!");
			return "registracija";
		}

		korisnikDao.dodajKorisnika(korisnik);

		model.addAttribute("msg", "Uspešno ste izvršili registraciju. Molimo Vas da se ulogujete:");
		model.addAttribute("username", korisnik.getUsername());
		return "login";
	}

}
