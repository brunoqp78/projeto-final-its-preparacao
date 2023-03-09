package org.iftm.veterinario.control;
import java.util.Optional;

import org.iftm.veterinario.model.Veterinario;
import org.iftm.veterinario.model.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller é associada com classes que possuem métodos que processam requests (requisições) numa aplicação web.
@Controller
//@ResponseBody
//@RequestMapping("/veterinario")
public class VeterinarioController {

	@Autowired
	VeterinarioRepository vetRepositorio;
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
    @GetMapping("/form")
    public String veterinariosForm(Veterinario veterinario) {    	
        return "addVeterinarioForm";
    }
    
    @PostMapping("/add")
    public String novo(Veterinario veterinario) {
        vetRepositorio.save(veterinario);
        return "redirect:/home";
    }


	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Optional<Veterinario> veterinario = vetRepositorio.findById(id);
		if (veterinario.isPresent()) {
			vetRepositorio.delete(veterinario.get());
		}
		return "redirect:/home";
		
	}
	
    @PostMapping("update/{id}")
    public String alterarProduto(Veterinario veterinario, @PathVariable int id) {
        vetRepositorio.save(veterinario);
        return "redirect:/home";
    }
    
    @GetMapping("form/{id}")
    public String updateForm(Model model, @PathVariable int id) {
    	Optional<Veterinario> veterinario = vetRepositorio.findById(id);
    	if (veterinario.isPresent()) {
    		model.addAttribute("veterinario", veterinario.get());
    		return "atualizaVeterinarioForm";
    	}else {
    		return "redirect:/home";
    	}
    }


    
	
}
