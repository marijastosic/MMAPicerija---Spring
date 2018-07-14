package com.demo.mmapicerija.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.mmapicerija.dao.PicaDAO;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.StavkaKorpe;

@Controller
public class MeniController {
		
	@Autowired
	private PicaDAO picaDao;
		
	@RequestMapping(value = "/meni", method = RequestMethod.GET)
	public String meni(Model model) {		
		List<Pica> listaPica = picaDao.getListaSvihAktivnihPica();
		model.addAttribute("listaPica", listaPica);

		return "meni";
	}
	
	@RequestMapping(value = "/meni/{id}", method = RequestMethod.GET)
	public String prikazDetalja(@PathVariable(value = "id") int id, Model model) {
		Pica pica = picaDao.getAktivnaPicaById(id);
				
		StavkaKorpe stavkaKorpe = new StavkaKorpe();
		stavkaKorpe.setKolicina(1);
		
		model.addAttribute("pica", pica);
		model.addAttribute("stavkaKorpe", stavkaKorpe);
				
		return "detalji";
	}	
	
}
