package br.com.fuctura.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class JogadorController {
	
	@GetMapping ("/jogador/cadastrar")
	public String getCadastrar(Model model) {
		return "cadastrar";
		
	}
	
	@GetMapping ("/jogador/listar")
	public String getListar(Model model) {
		return "listar";
		
	}
	
	@GetMapping ("/jogador/atualizar")
	public String getAtualizar(Model model) {
		return "atualizar";
		
	}
	
	@GetMapping ("/jogador/excluir")
	public String getExcluir(Model model) {
		return "excluir";
		
	}




}
