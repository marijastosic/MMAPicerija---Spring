package com.demo.mmapicerija.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.mmapicerija.dao.KorisnikDAO;
import com.demo.mmapicerija.dao.PicaDAO;
import com.demo.mmapicerija.dao.StavkaKorpeDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.StavkaKorpe;

@Controller
public class KorpaController {

	@Autowired
	private PicaDAO picaDao;

	@Autowired
	private KorisnikDAO korisnikDao;

	@Autowired
	private StavkaKorpeDAO stavkaKorpeDao;

	@RequestMapping(value = "/dodajUKorpu/{id}", method = RequestMethod.POST)
	public String dodajUKorpu(@Valid @ModelAttribute("stavkaKorpe") StavkaKorpe stavkaKorpe,
			@PathVariable(value = "id") int id, BindingResult result, Model model, HttpServletRequest request) {
		Pica pica = picaDao.getAktivnaPicaById(id);
		stavkaKorpe.setPicaId(pica);

		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());

		stavkaKorpe.setKorisnikId(korisnik);

		StavkaKorpe stavkaIzBaze = stavkaKorpeDao.vratiStavkuZaPicuIKorisnika(pica, korisnik);

		if (stavkaIzBaze != null) {
			stavkaIzBaze.setKolicina(stavkaIzBaze.getKolicina() + stavkaKorpe.getKolicina());
			stavkaKorpeDao.azurirajStavku(stavkaIzBaze);
		} else {
			stavkaKorpeDao.sacuvajStavkuKorpe(stavkaKorpe);
		}

		StavkaKorpe stavkaKorpeNova = new StavkaKorpe();
		stavkaKorpeNova.setKolicina(1);
		model.addAttribute("pica", stavkaKorpe.getPicaId());
		model.addAttribute("stavkaKorpe", stavkaKorpeNova);

		return "detalji";
	}

	@RequestMapping(value = "/korpa", method = RequestMethod.GET)
	public String korpa(Model model, HttpServletRequest request) {
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		List<StavkaKorpe> listaStavkiKorpe = stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnik);

		double ukupanIznos = 0;

		for (StavkaKorpe sk : listaStavkiKorpe) {
			ukupanIznos += (sk.getPicaId().getCena() * sk.getKolicina());
		}
		model.addAttribute("ukupanIznos", ukupanIznos);
		model.addAttribute("listaStavkiKorpe", listaStavkiKorpe);

		return "korpa";
	}

	@RequestMapping(value = "/ocistiKorpu", method = RequestMethod.GET)
	public String ocistiKorpu(Model model, HttpServletRequest request) {
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		stavkaKorpeDao.ocistiKorpu(korisnik);
		model.addAttribute("ukupanIznos", 0.0);
		return "korpa";
	}

	@RequestMapping(value = "/obrisiStavku/{id}", method = RequestMethod.GET)
	public String obrisiStavkuPoId(@PathVariable(value = "id") int id, Model model, HttpServletRequest request) {
		stavkaKorpeDao.obrisiStavkuKorpeById(id);
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		List<StavkaKorpe> listaStavkiKorpe = stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnik);
		double ukupanIznos = 0.0;

		for (StavkaKorpe sk : listaStavkiKorpe) {
			ukupanIznos += (sk.getPicaId().getCena() * sk.getKolicina());
		}
		model.addAttribute("ukupanIznos", ukupanIznos);
		model.addAttribute("listaStavkiKorpe", listaStavkiKorpe);
		return "korpa";
	}

}
