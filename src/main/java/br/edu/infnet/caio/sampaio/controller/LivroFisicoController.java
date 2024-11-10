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
import br.edu.infnet.caio.sampaio.model.domain.LivroFisico;
import br.edu.infnet.caio.sampaio.model.service.LivroFisicoService;

@RestController
@RequestMapping("/livros-fisicos")
public class LivroFisicoController {
	@Autowired
	private LivroFisicoService livroFisicoService;
		
	@GetMapping
	public ResponseEntity<Collection<LivroFisico>> obterLista(){
		
		return ResponseEntity.ok(livroFisicoService.obterLista());
	}

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody LivroFisico livroFisico) {
		
		livroFisicoService.incluir(livroFisico);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@PutMapping(value = "/alterar")
	public ResponseEntity<LivroFisico> alterar(@RequestBody LivroFisico livroFisico) {
		
		LivroFisico livroFisicoAtualizado = livroFisicoService.alterar(livroFisico);
		
		return ResponseEntity.ok(livroFisicoAtualizado);
	}

}
