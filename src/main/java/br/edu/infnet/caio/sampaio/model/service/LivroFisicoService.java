package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.exceptions.PublicacaoNaoEncontradaException;
import br.edu.infnet.caio.sampaio.model.domain.LivroFisico;
import br.edu.infnet.caio.sampaio.model.repository.ILivroFisicoRepository;

@Service
public class LivroFisicoService {
	
	@Autowired
	private ILivroFisicoRepository livroFisicoRepository;	

	public Collection<LivroFisico> obterLista(){
		return (Collection<LivroFisico>) livroFisicoRepository.findAll();
	}
	
	public void incluir(LivroFisico livroFisico) {
		livroFisicoRepository.save(livroFisico);
	}
	
	public LivroFisico alterar(LivroFisico livroFisico) {
		
		if(!livroFisicoRepository.existsById(livroFisico.getId())) {
			throw new PublicacaoNaoEncontradaException(Constantes.MSG_PUBLICACAO_NOT_FOUND);
		}
		
		return livroFisicoRepository.save(livroFisico);
	}
	
	public long obterQtde() {
		return livroFisicoRepository.count();
	}
}
