package org.iftm.veterinario.control;

import java.util.List;
import java.util.Optional;

import org.iftm.veterinario.model.Veterinario;
import org.iftm.veterinario.model.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	// O método abaixo faz injeção de dependência da classe Repository
	@Autowired
	private VeterinarioRepository vetRepository;
	
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Veterinario> veterinarios;
		veterinarios = vetRepository.findAll();
		model.addAttribute("veterinarios", veterinarios);
		
		return "home";
	}

}

