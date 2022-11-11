package org.iftm.veterinario.control;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller é associada com classes que possuem métodos que processam requests (requisições) numa aplicação web.
@Controller
//@ResponseBody
//@RequestMapping("/veterinario")
public class VeterinarioController {

	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
}
