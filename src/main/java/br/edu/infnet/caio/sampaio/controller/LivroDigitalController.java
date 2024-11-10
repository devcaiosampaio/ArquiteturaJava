package br.edu.infnet.caio.sampaio.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.model.domain.LivroDigital;
import br.edu.infnet.caio.sampaio.model.service.LivroDigitalService;

@RestController
@RequestMapping("/livros-digitais")
public class LivroDigitalController {
	@Autowired
	private LivroDigitalService livroDigitalService;
		
	@GetMapping
	public ResponseEntity<Collection<LivroDigital>> obterLista(){
		
		return ResponseEntity.ok(livroDigitalService.obterLista());
	}

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody LivroDigital livroDigital) {
		
		livroDigitalService.incluir(livroDigital);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@PutMapping(value = "/alterar")
	public ResponseEntity<LivroDigital> alterar(@RequestBody LivroDigital livroDigital) {
		
		LivroDigital livroDigitalAtualizado = livroDigitalService.alterar(livroDigital);
		
		return ResponseEntity.ok(livroDigitalAtualizado);
	}

}
