package br.edu.infnet.caio.sampaio.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.caio.sampaio.model.service.BibliotecarioService;
import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.model.domain.Bibliotecario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {

	@Autowired
	private BibliotecarioService bibliotecarioService;
	
	@Operation(summary = "Recupera todos os bibliotecarios existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Collection<Bibliotecario>> obterLista(){		
		return ResponseEntity.ok(bibliotecarioService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo bibliotecario.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Bibliotecario Bibliotecario) {
		
		bibliotecarioService.incluir(Bibliotecario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um bibliotecario através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(bibliotecarioService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_BIBLIOTECARIO_NOT_FOUND);
	}
	
	@Operation(summary = "Busca um bibliotecario através do nome.")
	@GetMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Bibliotecario>> obterPorNome(@PathVariable String nome){
		
		List<Bibliotecario> Bibliotecarioes = bibliotecarioService.obterPorNome(nome);
		
		if(Bibliotecarioes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Bibliotecarioes);
		}
		
		return ResponseEntity.ok(Bibliotecarioes);
	}	
	
	@Operation(summary = "Busca um bibliotecario através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bibliotecario> obterPorId(@PathVariable Integer id) {
		
		Bibliotecario Bibliotecario = bibliotecarioService.obterPorId(id);
		
		if(Bibliotecario == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(Bibliotecario);
	}
}
