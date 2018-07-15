package com.demo.mmapicerija.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.demo.mmapicerija.dao.PorudzbinaDAO;
import com.demo.mmapicerija.dao.StavkaKorpeDAO;
import com.demo.mmapicerija.dao.StavkaPorudzbineDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.Porudzbina;
import com.demo.mmapicerija.entities.StavkaKorpe;
import com.demo.mmapicerija.entities.StavkaPorudzbine;

@Controller
public class PorudzbinaController {

	@Autowired
	private KorisnikDAO korisnikDao;

	@Autowired
	private StavkaKorpeDAO stavkaKorpeDao;

	@Autowired
	private PorudzbinaDAO porudzbinaDao;

	@Autowired
	private StavkaPorudzbineDAO stavkaPorudzbineDao;

	@RequestMapping(value = "/proveraPodataka", method = RequestMethod.GET)
	public String proveraPodataka(Model model, HttpServletRequest request) {
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		model.addAttribute("korisnik", korisnik);
		return "proveraPodataka";
	}
	
	@RequestMapping(value = "/racun", method = RequestMethod.POST)
	public String racun(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result, Model model,
			HttpServletRequest request) {
		double ukupanIznos = 0.0;

		Korisnik korisnikIzBaze = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		for (StavkaKorpe sk : stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnikIzBaze)) {
			ukupanIznos += (sk.getPicaId().getCena() * sk.getKolicina());
		}

		model.addAttribute("listaStavkiKorpe", stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnikIzBaze));

		korisnik.setIme(korisnikIzBaze.getIme());
		korisnik.setPrezime(korisnikIzBaze.getPrezime());
		
		model.addAttribute("korisnik", korisnik);
		model.addAttribute("ukupanIznos", ukupanIznos);
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		model.addAttribute("datum", dateFormat.format(new Date()));

		return "racun";
	}

	@RequestMapping(value = "/kupovina", method = RequestMethod.POST)
	public String kupovina(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result, Model model,
			HttpServletRequest request) {

		Porudzbina porudzbina = new Porudzbina();
		porudzbina.setTelefon(korisnik.getTelefon());
		porudzbina.setAdresa(korisnik.getAdresa());
		porudzbina.setDatum(new Date());
		korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		porudzbina.setKorisnikId(korisnik);

		int porudzbinaId = porudzbinaDao.sacuvajPorudzbinu(porudzbina);
		porudzbina = porudzbinaDao.getPorudzbinaById(porudzbinaId);

		List<StavkaKorpe> listaStavkiKorpe = stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnik);
		for (StavkaKorpe sk : listaStavkiKorpe) {
			StavkaPorudzbine sp = new StavkaPorudzbine();
			sp.setKolicina(sk.getKolicina());
			sp.setPicaId(sk.getPicaId());
			sp.setPorudzbinaId(porudzbina);
			sp.setUkupanIznos(sp.getPicaId().getCena() * sp.getKolicina());

			stavkaPorudzbineDao.sacuvajStavkuPorudzbine(sp);
			stavkaKorpeDao.obrisiStavkuKorpeById(sk.getId());
		}

		String postovani = "";
		if (korisnik.getPol().equals("Muški")) {
			postovani = "Poštovani";
		} else if (korisnik.getPol().equals("Ženski")) {
			postovani = "Poštovana";
		} else {
			postovani = "Poštovani/a";
		}

		model.addAttribute("postovani", postovani);
		model.addAttribute("korisnik", korisnik);

		return "kupovina";
	}

	

}
