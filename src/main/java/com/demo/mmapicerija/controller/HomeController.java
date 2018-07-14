package com.demo.mmapicerija.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

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

}
