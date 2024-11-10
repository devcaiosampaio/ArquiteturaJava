package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.exceptions.PublicacaoNaoEncontradaException;
import br.edu.infnet.caio.sampaio.model.domain.LivroDigital;
import br.edu.infnet.caio.sampaio.model.repository.ILivroDigitalRepository;

@Service
public class LivroDigitalService {
	
	@Autowired
	private ILivroDigitalRepository livroDigitalRepository;	

	public Collection<LivroDigital> obterLista(){
		return (Collection<LivroDigital>) livroDigitalRepository.findAll();
	}
	
	public void incluir(LivroDigital livroDigital) {
		livroDigitalRepository.save(livroDigital);
	}
	public LivroDigital alterar(LivroDigital livroDigital) {
		
		if(!livroDigitalRepository.existsById(livroDigital.getId())) {
			throw new PublicacaoNaoEncontradaException(Constantes.MSG_PUBLICACAO_NOT_FOUND);
		}
		
		return livroDigitalRepository.save(livroDigital);
	}
	
	public long obterQtde() {
		return livroDigitalRepository.count();
	}
}
