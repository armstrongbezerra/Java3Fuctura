package br.com.fuctura;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import br.com.fuctura.model.Jogador;

@SpringBootApplication
public class OlaMundoApplication {

	public static void main(String[] args) {
		
		//aqui representa como se tivesse no conteiner
		ApplicationContext context = SpringApplication.run(OlaMundoApplication.class, args);
		
		Jogador j = context.getBean(Jogador.class);
		
		System.out.println("J:" + j.getNome());
		
	}
	
	@Bean
	public Jogador getBean() {
		Jogador j = new Jogador("Sou um Bean"); //daqui vai ser salvo no construtor em jogador
		return j;
	}
	
}
