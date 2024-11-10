package br.edu.infnet.caio.sampaio.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.model.domain.Publicacao;
import br.edu.infnet.caio.sampaio.model.service.PublicacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {
	@Autowired
	private PublicacaoService publicacaoService;

	@Operation(summary = "Recupera todas as publicações existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Collection<Publicacao>> obterLista() {

		return ResponseEntity.ok(publicacaoService.obterLista());
	}

	@GetMapping(value = "/filtrarPorAutor")
	public ResponseEntity<List<Publicacao>> obterListaPorPreco(@RequestParam String autor) {
		
		List<Publicacao> publicacoes = publicacaoService.obterListaPorAutor(autor);

		if (publicacoes.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(publicacoes);
		}

		return ResponseEntity.ok(publicacoes);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {

		if(publicacaoService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_PUBLICACAO_NOT_FOUND);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Publicacao> obterPorId(@PathVariable Integer id) {
		Publicacao publicacao = publicacaoService.obterPorId(id);
		
		if(publicacao == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(publicacao);
	}

	@PatchMapping(value = "/alterar")
	public ResponseEntity<Publicacao> alterar(@RequestParam Integer id, @RequestParam String editora) {

		Publicacao PublicacaoAtualizado = publicacaoService.alterarEditora(id, editora);

		return ResponseEntity.ok(PublicacaoAtualizado);
	}
}
