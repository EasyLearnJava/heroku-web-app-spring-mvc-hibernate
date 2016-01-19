package pl.napadlek.webapp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path = "/home")
	public String home(Model model) throws Exception {
		return "home";
	}
}
