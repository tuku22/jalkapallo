package com.example.Jalkapallo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Jalkapallo.domain.Ottelu;
import com.example.Jalkapallo.domain.OtteluRepository;

@Controller
public class JalkapalloController {
	@Autowired
	private OtteluRepository repository;
	
	@RequestMapping(value= "/ottelulista")
	public String otteluList(Model model) {
	model.addAttribute("ottelut", repository.findAll());
	return "ottelulist";
	}
	
	//Rest-palvelu saadakseen kaikki ottelun
	 @RequestMapping(value="/ottelut", method = RequestMethod.GET)
	 public @ResponseBody List<Ottelu> otteluListRest() {
		 return (List<Ottelu>) repository.findAll();
	 }
	 
	 //Rest-palvelu saadakseen ottelu ID:llä
	  @RequestMapping(value="/ottelu/{id}", method= RequestMethod.GET)
	  public @ResponseBody Optional<Ottelu> findOtteluRest(@PathVariable("id") Long otteluId) {
		  return repository.findById(otteluId);
	  }
	 
	 //Lisää ottelu
	  @RequestMapping("/lisaa")
	  public String lisaaOttelu(Model model) {
		  model.addAttribute("ottelu", new Ottelu());
		  return "lisaaottelu.html";
	  }
	  
	  //Tallenna ottelu
	  @RequestMapping(value = "/tallenna", method = RequestMethod.POST)
	  public String tallenna (Ottelu ottelu) {
		  repository.save(ottelu);
		  return "redirect:ottelulist";
	  }
	 
	 //Poista ottelu
	  @RequestMapping(value = "/poista", method = RequestMethod.GET)
	  public String poistaOttelu(@PathVariable("id") Long otteluId, Model model) {
	  repository.deleteById(otteluId);
	  return "redirect:../ottelulist";
	  }
	  
	  //Muokkaa ottelua
	  @RequestMapping("/muokkaa/{id}")
	  public String muokkaaOttelu(@PathVariable("id") Long otteluId, Model model) {
		  model.addAttribute("ottelu", repository.findById(otteluId));
		  return "muokkaaottelu.html";
	  }
	  

}
	 
	 
	 

