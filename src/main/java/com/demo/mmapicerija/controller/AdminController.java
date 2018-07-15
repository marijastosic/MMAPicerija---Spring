package com.demo.mmapicerija.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.mmapicerija.dao.PicaDAO;
import com.demo.mmapicerija.dao.PorudzbinaDAO;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.Porudzbina;
import com.demo.mmapicerija.entities.StavkaKorpe;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PicaDAO picaDao;

	@Autowired
	private PorudzbinaDAO porudzbinaDao;

	@RequestMapping(value = "/meni", method = RequestMethod.GET)
	public String meni(Model model) {
		List<Pica> listaPica = picaDao.getListaSvihPica();
		model.addAttribute("listaPica", listaPica);

		return "meni";
	}

	@RequestMapping(value = "/meni/{id}", method = RequestMethod.GET)
	public String prikazDetalja(@PathVariable(value = "id") int id, Model model) {
		Pica pica = picaDao.getPicaById(id);

		StavkaKorpe stavkaKorpe = new StavkaKorpe();
		stavkaKorpe.setKolicina(1);

		model.addAttribute("pica", pica);
		model.addAttribute("stavkaKorpe", stavkaKorpe);

		return "detalji";
	}

	@RequestMapping(value = "/dodajPicu", method = RequestMethod.GET)
	public String dodajPicu(Model model) {
		Pica pica = new Pica();
		model.addAttribute("pica", pica);
		model.addAttribute("dodajIzmeni", "Dodaj picu");
		model.addAttribute("dodavanjeIzmenaNaslov", "Dodavanje nove pice");
		return "dodajIzmeniPicu";
	}

	@RequestMapping(value = "/izmeniPicu/{id}", method = RequestMethod.GET)
	public String izmeniPicu(@PathVariable(value = "id") int id, Model model) {
		Pica pica = picaDao.getPicaById(id);
		model.addAttribute("pica", pica);
		model.addAttribute("dodajIzmeni", "Izmeni picu");
		model.addAttribute("dodavanjeIzmenaNaslov", "Izmena pice");
		return "dodajIzmeniPicu";
	}

	@RequestMapping(value = "/dodajIzmeniPicu", method = RequestMethod.POST)
	public String dodajIzmeniPicu(@Valid @ModelAttribute("pica") Pica pica, BindingResult result, Model model) {
		picaDao.dodajIzmeniPicu(pica);

		List<Pica> listaPica = picaDao.getListaSvihPica();
		model.addAttribute("listaPica", listaPica);

		return "meni";
	}

	@RequestMapping(value = "/obrisiPicu/{id}", method = RequestMethod.GET)
	public String obrisiPicu(@PathVariable(value = "id") int id, Model model) {
		picaDao.obrisiPicuById(id);

		List<Pica> listaPica = picaDao.getListaSvihPica();
		model.addAttribute("listaPica", listaPica);
		return "meni";
	}

	@RequestMapping(value = "/svePorudzbine", method = RequestMethod.GET)
	public String svePorudzbine(Model model) {
		List<Porudzbina> listaPorudzbina = porudzbinaDao.getSvePorudzbine();
		model.addAttribute("listaPorudzbina", listaPorudzbina);
		return "svePorudzbine";
	}

	@RequestMapping(value = "/porudzbina/{id}", method = RequestMethod.GET)
	public String detaljiPorudzbine(@PathVariable(value = "id") int id, Model model) {
		Porudzbina porudzbina = porudzbinaDao.getPorudzbinaById(id);
		model.addAttribute("porudzbina", porudzbina);
		return "detaljiPorudzbine";
	}
}
