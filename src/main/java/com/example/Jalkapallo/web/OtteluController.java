package com.example.Jalkapallo.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Jalkapallo.domain.KenttaRepository;
import com.example.Jalkapallo.domain.Ottelu;
import com.example.Jalkapallo.domain.OtteluRepository;

@Controller
public class OtteluController {

	@Autowired
	private OtteluRepository repository;

	@Autowired
	private KenttaRepository krepository;

	@RequestMapping(value = { "/", "/ottelulista" })
	public String otteluList(Model model) {
		model.addAttribute("ottelut", repository.findAll());
		return "ottelulista";
	}

	// Rest-palvelu saadakseen kaikki ottelun
	@RequestMapping(value = "/ottelut", method = RequestMethod.GET)
	public @ResponseBody List<Ottelu> otteluListRest() {
		return (List<Ottelu>) repository.findAll();
	}

	// Rest-palvelu saadakseen ottelu ID:llä
	@RequestMapping(value = "/ottelu/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Ottelu> findOtteluRest(@PathVariable("id") int otteluId) {
		return repository.findById(otteluId);
	}

	// Lisää ottelu
	@RequestMapping("/lisaa")
	public String lisaaOttelu(Model model) {
		model.addAttribute("ottelu", new Ottelu());
		model.addAttribute("kentat", krepository.findAll());
		return "addottelu.html";
	}

	// Tallenna ottelu
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	public String tallenna(Ottelu ottelu) {
		repository.save(ottelu);
		return "redirect:ottelulista";
	}

	// Poista ottelu
	@RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
	public String poistaOttelu(@PathVariable("id") Long otteluId, Model model) {
		repository.deleteById(otteluId);
		return "redirect:../ottelulista";
	}



}
