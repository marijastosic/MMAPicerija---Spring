package com.demo.mmapicerija;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.mmapicerija.dao.KorisnikDAO;
import com.demo.mmapicerija.dao.PicaDAO;
import com.demo.mmapicerija.dao.StavkaKorpeDAO;
import com.demo.mmapicerija.entities.Korisnik;
import com.demo.mmapicerija.entities.Pica;
import com.demo.mmapicerija.entities.StavkaKorpe;
import com.demo.mmapicerija.entities.StavkaPorudzbine;
import com.demo.mmapicerija.service.MailService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PicaDAO picaDao;
	
	@Autowired
	private KorisnikDAO korisnikDao;
	
	@Autowired
	private StavkaKorpeDAO stavkaKorpeDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/oNama", method = RequestMethod.GET)
	public String oNama(Model model) {	
		return "oNama";
	}
	
	@RequestMapping(value = "/kontakt", method = RequestMethod.GET)
	public String kontakt(Model model) {		
		return "kontakt";
	}
	
	@RequestMapping(value = "/meni", method = RequestMethod.GET)
	public String meni(Model model) {		
		List<Pica> listaPica = picaDao.getListaSvihAktivnihPica();
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
	
	@RequestMapping(value = "/dodajUKorpu/{id}", method = RequestMethod.POST)
	public String dodajUKorpu(@Valid @ModelAttribute("stavkaKorpe") StavkaKorpe stavkaKorpe, @PathVariable(value = "id") int id, BindingResult result, Model model, HttpServletRequest request) {
		Pica pica = picaDao.getPicaById(id);
		stavkaKorpe.setPicaId(pica);
		
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
		
		stavkaKorpe.setKorisnikId(korisnik);
		
		stavkaKorpeDao.sacuvajStavkuKorpe(stavkaKorpe);
		
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
		model.addAttribute("listaStavkiKorpe", listaStavkiKorpe);
		return "korpa";
	}

	@RequestMapping(value = "/ocistiKorpu", method = RequestMethod.GET)
	public String ocistiKorpu(Model model, HttpServletRequest request) {
		Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
	    stavkaKorpeDao.ocistiKorpu(korisnik);
		return "korpa";
	}
	@RequestMapping(value = "/obrisiStavku/{id}", method = RequestMethod.GET)
	public String obrisiStavkuPoId(@PathVariable(value = "id") int id, Model model, HttpServletRequest request) {
	    stavkaKorpeDao.obrisiStavkuKorpeById(id);
	    Korisnik korisnik = korisnikDao.getKorisnikByUsername(request.getUserPrincipal().getName());
	    List<StavkaKorpe> listaStavkiKorpe = stavkaKorpeDao.procitajSveIzStavkeKorpe(korisnik);
		model.addAttribute("listaStavkiKorpe", listaStavkiKorpe);
		return "korpa";
	}
	
	@RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Pogrešni username i/ili password.");
        }

        if (logout != null) {
            model.addAttribute("msg", "Uspešno ste se odjavili.");
        }
        return "login";
    }
		
	
	@RequestMapping(value = "/registracija", method = RequestMethod.GET)
	public String registracija(Model model) {
		Korisnik korisnik = new Korisnik();
		model.addAttribute("korisnik", korisnik);
		
		return "registracija";
	}
	
	@RequestMapping(value = "/registracija", method = RequestMethod.POST)
	public String registracijaPost(@Valid @ModelAttribute("korisnik") Korisnik korisnik, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "registracija";
		}
		
		Korisnik postojeciKorisnikSaEmailom = korisnikDao.getKorisnikByEmail(korisnik.getEmail());
		Korisnik postojeciKorisnikSaUsername = korisnikDao.getKorisnikByUsername(korisnik.getUsername());
		
		if(postojeciKorisnikSaEmailom != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim email-om!");
			return "registracija";
		}
		
		if(postojeciKorisnikSaUsername != null) {
			model.addAttribute("error", "Postoji korisnik sa unetim username-om!");
			return "registracija";
		}
		
		korisnikDao.dodajKorisnika(korisnik);
		
		model.addAttribute("msg", "Uspešno ste izvršili registraciju. Molimo Vas da se ulogujete:");
		model.addAttribute("username", korisnik.getUsername());
		return "login";
	}
}
