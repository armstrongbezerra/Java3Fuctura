package br.com.fuctura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fuctura.model.Jogador;
import br.com.fuctura.repository.JogadorRepository;

@Controller
public class JogadorController {
	
	@Autowired
	JogadorRepository repo;
	
	@Autowired
	Jogador j;
	
	
	
	@GetMapping ("/jogador/listar")
	public String getListar(Model model) {
		
		//consutar na base um jogador por 1 id que pode ser opicional
		Optional<Jogador> umJogador = repo.findById(1L);  //o L é do Long na classe jogador (id)
		if(umJogador.isPresent()) {
			model.addAttribute("JogadorEnontrado", umJogador.get());
		}
		
		//consultar na base todos os jogadores
		List<Jogador> j = repo.findAll();
			
		model.addAttribute("Jogadores", j);
		return "/jogador/listar";
		
	}
	
	@GetMapping ("/jogador/atualizar")
	public String getAtualizar(Model model) {
		return "/jogador/atualizar";
		
	}
	
	@GetMapping ("/jogador/excluir")
	public String getExcluir(Model model) {
		return "/jogador/excluir";
		
	}
	
	@GetMapping ("/jogador/listar/todas")
	public String getListarTodas(Model model) {
		return "/jogador/listar";
		
	}
	
	@GetMapping ("/teste")
	public String testeDeBean() {
		System.out.println(j.getNome()); //tem que imprimir "eu sou um bean"
		return "/v1/jogador/atualizar";
	}
	
	@GetMapping ("/v1/jogador/cadastrar")
	public String cadastrar() {
		return "/v1/jogador/cadastrar"; //templates/jogador/cadastrar.html
	}
	
	//este método vai receber os dados do formulário
	@PostMapping ("/v1/jogador/cadastrar")
	public String cadastrar(@RequestParam("idade") int idade, @RequestParam(name = "name") String nome) {
		
				System.out.println("nome:" + nome);
				System.out.println("idade:" + idade);
				
				Jogador j = new Jogador();
				j.setIdade(idade);
				j.setNome(nome);
				
				//salvar no banco de dados
				repo.save(j);

				return "/v1/jogador/cadastrar";
		
	}
	
	@GetMapping ("/v2/jogador/cadastrar")
	public String cadastrarV2(Model model) {
		Jogador jogador = new Jogador();
		model.addAttribute("jogador", jogador);
		return "/v2/jogador/cadastrar";  
	}
	
	//rota utilizando o thymeleaf
	@PostMapping("/v2/jogador/cadastrar")
	public String cadastrarV2(@ModelAttribute("jogador") Jogador j) {
		System.out.println(j.getNome());
		return "/v2/jogador/cadastrar";
	}
	
	public String remover() {
		return "/v1/jogador/remover";
	}
	
	public String atualizar() {
		return "/v1/jogador/atualizar";
	}
	
	




}
