package br.edu.infnet.caio.sampaio.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.caio.sampaio.Constantes;
import br.edu.infnet.caio.sampaio.exceptions.PublicacaoNaoEncontradaException;
import br.edu.infnet.caio.sampaio.model.domain.Publicacao;
import br.edu.infnet.caio.sampaio.model.repository.IPublicacaoRepository;

@Service
public class PublicacaoService {

	@Autowired
	private IPublicacaoRepository publicacaoRepository;	

	public Collection<Publicacao> obterLista(){
		return (Collection<Publicacao>) publicacaoRepository.findAll();
	}
	
	public void incluir(Publicacao produto) {
		publicacaoRepository.save(produto);
	}
	
	public List<Publicacao> obterListaPorAutor(String autor){
		return publicacaoRepository.findByAutor(autor);
	}

	public long obterQtde() {
		return publicacaoRepository.count();
	}

	public boolean excluir(Integer id) {
		publicacaoRepository.deleteById(id);	
		return true;
	}

	public Publicacao obterPorId(Integer id) {
		return publicacaoRepository.findById(id).orElse(null);
	}

	public Publicacao alterarEditora(Integer id, String editora) {
		
		Publicacao publicacaoExistente = publicacaoRepository.findById(id).orElseThrow(() -> 
			new PublicacaoNaoEncontradaException(Constantes.MSG_PUBLICACAO_NOT_FOUND));
		
		publicacaoExistente.setEditora(editora);
		
		return publicacaoRepository.save(publicacaoExistente);
	}
}
