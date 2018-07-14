package com.demo.mmapicerija.controller;

import javax.servlet.http.HttpServletRequest;
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
public class ProfilController {

	@Autowired
	private KorisnikDAO korisnikDao;

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profil(Model model, HttpServletRequest request) {
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		model.addAttribute("korisnik", korisnik);

		return "profil";
	}

	@RequestMapping(value = "/azurirajProfil", method = RequestMethod.POST)
	public String azurirajProfil(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "profil";
		}

		korisnikDao.azurirajKorisnika(korisnik);

		model.addAttribute("msg", "Uspešno ste ažurirali profil.");
		return "profil";
	}

}
