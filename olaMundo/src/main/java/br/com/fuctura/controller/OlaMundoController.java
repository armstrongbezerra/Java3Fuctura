package br.com.fuctura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fuctura.model.Jogador;

@Controller
public class OlaMundoController {
	
	@GetMapping ("/inicial")
	public String getInicial(Model model) {
		
		Jogador j = new Jogador();
		
		j.setNome("Ronaldo");
		j.setIdade(33);
		j.setAltura(1.79);
		j.setPeso(86);
		j.setImg("https://static-img.zz.pt/history/imgS620I11648T20190508162847.jpg");
		
		model.addAttribute("jogador", j);
		model.addAttribute("TituloDaPagina", "Fuctura");
			
		return "inicial";
	}
	
	@GetMapping ("/outra")
	public String getOutra() {
		return "outra";
	}
}
