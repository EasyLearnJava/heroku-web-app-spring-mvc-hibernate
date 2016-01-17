package pl.napadlek.webapp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.napadlek.webapp.Author;

@Controller
public class HomeController {

	@Autowired
	private Author author;
	
	@RequestMapping(path = "/home")
	public String home(Model model) throws Exception {
		model.addAttribute("author", author);
		return "home";
	}
}
