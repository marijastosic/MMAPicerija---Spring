package com.demo.mmapicerija.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/oNama", method = RequestMethod.GET)
	public String oNama() {
		return "oNama";
	}

	@RequestMapping(value = "/kontakt", method = RequestMethod.GET)
	public String kontakt() {
		return "kontakt";
	}
	
	@RequestMapping(value = "/zabranjenPristup", method = RequestMethod.GET)
	public String zabranjenPristup() {
		return "zabranjenPristup";
	}

}
