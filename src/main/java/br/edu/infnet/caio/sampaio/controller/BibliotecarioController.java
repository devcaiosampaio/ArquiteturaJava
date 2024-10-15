package br.edu.infnet.caio.sampaio.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.caio.sampaio.model.service.BibliotecarioService;
import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;

@RestController
public class BibliotecarioController {
	@Autowired
	private BibliotecarioService bibliotecarioService;
	
	@GetMapping(value = "/lista/bibliotecario")
	public Collection<Bibliotecario> obterLista() {
		return bibliotecarioService.obterLista();
	}

}
